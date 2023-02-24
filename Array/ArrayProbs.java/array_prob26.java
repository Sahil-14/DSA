
//find next greater in array;
import java.util.Stack;

public class array_prob26 {

  /*
   * prints element and NGE pair for
   * all elements of arr[] of size n
   * 
   * O(n2)
   */
  static void printNG1(int arr[], int n) {
    int next, i, j;
    for (i = 0; i < n; i++) {
      next = -1;
      for (j = i + 1; j < n; j++) {
        if (arr[i] < arr[j]) {
          next = arr[j];
          break;
        }
      }
      System.out.println(arr[i] + " -- " + next);
    }
  }

  public static void nextGreater(int arr[], int n) {
    int i = 0;
    Stack<Integer> s = new Stack<>();
    int element;
    int next;
    s.push(arr[0]);

    // iterate for rest of the elements
    for (i = 1; i < n; i++) {
      next = arr[i];

      if (s.isEmpty() == false) {

        // if stack is not empty, then
        // pop an element from stack
        element = s.pop();

        /*
         * If the popped element is smaller than
         * next, then a) print the pair b) keep
         * popping while elements are smaller and
         * stack is not empty
         */
        while (element < next) {
          System.out.println(element + " --> "
              + next);
          if (s.isEmpty() == true)
            break;
          element = s.pop();
        }

        /*
         * If element is greater than next, then
         * push the element back
         */
        if (element > next)
          s.push(element);
      }

      /*
       * push next to stack so that we can find next
       * greater for it
       */
      s.push(next);
    }
    /*
     * After iterating over the loop, the remaining
     * elements in stack do not have the next greater
     * element, so print -1 for them
     */
    while (s.isEmpty() == false) {
      element = s.pop();
      next = -1;
      System.out.println(element + " -- " + next);
    }

  }

  public static void printNGE(int arr[], int n) {
    Stack<Integer> s = new Stack<>();
    int nge[] = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
      /*
       * if stack is not empty, then
       * pop an element from stack.
       * If the popped element is smaller
       * than next, then
       * a) print the pair
       * b) keep popping while elements are
       * smaller and stack is not empty
       */
      if (!s.isEmpty()) {
        while (!s.isEmpty() && s.peek() <= arr[i]) {
          s.pop();
        }
      }
      nge[i] = s.empty() ? -1 : s.peek();
      s.push(arr[i]);

    }
    for (int i = 0; i < arr.length; i++)
      System.out.println(arr[i] +
          " --> " + nge[i]);

  }

  public static void main(String[] args) {
    int arr[] = { 11, 13, 21, 3 };
    int n = arr.length;
    nextGreater(arr, n);
  }
}
