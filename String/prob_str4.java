
//remve adjecent duplicates from string
import java.util.*;

public class prob_str4 {
  public static String removeDuplicates(String s) {
    if (s.length() <= 1) {
      return s;
    }
    char ch = s.charAt(0);
    String ans = removeDuplicates(s.substring(1));
    if (ch == ans.charAt(0)) {
      return ans;
    }
    return ch + ans;
  }

  // remove duplicates from entire string maining order with extra space
  void removeDuplicates2(String str) {
    LinkedHashSet<Character> lhs = new LinkedHashSet<>();
    for (int i = 0; i < str.length(); i++)
      lhs.add(str.charAt(i));

    // print string after deleting duplicate elements
    for (Character ch : lhs)
      System.out.print(ch);
  }

  // Function to make the string unique
  public static String unique(String s) {
    String str = new String();
    int len = s.length();

    // loop to traverse the string and
    // check for repeating chars using
    // IndexOf() method in Java
    for (int i = 0; i < len; i++) {
      // character at i'th index of s
      char c = s.charAt(i);
      System.out.println(str.indexOf(c));
      // if c is present in str, it returns
      // the index of c, else it returns -1
      if (str.indexOf(c) < 0) {
        // adding c to str if -1 is returned

        str += c;
      }
    }

    return str;
  }

  //

  public static void main(String[] args) {
    System.out.println(unique("aagbdbgh"));
  }
}
