import java.util.Stack;

/**
 * Length of the longest valid substring
 * 
 * Input : ((()
 * Output : 2
 * Explanation : ()
 * 
 * Input: )()())
 * Output : 4
 * Explanation: ()()
 * 
 * Input: ()(()))))
 * Output: 6
 * Explanation: ()(())
 * 
 * 
 * 
 */
public class SQ13 {
  static int findMaxLen(String str) {
    int n = str.length();
    Stack<Integer> s = new Stack<>();
    s.push(-1);
    int result = 0;

    for (int i = 0; i < n; i++) {
      // If opening bracket, push index of it
      if (str.charAt(i) == '(')
        s.push(i);
      else {
        if (!s.isEmpty()) {
          s.pop();
        }
        if (!s.isEmpty()) {
          result = Math.max(result, i - s.peek());
        }

        else {
          s.push(i);
        }
      }
    }
    return result;
  }

  // Driver code
  public static void main(String[] args) {
    String str = "((()()";

    // Function call
    System.out.println(findMaxLen(str));

    str = "()(()))))";

    // Function call
    System.out.println(findMaxLen(str));
  }
}
