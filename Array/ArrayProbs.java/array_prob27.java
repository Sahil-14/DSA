
import java.util.HashMap;
import java.util.Stack;

public class array_prob27 {
  public static void nextSmaller(int arr[], int n) {
    int i = 0;
    Stack<Integer> s = new Stack<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    s.push(arr[0]);
    int next;
    int element;

    for (i = 1; i < n; i++) {
      next = arr[i];
      if (!s.isEmpty()) {
        element = s.pop();

        while (element > next) {
          // System.out.println(element + "-->" + next);
          map.put(element, next);
          if (s.isEmpty()) {
            break;
          }
          element = s.pop();
        }

        if (element < next) {
          s.push(element);
        }
      }
      s.push(next);
    }
    while (!s.isEmpty()) {
      element = s.pop();
      next = -1;
      // System.out.println(element + "-->" + next);
      map.put(element, next);
    }

    for (i = 0; i < n; i++) {
      System.out.println(arr[i] + " --> " + map.get(arr[i]));
    }
  }

  public static void main(String[] args) {
    int arr[] = { 11, 13, 21, 3 };
    int n = arr.length;
    nextSmaller(arr, n);
  }
}
