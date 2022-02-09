import java.util.HashMap;
import java.util.Map;

/**
 * 
 * * 0/1 Knapsack Problem - Given items of certain weights/values and maximum
 * allowed weight how to pick items to pick items from this set to maximize sum
 * of value of items such that sum of weights is less than or equal to maximum
 * allowed weight.
 * 
 */

public class dp_prob1 {
    public int bottomUpDP(int val[], int wt[], int W) {
        int k[][] = new int[val.length + 1][W + 1];
        for (int i = 0; i <= val.length; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    k[i][j] = 0;
                    continue;
                }
                if (j - wt[i - 1] >= 0) {
                    k[i][j] = Math.max(k[i - 1][j], k[i - 1][j - wt[i - 1]] + val[i - 1]);
                } else {
                    k[i][j] = k[i - 1][j];
                }
            }
        }
        return k[val.length][W];

    }

    // key for memoization
    class Index {
        int remainingweight;
        int remainingItems;

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Index index = (Index) o;
            if (remainingweight != index.remainingweight)
                return false;
            return remainingItems == index.remainingItems;
        }

        @Override
        public int hashCode() {
            int result = remainingweight;
            result = 31 * result + remainingItems;
            return result;
        }
    }

    public int topDownRecursive(int values[], int weight[], int W) {
        Map<Index, Integer> map = new HashMap<>();
        return topDownRecursiveUtil(values, weight, W, values.length, 0, map);
    }

    public int topDownRecursiveUtil(int values[], int weight[], int remainingweight, int totalItems, int currentItem,
            Map<Index, Integer> map) {
        if (currentItem >= totalItems || remainingweight == 0) {
            return 0;
        }
        Index key = new Index();
        key.remainingItems = totalItems - currentItem - 1;
        key.remainingweight = remainingweight;

        // see if key exist in map .if so then return the maximum value for key storoed
        // in map
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int maxValue;
        // if weight of item is more than remainingWeight then try next item by skipping
        // current item
        if (remainingweight < weight[currentItem]) {
            maxValue = topDownRecursiveUtil(values, weight, remainingweight, totalItems, currentItem + 1, map);
        } else {
            // try to get maximumValue of either by picking the currentItem or not picking
            // currentItem

            maxValue = Math.max(
                    values[currentItem] + topDownRecursiveUtil(values, weight, remainingweight - weight[currentItem],
                            totalItems, currentItem + 1, map),
                    topDownRecursiveUtil(values, weight, remainingweight, totalItems, currentItem + 1, map));
        }

        map.put(key, maxValue);
        return maxValue;

    }

    public static void main(String arg[]) {
        dp_prob1 k = new dp_prob1();
        int val[] = { 1, 4, 5, 7 };
        int wt[] = { 1, 3, 4, 5 };
        int r = k.bottomUpDP(val, wt, 7);
        int r2 = k.topDownRecursive(val, wt, 7);
        System.out.println(r);
        System.out.println(r2);
    }
}
