/**
 * Given a paper of size, A x B. Task is to cut the paper into squares of any
 * size. Find the minimum number of squares that can be cut from the paper.
 * 
 * Input : 13 x 29
 * Output : 9
 * Explanation :
 * 2 (squares of size 13x13) +
 * 4 (squares of size 3x3) +
 * 3 (squares of size 1x1)=9
 * 
 * Input : 4 x 5
 * Output : 5
 * Explanation :
 * 1 (squares of size 4x4) +
 * 4 (squares of size 1x1)
 * 
 * 
 * 
 * We know that if we want to cut a minimum number of squares from the paper
 * then we would have to cut the largest square possible from the paper first
 * and the largest square will have the same side as the smaller side of the
 * paper. For example, if the paper has the size 13 x 29, then the maximum
 * square will be of side 13. so we can cut 2 square of size 13 x 13 (29/13 =
 * 2). Now remaining paper will have size 3 x 13. Similarly, we can cut the
 * remaining paper by using 4 squares of size 3 x 3 and 3 squares of 1 x 1. So a
 * minimum of 9 squares can be cut from the Paper of size 13 x 29.
 * 
 * 
 * 
 */

public class prob14_grdy {
  // To swap two numbers
  static void swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
  }

  static int minimumSquare(int a, int b) {

    int result = 0, rem = 0;
    if (a < b) {
      swap(a, b);
    }
    // Iterate until small size side is
    // greater then 0
    while (b > 0) {
      result += a / b;
      rem = a % b;
      a = b;
      b = rem;
    }
    return result;

  }

  // Driver code
  public static void main(String[] args) {
    int n = 13, m = 29;
    System.out.println(minimumSquare(n, m));
  }
}
