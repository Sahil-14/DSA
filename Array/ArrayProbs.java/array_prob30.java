import java.util.Arrays;

// Minimum number of swaps required to sort an array
import java.util.*;

public class array_prob30 {
  public static void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static int minSwaps(int[] arr, int N) {
    int count = 0;
    HashMap<Integer, Integer> hm = new HashMap<>();
    int[] temp = Arrays.copyOfRange(arr, 0, N);

    Arrays.sort(temp);

    for (int i = 0; i < N; i++) {
      hm.put(arr[i], i);
    }
    for (int i = 0; i < N; i++) {
      if (arr[i] != temp[i]) {
        count++;
        int init = arr[i];
        swap(arr, i, hm.get(temp[i]));
        hm.put(init, hm.get(temp[i]));
        hm.put(temp[i], i);
      }
    }
    return count;
  }

  // Driver program to test the above function
  public static void main(String[] args)
      throws Exception {
    int[] a = { 101, 758, 315, 730, 472,
        619, 460, 479 };
    int n = a.length;
    // Output will be 5
    System.out.println(minSwaps(a, n));
  }
}
