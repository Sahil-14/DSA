import java.util.Arrays;
import java.util.Comparator;
import java.util.*;

/**
 * 
 * Suppose you have a random list of people standing in a queue. Each person is
 * described by a pair of integers (h, k), where h is the height of the person
 * and k is the number of people in front of this person who have a height
 * greater than or equal to h. Write an algorithm to reconstruct the queue.
 * 
 * Note: The number of people is less than 1,100.
 * 
 * Input:
 * * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * *
 * * Output:
 * * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 
 * 
 */

public class prob4 {
  public static void reconstructQueue(int[][] people) {
    Arrays.sort(people, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0]) {
          return o1[1] - o2[1];
        } else {
          return o2[0] - o1[0];
        }
      }
    });

    for (int[] temp : people) {
      System.out.println("[" + temp[0] + "," + temp[1] + "]");
    }
    System.out.println("==========");

    List<int[]> resultList = new LinkedList<>();
    for (int[] cur : people) {
      resultList.add(cur[1], cur);
    }

    for (int[] temp : resultList) {
      System.out.println("[" + temp[0] + "," + temp[1] + "]");
    }
  }

  public static void main(String arg[]) {
    int arr[][] = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
    reconstructQueue(arr);
    // for (int[] temp : arr) {
    // System.out.println("[" + temp[0] + "," + temp[1] + "]");
    // }

  }

}
