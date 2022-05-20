
public class array_prob13 {
  public static int maxProdSubarray(int arr[], int n) {
    int max_ending_here = arr[0];

    // min negative product ending
    // at the current position
    int min_ending_here = arr[0];

    // Initialize overall max product
    int max_so_far = arr[0];

    for (int i = 1; i < n; i++) {
      int temp = Math.max(arr[i], Math.max(arr[i] * max_ending_here, arr[i] * min_ending_here));
      min_ending_here = Math.min(arr[i], Math.min(arr[i] * max_ending_here, arr[i] * min_ending_here));
      max_ending_here = temp;
      max_so_far = Math.max(max_so_far, max_ending_here);
    }
    return max_so_far;
  }

  public static void main(String[] args) {
    int arr[] = { 1, -2, -3, 0, 7, -8, -2 };
    System.out.println(maxProdSubarray(arr, arr.length));
  }

}
