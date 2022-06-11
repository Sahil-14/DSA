import java.util.*;

/**
 * Permute two arrays such that sum of every pair is greater or equal to K
 * 
 * 
 * Input : a[] = {2, 1, 3},
 * b[] = { 7, 8, 9 },
 * k = 10.
 * Output : Yes
 * Permutation a[] = { 1, 2, 3 } and b[] = { 9, 8, 7 }
 * satisfied the condition a[i] + b[i] >= K.
 * 
 * Input : a[] = {1, 2, 2, 1},
 * b[] = { 3, 3, 3, 4 },
 * k = 5.
 * Output : No
 * 
 * 
 */
public class prob3 {
  static boolean isPossible(int a[], int b[], int n, int k) {
    Integer[] newA = Arrays.stream(a).boxed().toArray(Integer[]::new);
    Arrays.sort(newA, Collections.reverseOrder());
    Arrays.sort(b);
    for (int i = 0; i < n; i++)
      if (newA[i] + b[i] < k)
        return false;

    return true;
  }

  public static void main(String[] args) {
    int a[] = { 2, 1, 3 };
    int b[] = { 7, 8, 9 };
    int k = 10;
    int n = a.length;

    if (isPossible(a, b, n, k))
      System.out.print("Yes");
    else
      System.out.print("No");
  }
}
