import java.util.Stack;

//trappping rainwater

public class array_prob12 {
  public static int trapingRainwater(int arr[]) {
    Stack<Integer> s = new Stack<>();
    int ans = 0;
    for (int i = 0; i < arr.length; i++) {
      while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
        int current = s.pop();
        if (s.isEmpty()) {
          break;
        }
        int diff = i - s.peek() - 1;
        ans += (Math.min(arr[i], arr[s.peek()]) - arr[current]) * diff;
      }
      s.push(i);
    }
    return ans;
  }

  public static void main(String[] args) {
    int arr[] = { 4, 2, 0, 3, 2, 5 };
    System.out.println(trapingRainwater(arr));
  }
}
