
/**
 * Find the first circular tour that visits all petrol pumps
 * 
 * 
 * Suppose there is a circle. There are n petrol pumps on that circle. You are
 * given two sets of data.
 * 
 * The amount of petrol that every petrol pump has.
 * Distance from that petrol pump to the next petrol pump.
 * Calculate the first point from where a truck will be able to complete the
 * circle (The truck will stop at each petrol pump and it has infinite
 * capacity). Expected time complexity is O(n). Assume for 1-litre petrol, the
 * truck can go 1 unit of distance.
 * For example, let there be 4 petrol pumps with amount of petrol and distance
 * to next petrol pump value pairs as {4, 6}, {6, 5}, {7, 3} and {4, 5}. The
 * first point from where the truck can make a circular tour is 2nd petrol pump.
 * Output should be “start = 1” (index of 2nd petrol pump).
 * 
 * 
 * 
 */
public class SQ19 {
  // A petrol pump has petrol and distance to next petrol pump
  static class petrolPump {
    int petrol;
    int distance;

    // constructor
    public petrolPump(int petrol, int distance) {
      this.petrol = petrol;
      this.distance = distance;
    }
  }

  // method 1
  static int printTour(petrolPump arr[], int n) {
    int start = 0;
    int end = 1;
    int curr_petrol = arr[start].petrol - arr[start].distance;
    while (end != start || curr_petrol < 0) {
      if (curr_petrol < 0 && start != end) {
        curr_petrol -= arr[start].petrol - arr[start].distance;
        start = (start + 1) % n;
        if (start == 0)
          return -1;
      }
      curr_petrol += arr[end].petrol - arr[end].distance;
      end = (end + 1) % n;
    }
    return start;

  }

  // method 2
  static int printTour2(petrolPump p[], int n) {
    int start = 0, deficit = 0;
    int capacity = 0;
    for (int i = 0; i < n; i++) {
      capacity += p[i].petrol - p[i].distance;
      if (capacity < 0) {
        start = start + 1;
        deficit += capacity;
        capacity = 0;
      }
    }
    return (capacity + deficit >= 0) ? start : -1;
  }

  public static void main(String[] args) {

    petrolPump[] arr = { new petrolPump(6, 4),
        new petrolPump(3, 6),
        new petrolPump(7, 3) };

    int start = printTour(arr, arr.length);

    System.out.println(start == -1 ? "No Solution" : "Start = " + start);

  }

}
