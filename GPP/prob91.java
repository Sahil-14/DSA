import java.util.*;

// top k most frequent element
public class prob91 {
    static void mostFrequentk(int arr[], int n,int k) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(hm.entrySet());
        // sort list
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() == o2.getValue())
                    return o2.getKey() - o1.getKey();
                else
                    return o2.getValue() - o1.getValue();
            }
        });

        for (int i = 0; i < k; i++)
            System.out.println(list.get(i).getKey());

    }

     // Driver Code
     public static void main(String[] args)
     {
         int arr[] = { 3, 1, 4, 4, 5, 2, 6, 1 };
         int n = arr.length;
         int k = 2;
           
         // Function call
         mostFrequentk(arr, n, k);
     }
}
