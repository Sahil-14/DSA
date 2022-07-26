import java.util.List;
import java.awt.*;

/**
 * word ladder
 * 
 * We are given a beginWord and an endWord. Let these two represent start node
 * and end node of a graph. We have to reach from the start node to the end node
 * using some intermediate nodes/words. The intermediate nodes are determined by
 * the wordList given to us. The only condition for every step we take on this
 * ladder of words is the current word should change by just one letter.
 * 
 * 
 * 
 * Algorithm
 * 
 * Do the pre-processing on the given wordList and find all the possible
 * generic/intermediate states. Save these intermediate states in a dictionary
 * with key as the intermediate word and value as the list of words which have
 * the same intermediate word.
 * 
 * Push a tuple containing the beginWord and 1 in a queue. The 1 represents the
 * level number of a node. We have to return the level of the endNode as that
 * would represent the shortest sequence/distance from the beginWord.
 * 
 * To prevent cycles, use a visited dictionary.
 * 
 * While the queue has elements, get the front element of the queue. Let's call
 * this word as current_word.
 * 
 * Find all the generic transformations of the current_word and find out if any
 * of these transformations is also a transformation of other words in the word
 * list. This is achieved by checking the all_combo_dict.
 * 
 * The list of words we get from all_combo_dict are all the words which have a
 * common intermediate state with the current_word. These new set of words will
 * be the adjacent nodes/words to current_word and hence added to the queue.
 * 
 * Hence, for each word in this list of intermediate words, append (word, level
 * + 1) into the queue where level is the level for the current_word.
 * 
 * Eventually if you reach the desired word, its level would represent the
 * shortest transformation sequence length.
 * 
 * 
 * 
 * 
 */

public class prob42_grph {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    int L = beginWord.length();
    Map<String, List<String>> allComboDict = new HashMap<>();

    wordList.forEach(word -> {
      for (int i = 0; i < L; i++) {
        // Key is the generic word
        // Value is a list of words which have the same intermediate generic word.
        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
        List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
        transformations.add(word);
        allComboDict.put(newWord, transformations);
      }
    });

    // Queue for BFS
    Queue<Pair<String, Integer>> Q = new LinkedList<>();
    Q.add(new Pair(beginWord, 1));

    // Visited to make sure we don't repeat processing same word.
    Map<String, Boolean> visited = new HashMap<>();
    visited.put(beginWord, true);

    while (!Q.isEmpty()) {
      Pair<String, Integer> node = Q.remove();
      String word = node.getKey();
      int level = node.getValue();
      for (int i = 0; i < L; i++) {

        // Intermediate words for current word
        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

        // Next states are all the words which share the same intermediate state.
        for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
          // If at any point if we find what we are looking for
          // i.e. the end word - we can return with the answer.
          if (adjacentWord.equals(endWord)) {
            return level + 1;
          }
          // Otherwise, add it to the BFS Queue. Also mark it visited
          if (!visited.containsKey(adjacentWord)) {
            visited.put(adjacentWord, true);
            Q.add(new Pair(adjacentWord, level + 1));
          }
        }
      }
    }

  }

}
