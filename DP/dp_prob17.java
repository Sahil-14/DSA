import java.util.*;

/**
 * * Given a 2D matrix of 0s and 1s. Find largest rectangle of all 1s
 * in this matrix.
 * 
 * Maintain a temp array of same size as number of columns.
 * Copy first row to this temp array and find largest rectangular area
 * for histogram. Then keep adding elements of next row to this temp
 * array if they are not zero. If they are zero then put zero there.
 * Every time calculate max area in histogram.
 * 
 * Time complexity - O(rows*cols)
 * Space complexity - O(cols) - if number of cols is way higher than rows
 * then do this process for rows and not columns.
 */
public class dp_prob17 {

    public int maxHistogram(int input[]) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        for (i = 0; i < input.length;) {
            if (stack.isEmpty() || input[stack.peekFirst()] <= input[i]) {
                stack.offerFirst(i++);
            } else {
                int top = stack.pollFirst();
                // if stack is empty means everything till i has to be
                // greater or equal to input[top] so get area by
                // input[top] * i;
                if (stack.isEmpty()) {
                    area = input[top] * i;
                }
                // if stack is not empty then everythin from i-1 to input.peek() + 1
                // has to be greater or equal to input[top]
                // so area = input[top]*(i - stack.peek() - 1);
                else {
                    area = input[top] * (i - stack.peekFirst() - 1);
                }
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pollFirst();
            // if stack is empty means everything till i has to be
            // greater or equal to input[top] so get area by
            // input[top] * i;
            if (stack.isEmpty()) {
                area = input[top] * i;
            }
            // if stack is not empty then everything from i-1 to input.peek() + 1
            // has to be greater or equal to input[top]
            // so area = input[top]*(i - stack.peek() - 1);
            else {
                area = input[top] * (i - stack.peekFirst() - 1);
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public int maxRectangleOfOnes(int input[][]) {
        int temp[] = new int[input[0].length];
        int maxArea = 0;
        int area = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (input[i][j] == 0) {
                    temp[j] = 0;
                } else {
                    temp[j] += input[i][j];
                }
            }
            area = maxHistogram(temp);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        dp_prob17 mh = new dp_prob17();
        // int input[] = { 2, 2, 2, 6, 1, 5, 4, 2, 2, 2, 2 };
        // int maxArea = mh.maxHistogram(input);
        int input[][] = { { 1, 1, 1, 0 },
                { 1, 1, 1, 1 },
                { 0, 1, 1, 0 },
                { 0, 1, 1, 1 },
                { 1, 0, 0, 1 },
                { 1, 1, 1, 1 } };
        // System.out.println(maxArea);
        int maxRect = mh.maxRectangleOfOnes(input);
        System.out.println(maxRect);
    }
}
