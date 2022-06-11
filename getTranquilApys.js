const BigNumber = require('bignumber.js');
const { oneWeb3: web3 } = require('../../../utils/web3');

const fetchPrice = require('../../../utils/fetchPrice');
const { compound } = require('../../../utils/compound');
const Comptroller = require('../../../abis/harmony/Comptroller.json');
const TqToken = require('../../../abis/TqToken.json');
const pools = require('../../../data/one/tranquilLpPools.json');
const getBlockTime = require('../../../utils/getBlockTime');
const { BASE_HPY, ONE_CHAIN_ID: chainId } = require('../../../constants');

const COMPTROLLER = '0x6a82A17B48EF6be278BBC56138F35d04594587E3';

const getTranquilApys = async () => {

  let apys = {};
  let promises = [];
  pools.forEach(pool => promises.push(getPoolApy(pool)));
  const values = await Promise.all(promises);
  for (let item of values)
  {
    apys = { ...apys, ...item };
  }
  return apys;
};

const getPoolApy = async pool => {
  const secondsPerBlock = await Promise.all([getBlockTime(chainId)]);
  const BLOCKS_PER_YEAR = 31536000 / secondsPerBlock;
  const [{ supplyBase, supplyVxs }, { borrowBase, borrowVxs }] = await Promise.all([
    getSupplyApys(pool, BLOCKS_PER_YEAR),
    getBorrowApys(pool, BLOCKS_PER_YEAR),
  ]);

  const { leveragedSupplyBase, leveragedBorrowBase, leveragedSupplyVxs, leveragedBorrowVxs } =
    getLeveragedApys(
      supplyBase,
      borrowBase,
      supplyVxs,
      borrowVxs,
      pool.borrowDepth,
      pool.borrowPercent
    );

  const totalVxs = leveragedSupplyVxs.plus(leveragedBorrowVxs);
  const compoundedVxs = compound(totalVxs, BASE_HPY, 1, 0.955);
  const apy = leveragedSupplyBase.minus(leveragedBorrowBase).plus(compoundedVxs).toNumber();

  return { [pool.name]: apy };
};

const getSupplyApys = async (pool, BLOCKS_PER_YEAR) => {
  const tqTokenContract = new web3.eth.Contract(TqToken, pool.tqToken);
  const comptrollerContract = new web3.eth.Contract(Comptroller, COMPTROLLER);
  let [tranqPrice, tokenPrice, supplyRate, compRate, totalSupply, exchangeRateStored] =
    await Promise.all([
      fetchPrice({ oracle: 'tokens', id: 'TRANQ' }),
      fetchPrice({ oracle: pool.oracle, id: pool.oracleId }),
      tqTokenContract.methods.supplyRatePerTimestamp().call(),
      comptrollerContract.methods.rewardSpeeds(0, pool.tqToken).call(),
      tqTokenContract.methods.totalSupply().call(),
      tqTokenContract.methods.exchangeRateStored().call(),
    ]);

  supplyRate = new BigNumber(supplyRate);
  compRate = new BigNumber(compRate);
  totalSupply = new BigNumber(totalSupply);
  exchangeRateStored = new BigNumber(exchangeRateStored);
  const supplyApyPerYear = supplyRate.times(BLOCKS_PER_YEAR).div('1e18');
  const compPerYear = compRate.times(BLOCKS_PER_YEAR);
  const compPerYearInUsd = compPerYear.div('1e18').times(tranqPrice);
  const totalSupplied = totalSupply.times(exchangeRateStored).div('1e18');
  const totalSuppliedInUsd = totalSupplied.div(pool.decimals).times(tokenPrice);
  return {
    supplyBase: supplyApyPerYear,
    supplyVxs: compPerYearInUsd.div(totalSuppliedInUsd),
  };
};

const getBorrowApys = async (pool, BLOCKS_PER_YEAR) => {
  const comptrollerContract = new web3.eth.Contract(Comptroller, COMPTROLLER);
  const tqTokenContract = new web3.eth.Contract(TqToken, pool.tqToken);

  let [tranqPrice, tokenPrice, borrowRate, compRate, totalBorrows] = await Promise.all([
    fetchPrice({ oracle: 'tokens', id: 'TRANQ' }),
    fetchPrice({ oracle: pool.oracle, id: pool.oracleId }),
    tqTokenContract.methods.borrowRatePerTimestamp().call(),
    comptrollerContract.methods.rewardSpeeds(0, pool.tqToken).call(),
    tqTokenContract.methods.totalBorrows().call(),
  ]);
  borrowRate = new BigNumber(borrowRate);
  compRate = new BigNumber(compRate);
  totalBorrows = new BigNumber(totalBorrows);
  const borrowApyPerYear = borrowRate.times(BLOCKS_PER_YEAR).div('1e18');
  const compPerYear = compRate.times(BLOCKS_PER_YEAR);
  const compPerYearInUsd = compPerYear.div('1e18').times(tranqPrice);
  const totalBorrowsInUsd = totalBorrows.div(pool.decimals).times(tokenPrice);
  return {
    borrowBase: borrowApyPerYear,
    borrowVxs: compPerYearInUsd.div(totalBorrowsInUsd),
  };
};

const getLeveragedApys = (supplyBase, borrowBase, supplyVxs, borrowVxs, depth, borrowPercent) => {
  borrowPercent = new BigNumber(borrowPercent);
  let leveragedSupplyBase = new BigNumber(0);
  let leveragedBorrowBase = new BigNumber(0);
  let leveragedSupplyVxs = new BigNumber(0);
  let leveragedBorrowVxs = new BigNumber(0);

  for (let i = 0; i < depth; i++)
  {
    leveragedSupplyBase = leveragedSupplyBase.plus(
      supplyBase.times(borrowPercent.exponentiatedBy(i))
    );
    leveragedSupplyVxs = leveragedSupplyVxs.plus(supplyVxs.times(borrowPercent.exponentiatedBy(i)));
    leveragedBorrowBase = leveragedBorrowBase.plus(
      borrowBase.times(borrowPercent.exponentiatedBy(i + 1))
    );
    leveragedBorrowVxs = leveragedBorrowVxs.plus(
      borrowVxs.times(borrowPercent.exponentiatedBy(i + 1))
    );
  }
  return {
    leveragedSupplyBase,
    leveragedBorrowBase,
    leveragedSupplyVxs,
    leveragedBorrowVxs,
  };
};

module.exports = getTranquilApys;
