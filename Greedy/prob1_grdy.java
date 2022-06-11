import java.util.*;

/**
 * You are given n activities with their start and finish times. Select the
 * maximum number of activities that can be performed by a single person,
 * assuming that a person can only work on a single activity at a time.
 * 
 * 
 */
public class prob1_grdy {
  static class Activity {
    int start;
    int end;

    public Activity(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  static void printMaxActivities(Activity arr[], int n) {
    Arrays.sort(arr, new Comparator<Activity>() {
      @Override
      public int compare(Activity a1, Activity a2) {
        return a1.end - a2.end;
      }
    });
    System.out.println(
        "Following activities are selected :");
    int i = 0;

    System.out.print("(" + arr[i].start + ", "
        + arr[i].end + "), ");
    for (int j = 1; j < n; j++) {
      if (arr[j].start >= arr[i].end) {
        System.out.print("(" + arr[j].start + ", "
            + arr[j].end + "), ");

        i = j;
      }
    }

  }

  public static void main(String[] args) {
    int n = 6;
    Activity arr[] = new Activity[n];
    arr[0] = new Activity(5, 9);
    arr[1] = new Activity(1, 2);
    arr[2] = new Activity(3, 4);
    arr[3] = new Activity(0, 6);
    arr[4] = new Activity(5, 7);
    arr[5] = new Activity(8, 9);

    printMaxActivities(arr, n);
  }
}
