import java.util.HashMap;

public class FrequencyOfNumber {
    // count of all number;
    public int[] count(int arr[]) {
        
        int max = MinMax.getMax(arr);
        int[] count = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        return count;
    }

    static int countOfNumber(int arr[], int n) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                count++;
            }
        }
        return count;
    }

    static HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

    static void countFreq(int arr[], int n) {
        // Insert elements and their
        // frequencies in hash map.
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(arr[i]))
                // if element is already present update value by 1
                hm.put(arr[i], hm.get(arr[i]) + 1);
            else
                // if element not present initilize key with 1
                hm.put(arr[i], 1);
        }
    }

    static int query(int x) {
        if (hm.containsKey(x))
            return hm.get(x);
        return 0;
    }

    static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String arg[]) {
        // FrequencyOfNumber f = new FrequencyOfNumber();
        int a[] = { 0, 5, 5, 5, 4 };
        int n = a.length;
       
        /**
         * Method 1 
         * int[] result = f.count(a); 
         * printArray(result);
         * 
         * METHOD 2
         * int countOfNumber = countOfNumber(a, 5);
         * System.out.println(countOfNumber);
         * 
         * METHOD 3
         * 
         */
        countFreq(a, n);
        System.out.println(query(2));
        System.out.println(query(3));
        System.out.println(query(5));

    }
}
