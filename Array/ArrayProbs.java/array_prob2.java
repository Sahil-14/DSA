// reverse the array

public class array_prob2 {

  public static void reverse(int arr[], int n) {
    if (arr.length <= 1) {
      return;
    }
    for (int i = 0; i < n / 2; i++) {
      int temp = arr[i];
      arr[i] = arr[n - i - 1];
      arr[n - i - 1] = temp;
    }
    printArray(arr, n);
  }

  static void reverseArray(int arr[], int n) {
    int temp;
    int start = 0, end = n - 1;
    while (start < end) {
      temp = arr[start];
      arr[start++] = arr[end];
      arr[end--] = temp;
    }
    printArray(arr, n);

  }

  public static void printArray(int arr[],
      int size) {
    for (int i = 0; i < size; i++)
      System.out.print(arr[i] + " ");

    System.out.println();
  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 4, 5, 6 };
    reverse(arr, arr.length);
    reverseArray(arr, arr.length);
  }
}
