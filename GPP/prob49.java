import java.util.*;

// Stock span
public class prob49 {
    public static void stockSpan(int[] prices) {

        Stack<Integer> s = new Stack();
        int[] span = new int[prices.length];

        // Step 1. Initialization
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < prices.length; i++) {
            // Find the price on stack which is greater than current day's price
            while (!s.empty() && prices[i] > prices[s.peek()]) {
                s.pop();

                if (s.isEmpty())
                    span[i] = i + 1;
                else
                    span[i] = i - s.peek();

                // Push current day onto top of stack
                s.push(i);
            }
        }
        for (int i = 0; i < span.length; i++) {
            System.out.println(span[i]);
        }
    }

    public static void main(String[] args) {
        // int[] arr ={100, 60, 70, 65, 80, 85, 45, 77, 56, 98, 200};
        int arr[] = { 100, 80, 60, 70, 60, 75, 85 };
        stockSpan(arr);

    }
}
