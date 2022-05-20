
public class array_prob1 {

  public static int min(int arr[], int n) {
    int min = arr[0];
    for (int i = 1; i < n; i++) {
      if (arr[i] < min) {
        min = arr[i];
      }
    }
    return min;
  }

  public static int max(int arr[], int n) {
    int max = arr[0];
    for (int i = 1; i < n; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 4, 5, 6 };
    System.out.println(min(arr, arr.length));
    System.out.println(max(arr, arr.length));

  }
}
