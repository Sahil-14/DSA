import java.util.HashMap;

// Given an unsorted array of integers, find the number of subarrays having sum exactly equal to a given number k.

public class NoOfSubarrayWithSumK {
  static subarraySumCountK(int arr[],int n,int sum){
    HashMap<Integer,Integer> hm = new HashMap<>();
    int res = 0;
    int currSum = 0;

    for(int i = 0;i<n;i++){
      currSum +=  arr[i];
      if(currSum == sum){
        res++;
      }
      if(hm.containsKey(currSum - sum)){
        res += hm.get(currSum -sum);
      }

      Integer count = hm.get(currSum);
      if(count == null){
        hm.put(currSum, 1);
      }else{
        hm.put(currSum, count+1);
      }

    }
    return res;
  }
}
