/**
 * Searching in an array where adjacent differ by at most k
 * 
 * 
 * Input : arr[] = {4, 5, 6, 7, 6}
 * k = 1
 * x = 6
 * Output : 2
 * The first index of 6 is 2.
 * 
 * Input : arr[] = {20, 40, 50, 70, 70, 60}
 * k = 20
 * x = 60
 * Output : 5
 * The index of 60 is 5
 * 
 * 
 */
public class prob5 {
  // x is the element to be searched
  // in arr[0..n-1] such that all
  // elements differ by at-most k.
  static int search(int arr[], int n,
      int x, int k) {
    int i = 0;
    while (i < n) {
      if (arr[i] == x) {
        return i;
      }
      // Jump the difference between
      // current array element and x
      // divided by k We use max here
      // to make sure that i moves
      // at-least one step ahead.
      i = i + Math.max(1, Math.abs(arr[i] - x) / k);
    }
    return -1;
  }

  static int searchAtmost1(int arr[], int n, int x) {

    // Traverse the given array starting
    // from leftmost element
    int i = 0;
    while (i < n) {

      // If x is found at index i
      if (arr[i] == x)
        return i;

      // Jump the difference between current
      // array element and x
      i = i + Math.abs(arr[i] - x);
    }

    System.out.println("number is not" +
        " present!");

    return -1;
  }

  // Driver program to test above function
  public static void main(String[] args) {

    int arr[] = { 8, 7, 6, 7, 6, 5, 4, 3,
        2, 3, 4, 3 };
    int n = arr.length;
    int x = 3;
    System.out.println("Element " + x +
        " is present at index "
        + search(arr, n, 3));
  }
}
