
public class array_prob29 {
  // Minimum swaps required to bring all elements less than or equal to k together
  private static int minSwap(int[] arr, int n, int k) {
    int snowBall = 0;
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] > k) {
        snowBall++;
      } else if (snowBall > 0) {
        int temp = arr[i];
        arr[i] = arr[i - snowBall];
        arr[i - snowBall] = arr[i];
        count++;
      }
    }
    return count;
  }

  // arrange even before odd
  private static void segregateEvenBeforeOdd(int arr[], int n) {
    int i = -1, j = 0;
    for (j = 0; j < n; j++) {
      if (arr[j] % 2 == 0) {
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    for (Integer k : arr) {
      System.out.println(k);
    }
  }

  // segregate 0 and 1
  public static void segeregateO1_A(int arr[], int n) {

    int count = 0; // counts the no of zeros in arr

    for (int i = 0; i < n; i++) {
      if (arr[i] == 0)
        count++;
    }

    // loop fills the arr with 0 until count
    for (int i = 0; i < count; i++)
      arr[i] = 0;

    // loop fills remaining arr space with 1
    for (int i = count; i < n; i++)
      arr[i] = 1;

    for (Integer k : arr) {
      System.out.print(k + ' ');
    }
  }

  public static void segeregateO1_b(int arr[], int n) {
    int l = 0, r = n - 1;
    while (l < r) {
      while (arr[l] == 0 && l < r) {
        l++;
      }

      while (arr[r] == 1 && l < r) {
        r--;
      }
      if (l < r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = arr[l];
        l++;
        r--;
      }
    }
  }

  public static void main(String[] args) {

    // int arr[] = { 1, 3, 2, 4, 7,
    // 6, 9, 10 };
    // int n = arr.length;
    // segregateEvenBeforeOdd(arr, n);
    int arr[] = new int[] { 0, 1, 0, 1, 1, 1 };
    int n = arr.length;
    segeregateO1_A(arr, n);

  }
}
