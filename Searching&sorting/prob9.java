
/**
 * 
 * // Java program to print all subarrays
 * // in the array which has sum 0
 * 
 */
import java.util.*;

class prob9 {

  // subarray-sum-equals-k
  public class Solution {
    public int subarraySum(int[] nums, int k) {
      int count = 0, sum = 0;
      HashMap<Integer, Integer> map = new HashMap<>();
      map.put(0, 1);
      for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        if (map.containsKey(sum - k))
          count += map.get(sum - k);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
      return count; 
    }

  }

  // Utility function to insert <key, value> into the multimap
  private static <K, V> void insert(Map<K, List<V>> hashMap, K key, V value) {
    // if the key is seen for the first time, initialize the list
    hashMap.putIfAbsent(key, new ArrayList<>());
    hashMap.get(key).add(value);
  }

  // Function to print all subarrays with a zero-sum in a given array
  public static void printAllSubarrays(int[] nums) {
    // create an empty multimap to store the ending index of all
    // subarrays having the same sum
    Map<Integer, List<Integer>> hashMap = new HashMap<>();

    // insert (0, -1) pair into the map to handle the case when
    // subarray with zero-sum starts from index 0
    insert(hashMap, 0, -1);

    int sum = 0;

    // traverse the given array
    for (int i = 0; i < nums.length; i++) {
      // sum of elements so far
      sum += nums[i];

      // if the sum is seen before, there exists at least one
      // subarray with zero-sum
      if (hashMap.containsKey(sum)) {
        List<Integer> list = hashMap.get(sum);

        // find all subarrays with the same sum
        for (Integer value : list) {
          System.out.println("Subarray [" + (value + 1) + "…" +
              i + "]");
        }
      }
      // insert (sum so far, current index) pair into the multimap
      insert(hashMap, sum, i);
    }
  }

  // Driver code
  public static void main(String[] args) {
    int[] nums = { 4, 2, -3, -1, 0, 4 };
    printAllSubarrays(nums);
  }

}