import java.util.HashMap;

// Find a pair with the given difference

public class prob7 {

  // The function assumes that the array is sorted
  static boolean findPair(int arr[], int n) {
    int size = arr.length;

    // Initialize positions of two elements
    int i = 0, j = 1;

    // Search for a pair
    while (i < size && j < size) {
      if (i != j && (arr[j] - arr[i] == n || arr[i] - arr[j] == n)) {
        System.out.print("Pair Found: " +
            "( " + arr[i] + ", " + arr[j] + " )");
        return true;
      } else if (arr[j] - arr[i] < n)
        j++;
      else
        i++;
    }

    System.out.print("No such pair");
    return false;
  }

  public static void findPairMap(int arr[], int d) {
    int n = arr.length;

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < n; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }

    for (int i = 0; i < n; i++) {
      if (map.containsKey(d + arr[i])) {
        System.out.print("Pair Found: (" + arr[i] + ", " +
            +(n + arr[i]) + ")");
        return;
      }
    }
    System.out.print("No Pair found");

  }

  public static void main(String[] args) {
    int arr[] = { 1, 8, 30, 40, 100 };
    int n = -60;
    findPairMap(arr, n);
  }
}
