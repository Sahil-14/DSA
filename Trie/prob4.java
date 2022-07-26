
/**
 * Find shortest unique prefix for every word in a given lis
 * Given an array of words, find all shortest unique prefixes to represent each
 * word in the given array. Assume that no word is prefix of another.
 * Examples:
 * 
 * 
 * Input: arr[] = {"zebra", "dog", "duck", "dove"}
 * Output: dog, dov, du, z
 * Explanation: dog => dog
 * dove => dov
 * duck => du
 * zebra => z
 * 
 * Input: arr[] = {"geeksgeeks", "geeksquiz", "geeksforgeeks"};
 * Output: geeksf, geeksg, geeksq}
 * 
 * 
 * An Efficient Solution is to use Trie. The idea is to maintain a count in
 * every node. Below are steps.
 * 1) Construct a Trie of all words. Also maintain frequency of every node (Here
 * frequency is number of times node is visited during insertion). Time
 * complexity of this step is O(N) where N is total number of characters in all
 * words.
 * 2) Now, for every word, we find the character nearest to the root with
 * frequency as 1. The prefix of the word is path from root to this character.
 * To do this, we can traverse Trie starting from root. For every node being
 * traversed, we check its frequency. If frequency is one, we print all
 * characters from root to this node and don’t traverse down this node.
 * Time complexity if this step also is O(N) where N is total number of
 * characters in all words.
 */
import java.util.*;

public class prob4 {
  // A class to store a Trie node
  static class TrieNode {
    // each node stores a map to its child nodes
    Map<Character, TrieNode> child = new HashMap<>();

    // keep track of the total number of times the current node is visited
    // while inserting data in Trie
    int freq = 0;
  }

  // Function to insert a given string into a Trie
  public static void insert(TrieNode root, String word) {
    // start from the root node
    TrieNode curr = root;
    for (char c : word.toCharArray()) {
      // create a new node if the path doesn't exist
      curr.child.putIfAbsent(c, new TrieNode());

      // increment frequency
      curr.child.get(c).freq++;

      // go to the next node
      curr = curr.child.get(c);
    }
  }

  // Function to recursively traverse the Trie in a preorder fashion and
  // print the shortest unique prefix for each word in the Trie
  public static void printShortestPrefix(TrieNode root, String word_so_far) {
    if (root == null) {
      return;
    }

    // print `word_so_far` if the current Trie node is visited only once
    if (root.freq == 1) {
      System.out.println(word_so_far);
      return;
    }

    for (Map.Entry<Character, TrieNode> child : root.child.entrySet()) {
      printShortestPrefix(child.getValue(), word_so_far + child.getKey());
    }

  }

  public static void findShortestPrefix(String[] words) {
    TrieNode root = new TrieNode();
    for (String s : words) {
      insert(root, s);
    }

    printShortestPrefix(root, "");

  }

  public static void main(String[] args) {
    String[] words = { "AND", "BONFIRE", "BOOL", "CASE", "CATCH", "CHAR" };
    findShortestPrefix(words);
  }
}
