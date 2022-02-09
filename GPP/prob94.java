
// Activity selection problem
/**
 * The greedy choice is to always pick the next activity whose finish time is
 * least among the remaining activities and the start time is more than or equal
 * to the finish time of the previously selected activity. We can sort the
 * activities according to their finishing time so that we always consider the
 * next activity as minimum finishing time activity. 1) Sort the activities
 * according to their finishing time 2) Select the first activity from the
 * sorted array and print it. 3) Do the following for the remaining activities
 * in the sorted array. …….a) If the start time of this activity is greater than
 * or equal to the finish time of the previously selected activity then select
 * this activity and print it. In the following C implementation, it is assumed
 * that the activities are already sorted according to their finish time.
 * 
 */
import java.lang.reflect.Array;
import java.util.*;

// if finishing timing is not sorted
class Activity {
    int start;
    int finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

class Compare {
    static void compare(Activity arr[], int n) {
        Arrays.sort(arr, new Comparator<Activity>() {
            @Override
            public int compare(Activity s1, Activity s2) {
                return s1.finish - s2.finish;
            }
        });
    }
}

public class prob94 {
    // case 1: if finishing timing is already sorted
    static void printMaxActivitiesSorted(int s[], int e[], int n) {
        int i, j;

        Vector<Integer> ans = new Vector<>();
        ans.add(0);
        i = 0;
        for (j = 1; j < n; j++) {
            if (s[j] >= e[i]) {
                ans.add(j);
                i = j;
            }
        }

        for (int k = 0; k < ans.size(); k++) {
            System.out.println(ans.get(k) + " ");
        }
    }

    // case 2: not sorted
    static void printMaxActivitiesUnSorted(Activity arr[],int n){
        Compare obj = new Compare();
        obj.compare(arr,n);
        Vector<Integer> ans = new Vector<>();
        int i = 0;
        ans.add(0);
        for(int j = 1;j<n;j++){
            if(arr[j].start >= arr[i].finish){
                ans.add(j);
                i = j;
            }
        }
        for (int k = 0; k < ans.size(); k++) {
            System.out.println(arr[ans.get(k)].start + "  :"+arr[ans.get(k)].finish);
        }

    }

    public static void main(String[] args) {
        // sorted
        // int s[] = { 1, 3, 0, 5, 8, 5 };
        // int f[] = { 2, 4, 6, 7, 9, 9 };
        // int n = s.length;

        // printMaxActivitiesSorted(s, f, n);
        int n = 6;
        Activity arr[] = new Activity[n];
        arr[0] = new Activity(5, 9);
        arr[1] = new Activity(1, 2);
        arr[2] = new Activity(3, 4);
        arr[3] = new Activity(0, 6);
        arr[4] = new Activity(5, 7);
        arr[5] = new Activity(8, 9);
        printMaxActivitiesUnSorted(arr, n);
    }
}
