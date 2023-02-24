package ArrayProbs.java;

import DoubleLinkedList.rotate;

//find peak element
/**
 * Given an array of integers. Find a peak element in it. An array element is a
 * peak if it is NOT smaller than its neighbours. For corner elements, we need
 * to consider only one neighbour
 * 
 */

public class array_prob32 {
  // linear search
  public int findPeak(int arr[]) {

    int n = arr.length;
    if (n == 1) {
      return 0;
    }

    if (arr[0] >= arr[1]) {
      return 0;
    }
    if (arr[n - 1] >= arr[n - 2]) {
      return n - 1;
    }

    for (int i = 1; i < n - 1; i++) {
      if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]) {
        return i;
      }
    }
    return 0;
  }

  // binary search iterative
  static int findPeak2(int arr[], int n) {
    int l = 0;
    int r = n - 1;
    int mid = 0;
    while (l <= r) {
      mid = (l + r) >> 1;
      ;
      if ((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == n - 1 || arr[mid] >= arr[mid + 1])) {
        break;
      } else if (mid > 0 && arr[mid - 1] > arr[mid]) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    return mid;
  }

  // recursive
  static int findPeakUtil(
      int arr[], int low, int high, int n) {
    // Find index of middle element
    // low + (high - low) / 2
    int mid = low + (high - low) / 2;

    // Compare middle element with its
    // neighbours (if neighbours exist)
    if ((mid == 0 || arr[mid - 1] <= arr[mid])
        && (mid == n - 1 || arr[mid + 1] <= arr[mid]))
      return mid;

    // If middle element is not peak
    // and its left neighbor is
    // greater than it, then left half
    // must have a peak element
    else if (mid > 0 && arr[mid - 1] > arr[mid])
      return findPeakUtil(arr, low, (mid - 1), n);

    // If middle element is not peak
    // and its right neighbor
    // is greater than it, then right
    // half must have a peak
    // element
    else
      return findPeakUtil(
          arr, (mid + 1), high, n);
  }

  // A wrapper over recursive function
  // findPeakUtil()
  static int findPeak3(int arr[], int n) {
    return findPeakUtil(arr, 0, n - 1, n);
  }
}
