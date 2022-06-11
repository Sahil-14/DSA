
/**
 * The Celebrity Problem
 * 
 * In a party of N people, only one person is known to everyone. Such a person
 * may be present in the party, if yes, (s)he doesn’t know anyone in the party.
 * We can only ask questions like “does A know B? “. Find the stranger
 * (celebrity) in the minimum number of questions.
 * We can describe the problem input as an array of numbers/characters
 * representing persons in the party. We also have a hypothetical function
 * HaveAcquaintance(A, B) which returns true if A knows B, false otherwise. How
 * can we solve the problem.
 * 
 * Input:
 * MATRIX = { {0, 0, 1, 0},
 * {0, 0, 1, 0},
 * {0, 0, 0, 0},
 * {0, 0, 1, 0} }
 * Output:id = 2
 * Explanation: The person with ID 2 does not
 * know anyone but everyone knows him
 * 
 * Input:
 * MATRIX = { {0, 0, 1, 0},
 * {0, 0, 1, 0},
 * {0, 1, 0, 0},
 * {0, 0, 1, 0} }
 * Output: No celebrity
 * Explanation: There is no celebrity.
 * 
 * 
 */
import java.util.*;

public class SQ12 {
  // Max # of persons in the party
  static final int N = 8;

  // Person with 2 is celebrity
  static int MATRIX[][] = { { 0, 0, 1, 0 },
      { 0, 0, 1, 0 },
      { 0, 0, 0, 0 },
      { 0, 0, 1, 0 } };

  // Returns true if a knows
  // b, false otherwise
  static boolean knows(int a, int b) {
    boolean res = (MATRIX[a][b] == 1) ? true : false;
    return res;
  }

  static int findCelebrity(int n) {
    Stack<Integer> st = new Stack<>();
    int c;

    for (int i = 0; i < n; i++) {
      st.push(i);
    }

    while (st.size() > 1) {
      int a = st.pop();
      int b = st.pop();

      if (knows(a, b)) {
        st.push(b);
      } else {
        st.push(a);
      }
    }

    // If there are only two people
    // and there is no
    // potential candidate
    if (st.empty())
      return -1;

    c = st.pop();

    for (int i = 0; i < n; i++) {
      if (i != c && (knows(c, i) || !knows(i, c))) {
        return -1;
      }
    }
    return c;

  }

  // Driver Code
  public static void main(String[] args) {
    int n = 4;
    int result = findCelebrity(n);
    if (result == -1) {
      System.out.println("No Celebrity");
    } else
      System.out.println("Celebrity ID " +
          result);
  }
}
