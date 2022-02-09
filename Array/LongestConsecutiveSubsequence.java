import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Given an array of integers, find the length of the longest sub-sequence such
 * that elements in the subsequence are consecutive integers, the consecutive
 * numbers can be in any order. Input: arr[] = {1, 9, 3, 10, 4, 20, 2} Output: 4
 * Explanation: The subsequence 1, 3, 4, 2 is the longest subsequence of
 * consecutive elements Method :1 Sort and check t(O) = nlon(n) Method :2
 * =Hashing Method 3: priority queue
 * 
 * 
 */
public class LongestConsecutiveSubsequence {
    static int findLongestSubsequence1(int arr[], int n) {
        Arrays.sort(arr);
        int ans = 0, count = 0;
        ArrayList<Integer> v = new ArrayList<>();
        v.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1])
                v.add(arr[i]);
        }

        for (int i = 0; i < v.size(); i++) {
            if (i > 0 && v.get(i) == v.get(i - 1) + 1)
                count++;
            else {
                count = 1;
            }
            System.out.println(v.get(i) + " :" + count);
            ans = Math.max(ans, count);
        }

        return ans;
    }

    static int findLongestSubsequence2(int arr[], int n) {
        HashSet<Integer> hs = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            hs.add(arr[i]);
        }

        for (int i = 0; i < n; ++i) {
            // if current element is the starting
            // element of a sequence
            if (!hs.contains(arr[i] - 1)) {
                int j = arr[i];
                while (hs.contains(j))
                    j++;
                if (ans < j - arr[i])

                    ans = j - arr[i];
            }
        }
        return ans;
    }

    static int findLongestSubsequence3(int arr[], int N) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < N; i++) {
            // adding element from
            // array to PriorityQueue
            pq.add(arr[i]);
        }
        Iterator iterator = pq.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
        // Storing the first element
        // of the Priority Queue
        // This first element is also
        // the smallest element
        int prev = pq.poll();

        // Taking a counter variable with value 1
        int c = 1;

        // Storing value of max as 1
        // as there will always be
        // one element
        int max = 1;

        for (int i = 1; i < N; i++) {
            // check if current peek
            // element minus previous
            // element is greater then
            // 1 This is done because
            // if it's greater than 1
            // then the sequence
            // doesn't start or is broken here
            if (pq.peek() - prev > 1) {
                // Store the value of counter to 1
                // As new sequence may begin
                c = 1;

                // Update the previous position with the
                // current peek And remove it
                prev = pq.poll();
            }

            // Check if the previous
            // element and peek are same
            else if (pq.peek() - prev == 0) {
                // Update the previous position with the
                // current peek And remove it
                prev = pq.poll();
            }
            // if the difference
            // between previous element and peek is 1
            else {
                // Update the counter
                // These are consecutive elements
                c++;

                // Update the previous position
                // with the current peek And remove it
                prev = pq.poll();
            }

            // Check if current longest
            // subsequence is the greatest
            if (max < c) {
                // Store the current subsequence count as
                // max
                max = c;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
        // int arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42};
        int n = arr.length;

        // System.out.println("Length of the Longest " + "contiguous subsequence is " +
        // findLongestSubsequence(arr, n));
        // System.out.println("Length of the Longest consecutive subsequence is " +
        // findLongestSubsequence2(arr, n));
        System.out.println("Length of the Longest consecutive subsequence is " + findLongestSubsequence3(arr, n));
    }
}
