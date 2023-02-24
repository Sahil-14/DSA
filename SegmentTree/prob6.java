import java.util.TreeMap;

/**
 * 
 * You are implementing a program to use as your calendar. We can add a new
 * event if adding the event will not cause a triple booking.
 * 
 * A triple booking happens when three events have some non-empty intersection
 * (i.e., some moment is common to all the three events.).
 * 
 * The event can be represented as a pair of integers start and end that
 * represents a booking on the half-open interval [start, end), the range of
 * real numbers x such that start <= x < end.
 * 
 * Implement the MyCalendarTwo class:
 * 
 * MyCalendarTwo() Initializes the calendar object.
 * boolean book(int start, int end) Returns true if the event can be added to
 * the calendar successfully without causing a triple booking. Otherwise, return
 * false and do not add the event to the calendar.
 * 
 * Input
 * ["MyCalendarTwo", "book", "book", "book", "book", "book", "book"]
 * [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
 * Output
 * [null, true, true, true, false, true, true]
 * 
 */

public class prob6 {
  TreeMap<Integer, Integer> delta;
  List<int[]> calender;
  List<int[]> overlap;

  public prob6() {
    delta = new TreeMap();
  }

  // method 1:
  public boolean book1(int start, int end) {
    for (int[] over : overlap) {
      if (start < over[1] && end > over[0]) {
        return false;
      }
    }

    for (int[] cal : calendar) {
      if (start < cal[1] && end > cal[0]) {
        overlap.add(new int[] { Math.min(start, cal[0]), Math.max(end, cal[1]) });
      }
    }
    calender.add(new int[] { start, end });
    return true;

  }

  // method 2 :

  public boolean book(int start, int end) {
    delta.put(start, delta.getOrDefault(start, 0) + 1);
    delta.put(end, delta.getOrDefault(end, 0) - 1);
    int active = 0;
    for (int d : delta.values()) {
      active += d;
      if (active >= 3) {
        delta.put(start, delta.getOrDefault(start, 0) - 1);
        delta.put(end, delta.getOrDefault(end, 0) + 1);
        if (delta.get(start) == 0) {
          delta.remove(start);
        }
        return false;
      }
    }
    return true;
  }

  public void checkSlot() {
    int arr[][] = { {}, { 10, 20 }, { 50, 60 }, { 10, 40 }, { 5, 15 }, { 5, 10 }, { 25, 55 } };
    for (int[] temp : arr) {
      if (temp.length == 0) {
        System.out.println("null");
      } else {
        boolean result = book(temp[0], temp[1]);
        System.out.println(result);
      }

    }
  }

  public static void main(String[] args) {
    prob6 obj = new prob6();
    obj.checkSlot();
  }
}

//ngo data collection appliation
/**
 * It is full stack application 
 * Here react is use for frontend of web application, react native is used for mobile application,
 * node.js is used for backend and mongodb is used as database
 * The main goal of project was to convert traditional paper based method to full automatic system
 * The basic idea behind this application to collect medical data related to various field from villages 
 * by keeping few constraint into consideration
 * 1) we have to collect data in their native language
 * 2) Store data in local storage | cloud storage depending upon network connectivity and sync data accordingly
 * 3)We have to find insites (analytics) from the gathered data.
 * 
 * React mobile application:
 * 1) i18 library is used to make application in different laguages
 * 2)NetInfo module - to check internet connection
 * 3) react native async storage - to store data locally
 * 
 * React web app - 
 * 1) chart.js for  graph analytic 
 * 2) redux for state management
 * 
 * 3)Backend
 * express - to create backend server
 * application consist of mainly 2 roles ngo representative , admin
 * hence middlewares are used to provide role based authentication & authorisation of diifernt routes
 * 
 * 
 *
 * 
 * 



