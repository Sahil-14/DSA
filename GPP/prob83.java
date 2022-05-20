import java.util.*;
import java.awt.Point;

// for a given arary and  an interger k,check if any subarray of size k exist in the 
// aray such that elements in the subaray form anumber divisible by 3
public class prob83 {
    static void computeNumberFromSubarray(Vector<Integer> arr, int k) {
        int n = arr.size();
        Point ans = new Point(0, 0);
        int i, sum = 0;
        int found = 0;
        for (i = 0; i < k; i++) {
            sum += arr.get(i);
        }
        if (sum % 3 == 0) {

            ans = new Point(0, i - 1);
            found = 1;

        }

        for (int j = i; j < n; j++) {
            if (found == 1) {
                break;
            }
            sum = sum + arr.get(j) - arr.get(j - k);
            if (sum % 3 == 0) {
                ans = new Point(j - k + 1, j);
                found = 1;
            }
        }
        if (found == 0) {
            ans = new Point(-1, 0);

        } else {

            for (i = ans.x; i <= ans.y; i++) {
                System.out.print(arr.get(i) + " ");
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {

        // Given array and K
        Vector<Integer> arr = new Vector<Integer>();
        arr.add(84);
        arr.add(23);
        arr.add(45);
        arr.add(12);
        arr.add(56);
        arr.add(82);

        int K = 3;

        // Function call
        computeNumberFromSubarray(arr, K);
    }
}
