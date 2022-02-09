import java.util.Arrays;

/**
 * Three sum problem check whetther sum of three number is equal to target
 * 
 * 
 */
public class prob50 {
    static boolean twoPointer(int arr[], int n, int target) {
        boolean found = false;
        for (int i = 0; i < n; i++) {
            int lo = i + 1, hi = n - 1;
            while (lo < hi) {
                int current = arr[i] + arr[lo] + arr[hi];
                if (current == target) {
                    found = true;
                }
                if (current < target) {
                    lo++;
                } else {
                    hi--;
                }
            }

        }
        if(found){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 6, 9, 34, 25 };
        Arrays.sort(arr);
System.out.println(twoPointer(arr, arr.length, 24));
    }
}
