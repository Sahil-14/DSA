import java.util.Arrays;

/**
 * 
 * We are given a row-wise sorted matrix of size r*c, we need to find the median
 * of the matrix given. It is assumed that r*c is always odd.
 * 1, we find the minimum and maximum elements in the matrix. The minimum
 * element can be easily found by comparing the first element of each row, and
 * similarly, the maximum element can be found by comparing the last element of
 * each row.
 * 
 * Then we use binary search on our range of numbers from minimum to maximum, we
 * find the mid of the min and max and get a count of numbers less than or equal
 * to our mid. And accordingly change the min or max.
 * 
 * For a number to be median, there should be (r*c)/2 numbers smaller than that
 * number. So for every number, we get the count of numbers less than that by
 * using upper_bound() in each row of the matrix, if it is less than the
 * required count, the median must be greater than the selected number, else the
 * median must be less than or equal to the selected number.
 * 
 */

public class mat_prob3 {
  static int binaryMedian(int m[][], int r, int c) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < r; i++) {
      if (m[i][0] < min) {
        min = m[i][0];
      }

      if (m[i][c - 1] > max) {
        max = m[i][c - 1];
      }
    }

    int desired = (r * c + 1) / 2;
    while (min < max) {
      int mid = min + (max - min) / 2;
      int place = 0;
      int get = 0;

      for (int i = 0; i < r; ++i) {
        get = Arrays.binarySearch(m[i], mid);
        // If element is not found in the array the
        // binarySearch() method returns
        // (-(insertion_point) - 1). So once we know
        // the insertion point we can find elements
        // Smaller than the searched element by the
        // following calculation
        if (get < 0)
          get = Math.abs(get) - 1;

        // If element is found in the array it returns
        // the index(any index in case of duplicate). So we go to last
        // index of element which will give the number of
        // elements smaller than the number including
        // the searched element.
        else {
          while (get < m[i].length && m[i][get] == mid)
            get += 1;
        }
        place = place + get;

      }
      if (place < desired)
        min = mid + 1;
      else
        max = mid;

    }

    return min;

  }
}
