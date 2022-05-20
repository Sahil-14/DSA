import java.util.HashMap;

//print all duplicates

public class prob_str10 {
  static void printDuplicate(String s) {
    HashMap<Character, Integer> count = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (!count.containsKey()) {
        count.put(s.charAt(i), 1);
      } else {
        count.put(s.charAt(i), count.get(s.charAt(i)) + 1);
      }
    }

    for (Map.Entry mapElement : count.entrySet()) {
      char key = (char) mapElement.getKey();
      int value = ((int) mapElement.getValue());

      if (value > 1)
        System.out.println(key
            + ", count = " + value);
    }
  }
}
