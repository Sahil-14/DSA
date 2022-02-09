import java.util.Stack;
import java.util.Vector;

/**
 * Largest Tectangle in Histogram giben an array . Each element represents the
 * height to the histograms bar and the width of each bar is 1 find the area of
 * largest rectangle in the histogram
 */

class prob46 {
    // static int bruteForce(int arr[]) {
    //     int ans = 0;
    //     int n = arr.length;
    //     for (int i = 0; i < n; i++) {
    //         int minh = Integer.MIN_VALUE;
    //         for (int j = i; i < n; j++) {
    //             minh = Math.min(minh, arr[j]);
    //             int len = j - i + 1;
    //             ans = Math.max(ans, len * minh);
    //         }
    //     }
    // }

    static int maxAreaRect(int arr[], int n) {
        Stack<Integer> s = new Stack<>();
        // we push -1 to the stack because for some elements there will be no previous
        // smaller element in the array and we can store -1 as the index for previous
        // smaller.
        s.push(-1);
        int max_area = arr[0];
        // We declare left_smaller and right_smaller array of size n and initialize them
        // with -1 and n as their default value.
        // left_smaller[i] will store the index of previous smaller element for ith
        // element of the array.
        // right_smaller[i] will store the index of next smaller element for ith element
        // of the array.
        int left_smaller[] = new int[n];
        int right_smaller[] = new int[n];
        for (int i = 0; i < n; i++) {
            left_smaller[i] = -1;
            right_smaller[i] = n;
        }
        int i = 0;
        while (i < n) {
            while (!s.empty() && s.peek() != -1 && arr[i] < arr[s.peek()]) {
                // if the current element is smaller than element with index stored on the
                // top of stack then, we pop the top element and store the current element index
                // as the right_smaller for the poped element.
                right_smaller[s.peek()] = (int) i;
                s.pop();
            }
            if (i > 0 && arr[i] == arr[(i - 1)]) {
                // we use this condition to avoid the unnecessary loop to find the left_smaller.
                // since the previous element is same as current element, the left_smaller will
                // always be the same for both.
                left_smaller[i] = left_smaller[(int) (i - 1)];
            } else {
                // Element with the index stored on the top of the stack is always smaller than
                // the current element.
                // Therefore the left_smaller[i] will always be s.top().
                left_smaller[i] = s.peek();
            }
            s.push(i);
            i++;

        }
        for (i = 0; i < n; i++) {
            // here we find area with every element as the smallest element in their range
            // and compare it with the previous area.
            // in this way we get our max Area form this.
            max_area = Math.max(max_area, arr[i] * (right_smaller[i] - left_smaller[i] - 1));
        }
        return max_area;

    }

    public static void main(String[] args) {
        int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println("Maximum area is " + maxAreaRect(hist, hist.length));
     }
}