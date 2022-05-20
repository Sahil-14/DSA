import java.util.*;

public class prob2 {
  // public int[] topKFrequent(int[] nums, int k) {

  // }
  public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm) {
    // Create a list from elements of HashMap
    List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());

    // Sort the list
    Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
      public int compare(Map.Entry<Integer, Integer> o1,
          Map.Entry<Integer, Integer> o2) {
        return (o1.getValue()).compareTo(o2.getValue());
      }
    });

    // put data from sorted list to hashmap
    HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
    for (Map.Entry<Integer, Integer> aa : list) {
      temp.put(aa.getKey(), aa.getValue());
    }
    return temp;
  }

  public static void topKFrequentByHashing(int[] nums, int k) {
    int n = nums.length;
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i : nums) {
      if (!hm.containsKey(i)) {
        hm.put(i, 1);
      } else {
        hm.put(i, hm.get(i) + 1);
      }
    }
    HashMap<Integer, Integer> hm1 = sortByValue(hm);

    for (Map.Entry<Integer, Integer> en : hm1.entrySet()) {
      System.out.println("Key = " + en.getKey() +
          ", Value = " + en.getValue());
    }

  }

  public static int[] topKFrequent(int[] nums, int k) {

    if (k == nums.length) {
      return nums;
    }
    Map<Integer, Integer> count = new HashMap();
    for (int n : nums) {
      count.put(n, count.getOrDefault(n, 0) + 1);
    }
    // init heap 'the less frequent element first'
    Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));
    // 2. keep k top frequent elements in the heap
    // O(N log k) < O(N log N) time
    for (int n : count.keySet()) {
      heap.add(n);
      if (heap.size() > k)
        heap.poll();
    }
    // 3. build an output array
    // O(k log k) time
    int[] top = new int[k];
    for (int i = k - 1; i >= 0; i--) {
      top[i] = heap.poll();

    }
    return top;

  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 2, 3, 3, 3 };
    int res[] = topKFrequent(arr, 2);
    for (int i : res) {
      System.out.println(i);
    }
  }
}
