import java.util.*;

public class bitsort {

  public static List<Integer> sortByBits(List<Integer> arr) {
    int n = arr.size();
    for (int i = 0; i < n; i++)
      arr.set(i, arr.get(i) + 10001 * Integer.bitCount(arr.get(i)));
    Collections.sort(arr);
    for (int i = 0; i < n; i++)
      arr.set(i, arr.get(i) % 10001);
    return arr;
  }

  public static int longestStrChain(List<String> words) {
    int ans = 0;
    Map<String, Integer> dp = new HashMap<>();

    Collections.sort(words, (a, b) -> a.length() - b.length());
    for (final String word : words) {
      int bestLength = 0;
      for (int i = 0; i < word.length(); ++i) {
        final String pred = word.substring(0, i) + word.substring(i + 1);
        bestLength = Math.max(bestLength, dp.getOrDefault(pred, 0) + 1);
      }
      dp.put(word, bestLength);
      ans = Math.max(ans, bestLength);
    }

    return ans;
  }

  // ["a","b","ba","bca","bda","bdca"]
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("a");
    list.add("b");

    list.add("ba");
    list.add("bca");
    list.add("bda");
    list.add("bdca");

    int res = longestStrChain(list);
    System.out.println(res);
  }
}
