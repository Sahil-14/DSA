import java.util.HashMap;
import java.util.Map;

/**
 * Find Itinerary from a given list of tickets
 * 
 * 
 * Input:
 * "Chennai" -> "Banglore"
 * "Bombay" -> "Delhi"
 * "Goa" -> "Chennai"
 * "Delhi" -> "Goa"
 * 
 * Output:
 * Bombay->Delhi, Delhi->Goa, Goa->Chennai, Chennai->Banglore,
 * 
 * 1) Create a HashMap of given pair of tickets. Let the created
 * HashMap be 'dataset'. Every entry of 'dataset' is of the form
 * "from->to" like "Chennai" -> "Banglore"
 * 
 * 2) Find the starting point of itinerary.
 * a) Create a reverse HashMap. Let the reverse be 'reverseMap'
 * Entries of 'reverseMap' are of the form "to->form".
 * Following is 'reverseMap' for above example.
 * "Banglore"-> "Chennai"
 * "Delhi" -> "Bombay"
 * "Chennai" -> "Goa"
 * "Goa" -> "Delhi"
 * 
 * b) Traverse 'dataset'. For every key of dataset, check if it
 * is there in 'reverseMap'. If a key is not present, then we
 * found the starting point. In the above example, "Bombay" is
 * starting point.
 * 
 * 3) Start from above found starting point and traverse the 'dataset'
 * to print itinerary.
 * 
 */

public class prob12 {
  private static void printResult(Map<String, String> dataset) {
    Map<String, String> reverseMap = new HashMap<String, String>();

    for (Map.Entry<String, String> entry : dataset.entrySet()) {
      reverseMap.put(entry.getValue(), entry.getKey());
    }

    String start = null;

    for (Map.Entry<String, String> entry : dataset.entrySet()) {
      if (!reverseMap.containsKey(entry.getKey())) {
        start = entry.getKey();
        break;
      }
    }

    if (start == null) {
      System.out.println("Invalid Input");
      return;
    }

    // Once we have starting point, we simple need to go next, next
    // of next using given hash map
    String to = dataset.get(start);
    while (to != null) {
      System.out.print(start + "->" + to + ", ");
      start = to;
      to = dataset.get(to);
    }
  }

  // Driver function
  public static void main(String[] args) {
    Map<String, String> dataSet = new HashMap<String, String>();
    dataSet.put("Chennai", "Banglore");
    dataSet.put("Bombay", "Delhi");
    dataSet.put("Goa", "Chennai");
    dataSet.put("Delhi", "Goa");

    printResult(dataSet);
  }

}
