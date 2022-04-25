import java.util.*;

// Stock span
//it is defined as the maximum number of consecutive days (starting from today and going backward) for which 
// the price of the stocks was less than or equal to todays price
// find the span of thre stocks  for all the days
public class prob49 {
    static void calculateSpan(int price[], int n, int S[]) {
        // Create a stack and push index of first element
        // to it
        Stack<Integer> st = new Stack<>();
        st.push(0);

        // Span value of first element is always 1
        S[0] = 1;

        // Calculate span values for rest of the elements
        for (int i = 1; i < n; i++) {

            // Pop elements from stack while stack is not
            // empty and top of stack is smaller than
            // price[i]
            while (!st.empty() && price[st.peek()] <= price[i])
                st.pop();

            // If stack becomes empty, then price[i] is
            // greater than all elements on left of it, i.e.,
            // price[0], price[1], ..price[i-1]. Else price[i]
            // is greater than elements after top of stack
            S[i] = (st.empty()) ? (i + 1) : (i - st.peek());

            // Push this element to stack
            st.push(i);
        }
    }

    public void stockspn(int arr[], int n, int s[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        s[0] = 1;
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            s[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            
            stack.push(i);
        }
    }

    static void printArray(int arr[]) {
        System.out.print(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        // int[] arr ={100, 60, 70, 65, 80, 85, 45, 77, 56, 98, 200};
        int arr[] = { 100, 80, 60, 70, 60, 75, 85 };
        int n = arr.length;
        int S[] = new int[n];
        calculateSpan(arr, n, S);
        printArray(S);

    }
}
