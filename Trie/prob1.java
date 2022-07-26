/**
 * 
 * This method uses Trie data structure to solve the above problem. Trie is an
 * efficient information retrieval data structure. Using Trie, search
 * complexities can be brought to an optimal limit (key length). If we store
 * keys in the binary search tree, a well-balanced BST will need time
 * proportional to M * log N, where M is maximum string length and N is the
 * number of keys in the tree. Using Trie, we can search the key in O(M) time.
 * However, the penalty is on Trie storage requirements.
 * 
 * 
 */

class prob1 {
  static final int ALPHABET_SIZE = 26;

  static class TrieNode {
    TrieNode[] children = new TrieNode[ALPHABET_SIZE];

    // isEndOfWord is true if the node represents
    // end of a word
    boolean isEndOfWord;

    TrieNode() {
      isEndOfWord = false;
      for (int i = 0; i < ALPHABET_SIZE; i++)
        children[i] = null;
    }

  }

  static TrieNode root;

  // If not present, inserts key into trie
  // If the key is prefix of trie node,
  // just marks leaf node
  static void insert(String key) {

    int length = key.length();
    int index;
    TrieNode pCrawl = root;

    for (int i = 0; i < length; i++) {
      index = key.charAt(i) - 'a';
      if (pCrawl.children[index] == null)
        pCrawl.children[index] = new TrieNode();

      pCrawl = pCrawl.children[index];
    }

    // mark last node as leaf
    pCrawl.isEndOfWord = true;
  }

  // Returns true if key presents in trie, else false
  static boolean search(String key) {

    int length = key.length();
    int index;
    TrieNode pCrawl = root;

    for (int i = 0; i < length; i++) {
      index = key.charAt(i) - 'a';
      if (pCrawl.children[index] == null)
        return false;

      pCrawl = pCrawl.children[index];
    }

    return (pCrawl.isEndOfWord);
  }

  public static void main(String args[]) {
    // Input keys (use only 'a' through 'z' and lower case)
    String keys[] = { "the", "a", "there", "answer", "any",
        "by", "bye", "their" };

    String output[] = { "Not present in trie", "Present in trie" };

    root = new TrieNode();

    // Construct trie
    int i;
    for (i = 0; i < keys.length; i++)
      insert(keys[i]);

    // Search for different keys
    if (search("the") == true)
      System.out.println("the --- " + output[1]);
    else
      System.out.println("the --- " + output[0]);

    if (search("these") == true)
      System.out.println("these --- " + output[1]);
    else
      System.out.println("these --- " + output[0]);

    if (search("their") == true)
      System.out.println("their --- " + output[1]);
    else
      System.out.println("their --- " + output[0]);

    if (search("thaw") == true)
      System.out.println("thaw --- " + output[1]);
    else
      System.out.println("thaw --- " + output[0]);

  }


}


// hashmap solution

public class Trie {

  private class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode() {
      children = new HashMap<>();
      endOfWord = false;
    }
  }

  private final TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  /**
   * Iterative implementation of insert into trie
   */
  public void insert(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      TrieNode node = current.children.get(ch);
      if (node == null) {
        node = new TrieNode();
        current.children.put(ch, node);
      }
      current = node;
    }
    // mark the current nodes endOfWord as true
    current.endOfWord = true;
  }

  /**
   * Iterative implementation of search into trie.
   */
  public boolean search(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      TrieNode node = current.children.get(ch);
      // if node does not exist for given char then return false
      if (node == null) {
        return false;
      }
      current = node;
    }
    // return true of current's endOfWord is true else return false.
    return current.endOfWord;
  }

 

  /**
   * Delete word from trie.
   */
  public void delete(String word) {
    delete(root, word, 0);
  }

  /**
   * Returns true if parent should delete the mapping
   */
  private boolean delete(TrieNode current, String word, int index) {
    if (index == word.length()) {
      // when end of word is reached only delete if currrent.endOfWord is true.
      if (!current.endOfWord) {
        return false;
      }
      current.endOfWord = false;
      // if current has no other mapping then return true
      return current.children.size() == 0;
    }
    char ch = word.charAt(index);
    TrieNode node = current.children.get(ch);
    if (node == null) {
      return false;
    }
    boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

    // if true is returned then delete the mapping of character and trienode
    // reference from map.
    if (shouldDeleteCurrentNode) {
      current.children.remove(ch);
      // return true if no mappings are left in the map.
      return current.children.size() == 0;
    }
    return false;
  }
}