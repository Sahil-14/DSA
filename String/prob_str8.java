import java.util.*;

//Check whether two strings are anagram of each other
public class prob_str8 {
  public static boolean isAnagram(String a, String b) {
    if (a.length() != b.length()) {
      return false;
    }

    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < a.length(); i++) {
      if (map.containsKey(a.charAt(i))) {
        map.put(a.charAt(i), map.get(a.charAt(i)) + 1);
      } else {
        map.put(a.charAt(i), 1);
      }
    }

    for (int i = 0; i < b.length(); i++) {
      if (map.containsKey(b.charAt(i))) {
        map.put(b.charAt(i), map.get(b.charAt(i)) - 1);
      }
    }
    Set<Character> keys = map.keySet();

    for (Character key : keys) {
      if (map.get(key) != 0) {
        return false;
      }
    }
    return true;

  }

  static int NO_OF_CHARS = 256;

  // function to check if two strings
  // are anagrams of each other
  static boolean areAnagram(char[] str1,
      char[] str2) {

    // Create a count array and initialize
    // all values as 0
    int[] count = new int[NO_OF_CHARS];
    int i;

    // For each character in input strings,
    // increment count in the corresponding
    // count array
    for (i = 0; i < str1.length; i++) {
      count[str1[i] - 'a']++;
      count[str2[i] - 'a']--;
    }

    // If both strings are of different
    // length. Removing this condition
    // will make the program fail for
    // strings like "aaca" and "aca"
    if (str1.length != str2.length)
      return false;

    // See if there is any non-zero
    // value in count array
    for (i = 0; i < NO_OF_CHARS; i++)
      if (count[i] != 0) {
        return false;
      }
    return true;
  }

  public static void main(String[] args) {
    String str1 = "geeksforgeeks";
    String str2 = "forgeeksgeeks";

    // Function call
    if (isAnagram(str1, str2))
      System.out.print("The two strings are "
          + "anagram of each other");
    else
      System.out.print("The two strings are "
          + "not anagram of each other");
  }
}
