import java.util.Stack;

/**
 * Find if an expression has duplicate parenthesis or not
 * 
 * 
 */
import java.util.*;

public class SQ6 {
  static boolean findDuplicateparenthesis(String s) {
    Stack<Character> stack = new Stack<>();
    char[] str = s.toCharArray();
    for (char ch : str) {
      if (ch == ')') {

        char top = stack.peek();
        stack.pop();
        // stores the number of characters between a
        // closing and opening parenthesis
        // if this count is less than or equal to 1
        // then the brackets are redundant else not
        int elementsInside = 0;
        while (top != '(') {
          elementsInside++;
          top = stack.peek();
          stack.pop();
        }
        if (elementsInside < 1) {
          return true;
        }
      } else {
        stack.push(ch);
      }
    }
    // No duplicates found
    return false;
  }

  // Driver code
  public static void main(String[] args) {

    // input balanced expression
    String str = "(((a+(b))+(c+d)))";

    if (findDuplicateparenthesis(str)) {
      System.out.println("Duplicate Found ");
    } else {
      System.out.println("No Duplicates Found ");
    }

  }
}
