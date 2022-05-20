//search in sorted and rotated array

public class bs_prob4 {
  public static int searchInSoredRotated(int arr[], int key, int left, int right) {
    if (left > right) {
      return -1;
    }

    int mid = (left + right) / 2;
    if (arr[mid] == key) {
      return mid;
    }

    if (arr[left] <= arr[mid]) {
      if (key >= arr[left] && key <= arr[mid]) {
        return searchInSoredRotated(arr, key, left, mid - 1);
      }
      return searchInSoredRotated(arr, key, mid + 1, right);
    }

    if (key >= arr[mid] && key <= arr[right]) {
      return searchInSoredRotated(arr, key, mid + 1, right);
    } else {
      return searchInSoredRotated(arr, key, left, mid - 1);
    }
  }

  public static void main(String[] args) {
    int arr[] = { 30, 40, 50, 10, 20 };
    System.out.println(searchInSoredRotated(arr, 10, 0, 4));
  }
}
