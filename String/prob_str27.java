/**
 * Given a binary string of 0s and 1s. The task is to find the maximum
 * difference between the number of 0s and number of 1s in any sub-string of the
 * given binary string. That is maximize ( number of 0s – number of 1s ) for any
 * sub-string in the given binary string.
 * 
 * 
 * 
 */

public class prob_str27 {
  public static int findLength(String str, int n) {
    int current_sum = 0;
    int max_sum = 0;
    for (int i = 0; i < n; i++) {
      current_sum += str.charAt(i) == '0' ? 1 : -1;

      if (current_sum < 0)
        current_sum = 0;
      max_sum = Math.max(current_sum, max_sum);

    }

    return max_sum == 0 ? -1 : max_sum;
  }

}
