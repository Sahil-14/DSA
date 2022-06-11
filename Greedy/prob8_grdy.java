
/**
 * 
 * Given an array of jobs where every job has a deadline and associated profit
 *
 *
 *
 * if the job is finished before the deadline. It is also given that every job
 * takes a single unit of time, so the minimum possible deadline for any job is
 * 1. How to maximize total profit if only one job can be scheduled at a time.
 * 
 * Input: Four Jobs with following
 * deadlines and profits
 * JobID Deadline Profit
 * a 4 20
 * b 1 10
 * c 1 40
 * d 1 30
 * Output: Following is maximum
 * profit sequence of jobs
 * c, a
 * 
 * 
 * Input: Five Jobs with following
 * deadlines and profits
 * JobID Deadline Profit
 * a 2 100
 * b 1 19
 * c 2 27
 * d 1 25
 * e 3 15
 * Output: Following is maximum
 * profit sequence of jobs
 * c, a, e
 * 
 * 
 * 
 */
import java.util.*;

public class prob8_grdy {
  char id;
  int deadline, profit;

  public prob8_grdy() {
  }

  public prob8_grdy(char id, int deadline, int profit) {
    this.id = id;
    this.deadline = deadline;
    this.profit = profit;
  }

  void printJobScheduling(ArrayList<prob8_grdy> arr, int t) {
    // Length of array
    int n = arr.size();
    // Sort all jobs according to decreasing order of
    // profit
    Collections.sort(arr, (a, b) -> b.profit - a.profit);
    // To keep track of free time slots
    boolean result[] = new boolean[t];
    // To store result (Sequence of jobs)
    char job[] = new char[t];

    for (int i = 0; i < n; i++) {
      // Find a free slot for this job (Note that we
      // start from the last possible slot)
      for (int j = Math.min(t - 1, arr.get(i).deadline - 1); j >= 0; j--) {
        if (result[j] == false) {
          result[j] = true;
          job[j] = arr.get(i).id;
          break;
        }
      }

    }

    // Print the sequence
    for (char jb : job)
      System.out.print(jb + " ");
    System.out.println();
  }

  // method 2 optimised using maxheap (nlogn)
  // a class to represent job
  static class Job {
    char job_id;
    int deadline;
    int profit;

    Job(char job_id, int deadline, int profit) {
      this.deadline = deadline;
      this.job_id = job_id;
      this.profit = profit;
    }
  }

  static void printJobScheduling(ArrayList<Job> arr) {
    int n = arr.size();
    // sorting the array on the
    // basis of their deadlines
    Collections.sort(arr, (a, b) -> {
      return a.deadline - b.deadline;
    });

    for (int i = n - 1; i > -1; i--) {
      int slots_available = 0;

      if (i == 0) {
        slots_available = arr.get(i).deadline;
      } else {
        slots_available = arr.get(i).deadline - arr.get(i - 1).deadline;
      }

      // include the profit of job(as priority),
      // deadline and job_id in maxHeap
      maxHeap.add(arr.get(i));

      while (slot_available > 0
          && maxHeap.size() > 0) {

        // get the job with max_profit
        Job job = maxHeap.remove();

        // reduce the slots
        slot_available--;

        // include the job in the result array
        result.add(job);
      }
    }

    // jobs included might be shuffled
    // sort the result array by their deadlines
    Collections.sort(result, (a, b) -> {
      return a.deadline - b.deadline;
    });
    for (Job job : result) {
      System.out.print(job.job_id + " ");
    }
    System.out.println();
  }

  // Driver code
  public static void main(String args[]) {
    ArrayList<prob8_grdy> arr = new ArrayList<prob8_grdy>();
    arr.add(new prob8_grdy('a', 2, 100));
    arr.add(new prob8_grdy('b', 1, 19));
    arr.add(new prob8_grdy('c', 2, 27));
    arr.add(new prob8_grdy('d', 1, 25));
    arr.add(new prob8_grdy('e', 3, 15));

    // Function call
    System.out.println(
        "Following is maximum profit sequence of jobs");

    prob8_grdy job = new prob8_grdy();

    // Calling function
    job.printJobScheduling(arr, 3);
  }

}
