public class prob6 {
  static int maxLevel(int[] boxes, int n) {

    // Sort objects in increasing order
    // of widths
    Arrays.sort(boxes);

    int ans = 1; // Initialize result

    // Total width of previous level
    // and total number of objects in
    // previous level
    int prev_width = boxes[0];
    int prev_count = 1;

    // Number of object in current
    // level.
    int curr_count = 0;

    // Width of current level.
    int curr_width = 0;
    for (int i = 1; i < n; i++) {
      // Picking the object. So
      // increase current width
      // and number of object.
      curr_width += boxes[i];
      curr_count += 1;

      // If current width and
      // number of object
      // are greater than previous.
      if (curr_width > prev_width &&
          curr_count > prev_count) {

        // Update previous width,
        // number of object on
        // previous level.
        prev_width = curr_width;
        prev_count = curr_count;

        // Reset width of current
        // level, number of object
        // on current level.
        curr_count = 0;
        curr_width = 0;

        // Increment number of
        // level.
        ans++;
      }
    }

    return ans;
  }
}
