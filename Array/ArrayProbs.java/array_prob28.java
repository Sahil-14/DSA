import java.util.*;

public class array_prob28 {
  // Even numbers at even index and odd numbers at odd index
  public static void arrange1(int arr[]) {
    int n = arr.length;
    int oddInx = 1;
    int evenInx = 0;
    while (true) {
      while (oddInx < n && arr[oddInx] % 2 == 1) {
        oddInx += 2;
      }
      while (evenInx < n && arr[evenInx] % 2 == 0) {
        evenInx += 2;
      }
      if (oddInx < n && evenInx < n) {
        int temp = arr[oddInx];
        arr[oddInx] = arr[evenInx];
        arr[evenInx] = temp;
      } else {
        break;
      }
    }
    for (Integer i : arr) {
      System.out.print(i + " ");
    }

  }

  // segeregate even after odd
  public static void arrange2(int arr[]) {
    int n = arr.length;
    int l = 0;
    int r = arr.length - 1;
    while (l < r) {
      while (l <= n - 1 && arr[l] < 0) {
        l++;
      }
      while (r >= 0 && arr[r] > 0) {
        r--;
      }

      if (l < r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
      }
    }
    for (Integer i : arr) {
      System.out.print(i + " ");
    }
  }

  // negative positive alternate
  public static void arrange3(int arr[]) {
    int n = arr.length;
    int nIndex = 0;
    int pIndex = 1;

    while (true) {
      while (nIndex < n && arr[nIndex] < 0) {
        nIndex += 2;
      }
      while (pIndex < n && arr[pIndex] > 0) {
        pIndex += 2;
      }

      if (nIndex < n && pIndex < n) {
        int temp = arr[nIndex];
        arr[nIndex] = arr[pIndex];
        arr[pIndex] = temp;
      }

      else {
        break;
      }

    }
    for (Integer i : arr) {
      System.out.print(i + " ");
    }
  }

  // move all o at end
  public static void arrange4(int arr[]) {
    int n = arr.length;
    int j = 0; // last index for non zero
    for (int i = 0; i < n; i++) {
      if (arr[i] != 0) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        j++;
      }
    }

    for (Integer i : arr) {
      System.out.print(i + " ");
    }

  }

  // Rearrange an array such that arr[i] = i
  public static void arrange5(int arr[]) {
    int n = arr.length;
    Set<Integer> s = new HashSet<>();
    for (Integer i : arr) {
      s.add(i);
    }

    for (int i = 0; i < n; i++) {
      if (s.contains(i)) {
        arr[i] = i;
      } else {
        arr[i] = -1;
      }
    }
    for (Integer i : arr) {
      System.out.print(i + " ");
    }
  }

  // cyclic sort
  public static void arrange5_B(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n;) {
      if (arr[i] > 0 && arr[i] != i) {
        int temp = arr[arr[i]];
        arr[arr[i]] = arr[i];
        arr[i] = temp;
      } else {
        i++;
      }
    }
  }

  // Rearrange positive and negative numbers in O(n) time and O(1) extra space
  /**
   * 
   * For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9], then the
   * output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]
   */
  public static void arrange3_B(int arr[]) {
    int n = arr.length;
    int i = -1, j = 0;
    for (j = 0; j < n; j++) {
      if (arr[j] < 0) {
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    int neg = 0, pos = i + 1;
    while (pos < n && neg < pos && arr[neg] < 0) {
      int temp = arr[neg];
      arr[neg] = arr[pos];
      arr[pos] = temp;
      pos++;
      neg += 2;
    }
    for (Integer k : arr) {
      System.out.print(i + " ");
    }
  }

  public static void main(String[] args) {
    // int arr[] = { 3, 6, 12, 1, 5, 8 };
    // arrange1(arr);
    int arr[] = { -3, 6, 12, -1, 5, -8 };
    arrange2(arr);
    // int arr[] = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
    // arrange3(arr);
    // arrange3_B(arr);
    // int[] arr = { 5, 6, 0, 4, 6, 0, 9, 0, 8 };
    // arrange4(arr);
    // int arr[] = { -1, -1, 6, 1, 9,
    // 3, 2, -1, 4, -1 };
    // arrange5(arr);

  }

}
