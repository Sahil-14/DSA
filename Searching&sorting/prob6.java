/**
 * Ceiling in a sorted array
 * 
 * Given a sorted array and a value x, the ceiling of x is the smallest element
 * in array greater than or equal to x, and the floor is the greatest element
 * smaller than or equal to x. Assume than the array is sorted in non-decreasing
 * order. Write efficient functions to find floor and ceiling of x.
 */
public class prob6 {
  // method1:linear search
  static int ceilSearch(int arr[], int low, int high, int x) {
    int i;
    if (x <= low) {
      return low;
    }
    for (i = low; i < high; i++) {
      if (arr[i] == x) {
        return i;
      }

      if (x > arr[i] && x <= arr[i + 1]) {
        return i + 1;
      }
    }
    return -1;
  }
  // method 2 : binary search

  static int ceilSearch2(int arr[], int low, int high, int x) {
    // base condition if length of arr == 0 then return -1
    if (arr.length == 0) {
      return -1;
    }
    /*
     * this while loop function will run until condition not break once condition
     * break
     * loop will return start and ans is low which will be next smallest greater
     * than target
     * which is ceiling
     */
    while (low <= high) {
      int mid = low + (high - low) / 2;// calculate mid

      if (x == arr[mid]) {
        return mid;
      }
      if (x < arr[mid]) {
        high = mid - 1;
      }

      else {
        low = mid + 1;
      }
    }
    return low;
  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 8, 10, 10, 12, 19 };
    int n = arr.length;
    int x = 8;
    int index = ceilSearch2(arr, 0, n - 1, x);
    if (index == -1)
      System.out.println("Ceiling of " + x + " doesn't exist in array");
    else
      System.out.println("ceiling of " + x + " is " + arr[index]);
  }
}
