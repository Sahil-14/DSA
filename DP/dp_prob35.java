// Longest bitonic subsequence
//sequece which increased then decreses
//calculate longes incresing subsequece from left nad right and add
public class dp_prob35 {
  public static int bionicSubsequence(int arr[]) {
    int L[] = new int[arr.length];
    int R[] = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      L[i] = R[i] = 1;
    }

    for (int i = 1; i < arr.length; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) {
          if (L[i] < L[j] + 1) {
            L[i] = L[j] + 1;
          }
        }
      }
    }

    for (int i = arr.length - 2; i >= 0; i--) {
      for (int j = arr.length - 1; j >= 0; j--) {
        if (arr[i] > arr[j]) {
          if (R[i] < R[j] + 1) {
            R[i] = R[j] + 1;
          }
        }
      }
    }
    
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (L[i] + R[i] - 1 > max) {
        max = L[i] + R[i] - 1;
      }
    }
    System.out.println(max);
    return max;
  }

  public static void main(String[] args) {
    int arr[] = { 2, -1, 4, 3, 5, -1, 3, 2 };
    bionicSubsequence(arr);
  }
}
