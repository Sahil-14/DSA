import java.util.Stack;

public class MaxAreaHistogram {
  public int maxArea(int input[]) {
    Stack<Integer> s = new Stack<>();
    int area = 0;
    int maxArea = 0;
    int i;
    for (i = 0; i < input.length;) {
      if (s.isEmpty() || input[s.peek()] <= input[i]) {
        s.push(i++);
      } else {
        int top = s.pop();
        if (s.isEmpty()) {
          area = input[top] * i;
        } else {
          area = input[top] * (i - s.peek() - 1);
        }
        if (area > maxArea) {
          maxArea = area;
        }
      }

    }
    while (!s.isEmpty()) {
      int top = s.pop();
      if (s.isEmpty()) {
        area = input[top] * i;
      } else {
        area = input[top] * (i - s.peek() - 1);
      }
      if (area > maxArea) {
        maxArea = area;
      }
    }

    return maxArea;
  }

  public static void main(String[] args) {
    
  }
}
