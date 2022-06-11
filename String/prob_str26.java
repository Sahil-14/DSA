/**
 * Boyer Moore Algorithm for Pattern Searching
 * Pattern searching is an important problem in computer science. When we do
 * search for a string in a notepad/word file, browser, or database, pattern
 * searching algorithms are used to show the search results. A typical problem
 * statement would be-
 * Given a text txt[0..n-1] and a pattern pat[0..m-1] where n is the length of
 * the text and m is the length of the pattern, write a function search(char
 * pat[], char txt[]) that prints all occurrences of pat[] in txt[]. You may
 * assume that n > m.
 * 
 * 
 * Input: txt[] = "THIS IS A TEST TEXT"
 * pat[] = "TEST"
 * Output: Pattern found at index 10
 * 
 * Input: txt[] = "AABAACAADAABAABA"
 * pat[] = "AABA"
 * Output: Pattern found at index 0
 * Pattern found at index 9
 * Pattern found at index 12
 * 
 * 
 * In this post, we will discuss the Boyer Moore pattern searching algorithm.
 * Like KMP and Finite Automata algorithms, Boyer Moore algorithm also
 * preprocesses the pattern.
 * Boyer Moore is a combination of the following two approaches.
 * 1) Bad Character Heuristic
 * 2) Good Suffix Heuristic
 * Both of the above heuristics can also be used independently to search a
 * pattern in a text. Let us first understand how two independent approaches
 * work together in the Boyer Moore algorithm. If we take a look at the Naive
 * algorithm, it slides the pattern over the text one by one. KMP algorithm does
 * preprocessing over the pattern so that the pattern can be shifted by more
 * than one. The Boyer Moore algorithm does preprocessing for the same reason.
 * It processes the pattern and creates different arrays for each of the two
 * heuristics. At every step, it slides the pattern by the max of the slides
 * suggested by each of the two heuristics.
 * 
 * 
 * https://www.geeksforgeeks.org/boyer-moore-algorithm-for-pattern-searching/
 * 
 * 
 * Bad Character Heuristic
 * 
 * The idea of bad character heuristic is simple. The character of the text
 * which doesn’t match with the current character of the pattern is called the
 * Bad Character. Upon mismatch, we shift the pattern until –
 * 1) The mismatch becomes a match
 * 2) Pattern P moves past the mismatched character.
 * Case 1 – Mismatch become match
 * Case 2 – Pattern move past the mismatch character
 * 
 */

public class prob_str26 {
  static int NO_OF_CHARS = 256;

  static int max(int a, int b) {
    return (a > b) ? a : b;
  }

  static void badCharHeuristic(char[] str, int size, int badchar[]) {
    for (int i = 0; i < NO_OF_CHARS; i++) {
      badchar[i] = -1;
    }

    // Fill the actual value of last occurrence
    // of a character (indices of table are ascii and values are index
    for (int i = 0; i < size; i++) {
      badchar[(int) str[i]] = i;
    }

  }

  static void search(char txt[], char pat[]) {
    int m = pat.length;
    int n = txt.length;

    int badchar[] = new int[NO_OF_CHARS];
    /*
     * Fill the bad character array by calling
     * the preprocessing function badCharHeuristic()
     * for given pattern
     */

    badCharHeuristic(pat, m, badchar);
    int s = 0; // s is shift of the pattern with
               // respect to text

    while (s <= (n - m)) {
      int j = m - 1;

      while (j > 0 && pat[j] == txt[s + j]) {
        j--;
      }
      /*
       * If the pattern is present at current
       * shift, then index j will become -1 after
       * the above loop
       */

      if (j < 0) {
        System.out.println("Patterns occur at shift = " + s);

        /*
         * Shift the pattern so that the next
         * character in text aligns with the last
         * occurrence of it in pattern.
         * The condition s+m < n is necessary for
         * the case when pattern occurs at the end
         * of text
         */
        // txt[s+m] is character after the pattern in text
        s += (s + m < n) ? m - badchar[txt[s + m]] : 1;
      } else {
        /*
         * Shift the pattern so that the bad character
         * in text aligns with the last occurrence of
         * it in pattern. The max function is used to
         * make sure that we get a positive shift.
         * We may get a negative shift if the last
         * occurrence of bad character in pattern
         * is on the right side of the current
         * character.
         */
        s += max(1, j - badchar[txt[s + j]]);
      }
    }

  }

  /* Driver program to test above function */
  public static void main(String[] args) {

    char txt[] = "ABAAABCD".toCharArray();
    char pat[] = "ABC".toCharArray();
    search(txt, pat);
  }

}
