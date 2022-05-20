import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

//group anagram

public class prob_str21 {
  public static List<List<String>> groupAnagram(String[] strs) {
    if (strs.length == 0)
      return new ArrayList<>();
    HashMap<String, List> ans = new HashMap<>();
    for (String s : strs) {
      char[] ca = s.toCharArray();
      Arrays.sort(ca);
      String key = String.valueOf(ca);
      if (!ans.containsKey(key)) {
        ans.put(key, new ArrayList<>());
      }
      ans.get(key).add(s);
    }
    return new ArrayList(ans.values());
  }

  public static void main(String[] args) {
    String strs[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
    System.out.println(groupAnagram(strs));
  }
}
