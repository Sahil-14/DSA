
import java.util.*;

//median of 2 sorted array;
public class array_prob33 {
  // method1
  public int solution(int[] arr) {
    int n = arr.length;
    if (n % 2 == 0) {
      int z = n / 2;
      int e = arr[z];
      int q = arr[z - 1];

      int ans = (e + q) / 2;
      return ans;
    } else {
      int z = Math.round(n / 2);
      return arr[z];
    }
  }

  // Time Complexity: O((n+m) Log (n+m))

  // public static void main(String[] args) {

  // // TODO Auto-generated method stub
  // int[] arr1 = { -5, 3, 6, 12, 15 };
  // int[] arr2 = { -12, -10, -6, -3, 4, 10 };

  // int i = arr1.length;
  // int j = arr2.length;

  // int[] arr3 = new int[i + j];

  // System.arraycopy(arr1, 0, arr3, 0, i);
  // System.arraycopy(arr2, 0, arr3, i, j);
  // Arrays.sort(arr3);
  // System.out.print("Median = " + solution(arr3));

  // }

  // method 2 : merge in efficient way and calculate
  static int getMedian(int arr1[], int arr2[],
      int n, int m) {
    int i = 0;
    int j = 0;
    int count;
    int m1 = -1;
    int m2 = -1;

    if ((m + n) % 2 == 1) {
      for (count = 0; count <= (n + m) / 2; count++) {
        if (i != n && j != m) {
          m1 = (arr1[i] > arr2[j]) ? arr2[j++] : arr1[i++];
        }

        else if (i < n) {
          m1 = arr1[i++];
        }

        else {
          m1 = arr2[j++];
        }

      }
      return m1;
    } else {
      for (count = 0; count <= (n + m) / 2; count++) {
        m2 = m1;
        if (i != n && j != m) {
          m1 = (arr1[i] > arr2[j]) ? arr2[j++] : arr1[i++];
        }

        else if (i < n) {
          m1 = arr1[i++];
        }

        else {
          m1 = arr2[j++];
        }
      }

      return (m1 + m2) / 2;

    }

  }

  // Driver code
  public static void main(String[] args) {
    int ar1[] = { 900 };
    int ar2[] = { 5, 8, 10, 20 };

    int n1 = ar1.length;
    int n2 = ar2.length;

    System.out.println(getMedian(ar1, ar2, n1, n2));
  }

}
