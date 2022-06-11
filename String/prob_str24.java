//Find the smallest window in a string containing all characters of another string

public class prob_str24 {
  static String Minimum_Window(char[] s, char[] t) {
    int m[] = new int[256];

    int ans = Integer.MAX_VALUE;
    int start = 0;
    int count = 0;
    for (int i = 0; i < t.length; i++) {
      if (m[t[i]] == 0) {
        count++;
      }
      m[t[i]]++;
    }

    int i = 0;
    int j = 0;

    while (j < s.length) {

      // Calculations
      m[s[j]]--;
      if (m[s[j]] == 0)
        count--;

      // Condition matching
      if (count == 0) {
        while (count == 0) {

          // Sorting ans
          if (ans > j - i + 1) {
            ans = Math.min(ans, j - i + 1);
            start = i;
          }

          // Sliding I
          // Calculation for removing I
          m[s[i]]++;
          if (m[s[i]] > 0)
            count++;
          i++;
        }
      }
      j++;
    }
    System.out.println("start" + start);
    if (ans != Integer.MAX_VALUE)
      return String.valueOf(s).substring(start, ans + start);
    else
      return "-1";
  }

  public static void main(String[] args) {
    String s = "ABCEFDH";
    String t = "EFH";
    System.out.print("-->Smallest window that contain all character : ");
    System.out.print(Minimum_Window(s.toCharArray(), t.toCharArray()));
  }
}
