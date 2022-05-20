
/**
 * Painters partition Problem
 * n = length of n different boards
 * m = painters available
 * a painters paints 1 unit of board int 1 unint of time and each
 * painter will paint cconsecutive boards . find the minimum time that will be
 * required to paint all the boards
 * 
 */

import java.util.*;

public class prob78 {
    static int findFeasible(int boards[], int n, int limit) {
        int sum = 0;
        int painters = 1;
        for (int i = 0; i < n; i++) {
            sum += boards[i];
            if (sum > limit) {
                sum = boards[i];
                painters++;
            }
        }
        return painters;
    }

    static int paintersPartition(int boards[], int n, int m) {
        int totalLength = 0, k = 0;

        // k = largest board length
        for (int i = 0; i < n; i++) {
            k = Math.max(k, boards[i]);
            totalLength += boards[i];
        }
        int l = k, h = totalLength;
        while (l < h) {
            int mid = (l + h) / 2;
            int painter = findFeasible(boards, n, mid);
            if (painter <= mid) {
                h = mid;
            } else {
                l = mid + 1;
            }

        }
        return totalLength - l;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 60, 50, 30, 40 };
        int n = 4;
        int m = 2;
        System.out.println(paintersPartition(arr, n, m));

    }
}
