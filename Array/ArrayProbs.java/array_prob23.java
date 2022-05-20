// Print all possible combinations of r elements in a given array of size n

import java.util.*;

public class array_prob23 {

  public static void combination(int arr[], int data[], int start, int end, int index, int r) {
    if (index == r) {
      for (int j = 0; j < r; j++) {
        System.out.print(data[j] + " ");
      }
      System.out.println();
      return;
    }

    for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
      data[index] = arr[i];
      combination(arr, data, i + 1, end, index + 1, r);
    }
  }

  public static void main(String[] args) {
    Scanner sr = new Scanner(System.in);
    int n = sr.nextInt();
    int a[] = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sr.nextInt();
    }

    int r = sr.nextInt();
    int data[] = new int[r];
    combination(a, data, 0, n - 1, 0, r);

  }
}
