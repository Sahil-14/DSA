
/**
 * Queue based approach for first non-repeating character in a stream
 * 
 * 
 * Given a stream of characters and we have to find first non repeating
 * character each time a character is inserted to the stream.
 * 
 * Input : a a b c
 * Output : a -1 b b
 * 
 * Input : a a c
 * Output : a -1 c
 * 
 * 
 * 
 * 
 */
import java.util.*;

public class SQ17 {
  final static int MAX_CHAR = 26;

  static void firstNonRepeating(String str) {
    int[] charCount = new int[MAX_CHAR];
    Queue<Character> q = new LinkedList<Character>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      q.add(ch);

      charCount[ch - 'a']++;
      while (!q.isEmpty()) {
        if (charCount[q.peek() - 'a'] > 1) {
          q.remove();
        } else {
          System.out.print(q.peek() + " ");
          break;
        }
      }
      if (q.isEmpty())
        System.out.print(-1 + " ");
    }
    System.out.println();

  }

  // Driver function
  public static void main(String[] args) {
    String str = "aabc";
    firstNonRepeating(str);
  }
}
