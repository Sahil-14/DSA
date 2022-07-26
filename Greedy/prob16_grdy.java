import java.util.PriorityQueue;
import java.util.*;

/**
 * 
 * Rearrange characters in a string such that no two adjacent are same
 * Input: aaabc
 * Output: abaca
 * 
 * Input: aaabb
 * Output: ababa
 * 
 * Input: aa
 * Output: Not Possible
 * 
 * Input: aaaabc
 * Output: Not Possible
 * 
 * 
 */

class KeyComparator implements Comparator<Key> {
  public int compare(Key k1, Key k2) {
    if (k1.freq < k2.freq) {
      return 1;
    } else if (k1.freq > k2.freq) {
      return -1;
    }
    return 0;
  }
}

class Key {
  int freq; // store frequency of character
  char ch;

  Key(int val, char c) {
    freq = val;
    ch = c;
  }
}

public class prob16_grdy {
  static int MAX_CHAR = 26;

  // Time complexity : O(n log(n))

  static void rearrangeString(String str) {
    int n = str.length();
    int[] count = new int[MAX_CHAR];

    for (int i = 0; i < n; i++) {
      count[str.charAt(i) - 'a']++;
    }

    // Insert all characters with their frequencies
    // into a priority_queue
    PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator());
    for (char c = 'a'; c <= 'z'; c++) {
      int val = c - 'a';
      if (count[val] > 0)
        pq.add(new Key(count[val], c));
    }

    // 'str' that will store resultant value
    str = "";

    // work as the previous visited element
    // initial previous element be. ( '#' and
    // it's frequency '-1' )
    Key prev = new Key(-1, '#');
    while (pq.size() != 0) {
      Key k = pq.peek();
      pq.poll();
      str = str + k.ch;
      if (prev.freq > 0)
        pq.add(prev);

      k.freq--;
      prev = k;

    }

    if (n != str.length()) {
      System.out.println(" Not valid String ");
    } else {
      System.out.println(str);
    }

  }

  // Driver program to test above function
  public static void main(String args[]) {
    String str = "bbbaa";
    rearrangeString(str);
  }
}
