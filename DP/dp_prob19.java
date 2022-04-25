//word break/splid problem

import java.util.*;

public class dp_prob19 {
  

  public boolean wordBreakBottomUp(String s, Set<String> set) {
    boolean[] T = new boolean[s.length() + 1];
    T[0] = true;

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (T[j] && set.contains(s.substring(j, i))) {
          T[i] = true;
          break;
        }
      }
    }
    return T[s.length()];
  }

  public static void main(String arg[]) {
    Set<String> dictionary = new HashSet<>();
    dictionary.add("I");
    dictionary.add("like");
    dictionary.add("had");
    dictionary.add("play");
    dictionary.add("to");
    String str = "Ihadliketoplay";
    dp_prob19 bmw = new dp_prob19();
    System.out.println(bmw.wordBreakBottomUp(str, dictionary));
  }
}
