import java.util.Arrays;
import java.util.Comparator;

class Interval {
  int start;
  int end;

  Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
}

public class array_prob18 {
  public static void mergeIntervals(Interval arr[]) {
    Arrays.sort(arr, new Comparator<Interval>() {
      public int compare(Interval i1, Interval i2) {
        return i1.start - i2.start;
      }
    });

    int index = 0; //
    // i = 1
    for (int i = 1; i < arr.length; i++) {
      if (arr[index].end >= arr[i].start) {
        arr[index].end = Math.max(arr[index].end, arr[i].end);
      } else {
        index++;
        arr[index] = arr[i];
      }
    }
    System.out.print("The Merged Intervals are: ");
    for (int i = 0; i <= index; i++) {
      System.out.print("[" + arr[i].start + ","
          + arr[i].end + "]");
    }
  }

  public static void main(String args[]) {
    Interval arr[] = new Interval[4];

    arr[1] = new Interval(1, 2);
    arr[2] = new Interval(3, 4);
    arr[3] = new Interval(3, 7);
    arr[0] = new Interval(6, 8);
    mergeIntervals(arr);
  }
}
