import java.util.Stack;

//max size rectangle of all 1ns
public class mat_prob5 {
  public static int maxAreaHistogram(int input[]) {
    Stack<Integer> stack = new Stack<>();
    int maxArea = 0;
    int area = 0;
    int i = 0;
    for (i = 0; i < input.length;) {
      if (stack.isEmpty() || input[i] >= input[stack.peek()]) {
        stack.push(i++);
      } else {
        int top = stack.pop();
        if (stack.isEmpty()) {
          area = i * input[top];
        } else {
          area = input[top] * (i - stack.peek() - 1);
        }
        if (area > maxArea) {
          maxArea = area;
        }
      }
    }
    while (!stack.isEmpty()) {
      int top = stack.pop();

      if (stack.isEmpty()) {
        area = i * input[top];
      } else {
        area = input[top] * (i - 1 - stack.peek());
      }
      if (area > maxArea) {
        maxArea = area;
      }
    }
    return maxArea;
  }

  public static int maxAreaReactangle(int input[][]) {
    int temp[] = new int[input[0].length];
    int maxArea = 0;
    int area = 0;
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < temp.length; j++) {
        if (input[i][j] == 0) {
          temp[j] = 0;
        } else {
          temp[j] += input[i][j];
        }

      }
      area = maxAreaHistogram(temp);
      if (area > maxArea) {
        maxArea = area;
      }
    }
    return maxArea;
  }

  public static void main(String[] args) {
    int M[][] = { { 0, 1, 1, 0 },
        { 1, 1, 1, 1 },
        { 1, 1, 1, 1 },
        { 1, 1, 0, 0 } };

    System.out.println(maxAreaReactangle(M));

  }
}
