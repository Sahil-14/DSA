import java.util.Deque;
import java.util.LinkedList;

// Sliding window maximum
/**
 * your are given a array and k check all window = k in array and return maximum
 */
public class prob45 {
    static void printMax(int arr[], int n, int k) {
        Deque<Integer> q = new LinkedList<>();
        int i;
        /*
         * Process first k (or first window) elements of array
         */
        for (i = 0; i < k; i++) {
            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(i);
        }
        // Process rest of the elements,
        // i.e., from arr[k] to arr[n-1]
        for (; i < n; ++i) {
            System.out.print(arr[q.peek()] + " ");

            // Remove the elements which
            // are out of this window
            while ((!q.isEmpty()) && q.peek() <= i - k) {
                q.removeFirst();
            }
            // Remove all elements smaller
            // than the currently
            // being added element (remove
            // useless elements)
            while ((!q.isEmpty()) && arr[i] >= arr[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(i);
        }

        System.out.print(arr[q.peek()]);
    }

    static int maxSum(int arr[], int n, int k) {
        if (n < k) {
            System.out.println("invalid");
            return -1;
        }
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        int windowSum = maxSum;
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;

    }

    public static void main(String arg[]) {
        int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
        int k = 3;
        printMax(arr, arr.length, k);

    }
}
