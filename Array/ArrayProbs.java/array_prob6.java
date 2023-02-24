public class array_prob6 {
  public static int searchSortedAndRotated(int arr[], int n, int left, int right, int key) {
    if (left > right) {
      return -1;
    }
    int mid = (left + right) / 2;
    if (arr[mid] == key) {
      return mid;
    }

    
    if (arr[left] <= arr[mid]) {
      if (key >= arr[left] && key <= arr[mid]) {
        return searchSortedAndRotated(arr, n, left, mid - 1, key);
      }
      return searchSortedAndRotated(arr, n, mid + 1, right, key);
    }

    if (key >= arr[mid] && key <= arr[right]) {
      return searchSortedAndRotated(arr, n, mid + 1, right, key);
    }

    return searchSortedAndRotated(arr, n, left, mid - 1, key);
  }

  //time : logn
  // space: 1

  // 4, 5, 6, 7, 8, 9, 1, 2, 3
  // 0, 1, 2, 3, 4, 5, 6, 7, 8

  public static void main(String args[]) {
    int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
    int n = arr.length;
    int key = 6;
    int i = searchSortedAndRotated(arr, n, 0, n - 1, key);
    if (i != -1)
      System.out.println("Index: " + i);
    else
      System.out.println("Key not found");
  }
}