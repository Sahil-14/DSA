
// given is an  array with n elements that represents n positionas along a
// straight line .
// find k elements such that the mininum distance between
// any 2 elements is the maximum possible
import java.util.*;

public class bs_prob1 {

  static public boolean isFisible(int arr[], int mid, int n, int k) {
    int elements = 1, pos = arr[0];
    for (int i = 1; i < n; i++) {
      if (arr[i] - pos >= mid) {
        pos = arr[i];
        elements++;
        if (elements == k) {
          return true;
        }
      }
    }
    return false;
  }

  static public int largestminDistance(int arr[], int n, int k) {
    Arrays.sort(arr);
    int result = -1;
    int left = 1;
    int right = arr[n - 1];
    while (left < right) {
      int mid = (left + right) / 2;
      if (isFisible(arr, mid, n, k)) {
        result = Math.max(result, mid);
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 8, 4, 9 };
    int n = 5;
    int k = 3;
    System.out.println("Largest minimum distance is :" + largestminDistance(arr, n, k));

  }
}
