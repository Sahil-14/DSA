import java.util.*;

//logest suffix and prefic
public class prob_str23 {
  public static int longestSuffixPrefix(char pattern[]) {
    int lps[] = new int[pattern.length];
    int max = Integer.MIN_VALUE;
    int index = 0;
    for (int i = 1; i < pattern.length;) {
      if (pattern[i] == pattern[index]) {
        lps[i] = index + 1;
        index++;
        i++;
      } else {
        if (index != 0) {
          index = lps[index - 1];
        } else {
          lps[i] = 0;
          i++;
        }
      }

    }
    for (int i = 0; i < lps.length; i++) {
      max = Math.max(max, lps[i]);
    }
    return max;

  }

  static int longestPrefixSuffix(String s) {
    int n = s.length();
    int lps[] = new int[n];
    lps[0] = 0;
    int len = 0;
    int i = 1;
    while (i < n) {
      if (s.charAt(i) == s.charAt(len)) {
        len++;
        lps[i] = len;
        i++;
      }

      // (pat[i] != pat[len])
      else {
        // This is tricky. Consider
        // the example. AAACAAAA
        // and i = 7. The idea is
        // similar to search step.
        if (len != 0) {
          len = lps[len - 1];

          // Also, note that we do
          // not increment i here
        }

        // if (len == 0)
        else {
          lps[i] = 0;
          i++;
        }
      }
    }

    int res = lps[n - 1];

    // Since we are looking for
    // non overlapping parts.
    return (res > n / 2) ? n / 2 : res;
  }

  public static void main(String[] args) {
    String str = "aaa";

    System.out.println(longestSuffixPrefix(str.toCharArray()));
  }
}
