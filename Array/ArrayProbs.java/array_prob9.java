//find minimum element in sorted and rotated array
public class array_prob9 {
  public static int findMin(int arr[]) {
    if (arr.length == 0) {
      return -1;
    }

    if (arr.length == 1) {
      return arr[0];
    }

    int left = 0, right = arr.length - 1;
    if (arr[left] < arr[right]) {
      return arr[0];
    }
    ;

    while (right >= left) {
      int mid = left + (right - left) / 2;
      if (arr[mid] > arr[mid + 1]) {
        return arr[mid + 1];
      }

      if (arr[mid - 1] > arr[mid]) {
        return arr[mid];
      }

      if (arr[right] > arr[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;

  }

  public static void main(String[] args) {
    int arr[] = { 4, 5, 6, 7, 2, 3 };
    System.out.println(findMin(arr));
  }
}
