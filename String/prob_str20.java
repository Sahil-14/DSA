/**
 * 
 * Given a string that consists of only uppercase English letters, you can
 * replace any letter in the string with another letter at most k times. Find
 * the length of a longest substring containing all repeating letters you can
 * get after performing the above operations.
 * 
 * Input:
 * s = "ABAB", k = 2
 * 
 * Output:
 * 4
 * 
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 * 
 */

public class prob_str20 {
  public static int characterReplacement(String s, int k) {

    int[] count = new int[26];
    int maxCount = 0;
    int maxLength = 0;

    int left = 0;

    for (int right = 0; right < s.length(); right++) {
      count[s.charAt(right) - 'A'] += 1;
      maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
      while (right - left + 1 - maxCount > k) {
        count[s.charAt(left) - 'A'] -= 1;
        left++;
      }
      maxLength = Math.max(maxLength, right - left + 1);
    }
    return maxLength;
  }

  public static void main(String[] args) {
    String s = "ABAB";
    int k = 2;
    System.out.println(characterReplacement(s, k));

  }
}
