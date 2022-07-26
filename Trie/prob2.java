/**
 * Print unique rows in a given Binary matrix
 * 
 * 
 */ 

public class prob2 {
  /**
   * method 1 : using trie
   * Since the matrix is boolean, a variant of Trie data structure can be used
   * where each node will be having two children one for 0 and other for 1. Insert
   * each row in the Trie. If the row is already there, don’t print the row. If
   * the row is not there in Trie, insert it in Trie and print it.
   * 
   * Create a Trie where rows can be stored.
   * Traverse through the matrix and insert the row into the Trie.
   * Trie cannot store duplicate entries so the duplicates will be removed
   * Traverse the Trie and print the rows.
   * 
   * 
   */
  // The count is 2 as we are dealing in 1's and 2's
  static final int CNT = 2;

  // trie node
  static class TNode {
    TNode[] children = new TNode[CNT];

    // isEndOfRow is true if and only if the node represents
    // the end of the row
    boolean isEndOfRow;

    TNode() {
      isEndOfRow = false;
      for (int j = 0; j < CNT; j++)
        children[j] = null;
    }
  };

  static TNode rt;

  // If not present, inserts key into trie
  // If the key is prefix of trie node,
  // just marks leaf node
  static boolean insert(int row[]) {
    int v;
    int size = row.length;
    int idx;

    TNode pCrawl = rt;
    boolean isUnique = false;
    for (v = 0; v < size; v++) {
      // idx will be always 0 and 1
      idx = row[v];

      if (pCrawl.children[idx] == null) {
        pCrawl.children[idx] = new TNode();
        isUnique = true;
      }

      pCrawl = pCrawl.children[idx];
    }
    pCrawl.isEndOfRow = true;
    return isUnique;
  }

  // A utility method for displaying the unique rows
  void displayRow(int input[][], int row) {
    int j;
    int colSize = input[0].length;
    for (j = 0; j < colSize; ++j) {
      System.out.print(input[row][j] + " ");
    }
    System.out.println();
  }

  // it is the method that is being invoked
  // by the main() method. The method filters out the unique
  // rows from the input matrix and displays it by invoking the
  // displayRow() method
  void filterAndPrintUniqueRows(int input[][], int R, int C) {
    rt = new TNode(); // creating an empty Trie
    int j;

    for (j = 0; j < R; ++j) {
      // inserting row into the TRIE
      if (insert(input[j])) {
        // a unique row is found, display it
        displayRow(input, j);
      }

    }
  }

  // main method
  public static void main(String argvs[]) {
    // creating an object of the class UniqueRowsMatrix2
    prob2 obj = new prob2();

    // input binary matrix
    int maxtrix[][] = { { 0, 1, 1, 0, 0 },
        { 1, 0, 0, 1, 1 },
        { 0, 1, 1, 1, 1 },
        { 0, 1, 1, 0, 0 },
        { 0, 0, 1, 0, 1 }
    };

    // row length of the matrix
    int row = maxtrix.length;

    // column length of the matrix
    int col = maxtrix[0].length;

    System.out.println("For the following matrix: ");

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        System.out.print(maxtrix[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println();
    System.out.println("The unique rows are: ");
    obj.filterAndPrintUniqueRows(maxtrix, row, col);

    System.out.println("\n");

    // input binary matrix
    int matrix1[][] = { { 0, 1, 1, 0 },
        { 1, 0, 1, 0 },
        { 0, 1, 1, 0 },
        { 1, 0, 0, 1 }
    };

    // row length of the matrix
    row = matrix1.length;

    // column length of the matrix
    col = matrix1[0].length;

    System.out.println("For the following matrix: ");

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        System.out.print(matrix1[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println();
    System.out.println("The unique rows are: ");
    obj.filterAndPrintUniqueRows(matrix1, row, col);

  }

}
