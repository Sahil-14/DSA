import java.util.*;

/**
 * 
 * Implement a MyCalendar class to store your events. A new event can be added
 * if adding the event will not cause a double booking.
 * 
 * Your class will have the method, book(int start, int end). Formally, this
 * represents a booking on the half open interval [start, end), the range of
 * real numbers x such that start <= x < end.
 * 
 * A double booking happens when two events have some non-empty intersection
 * (ie., there is some time that is common to both events.)
 * 
 * For each call to the method MyCalendar.book, return true if the event can be
 * added to the calendar successfully without causing a double booking.
 * Otherwise, return false and do not add the event to the calendar.
 * 
 * Your class will be called like this: MyCalendar cal = new MyCalendar();
 * MyCalendar.book(start, end)
 * 
 * Example 1:
 * MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(15, 25); // returns false
 * MyCalendar.book(20, 30); // returns true
 * 
 */
public class prob3 {

  public static boolean book(int start, int end, TreeMap<Integer, Integer> calendar) {
    Integer prev = calendar.floorKey(start);
    Integer next = calendar.ceilingKey(start);
    if ((prev == null || calendar.get(prev) <= start) && (next == null || next >= end)) {
      calendar.put(start, end);
      return true;
    }
    return false;
  }

  public static void main(String arg[]) {
    int arr[][] = { {}, { 10, 20 }, { 15, 25 }, { 20, 30 } };
    TreeMap<Integer, Integer> calendar = new TreeMap<>();
    for (int[] temp : arr) {
      if (temp.length == 0) {
        System.out.println(true);
      } else {
        boolean result = book(temp[0], temp[1], calendar);
        System.out.println(result);
      }
    }

  }
}
