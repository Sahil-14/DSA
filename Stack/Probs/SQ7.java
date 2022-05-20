
/**
 * 
 * Stack Permutations (Check if an array is stack permutation of other)
 * 
 * Below is the step by step algorithm to do this:
 * 
 * 
 * Only dequeue from the input queue.
 * Use inbuilt push, pop functions in the single stack.
 * Stack and input queue must be empty at the end.
 * Only enqueue to the output queue.
 * 
 * 
 * Continuously pop elements from the input queue and check if it is equal to
 * the top of output queue or not, if it is not equal to the top of output queue
 * then we will push the element to stack.
 * 
 * Once we find an element in input queue such the top of input queue is equal
 * to top of output queue, we will pop a single element from both input and
 * output queues, and compare the top of stack and top of output queue now. If
 * top of both stack and output queue are equal then pop element from both stack
 * and output queue. If not equal, go to step 1.
 * 
 * Repeat above two steps until the input queue becomes empty. At the end if
 * both of the input queue and stack are empty then the input queue is
 * permutable otherwise not.
 * 
 */

import java.util.*;

public class SQ7 {

  static boolean checkStackPermutation(int ip[], int op[], int n) {
    Queue<Integer> input = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      input.add(ip[i]);
    }
    Queue<Integer> output = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      output.add(op[i]);
    }

    Stack<Integer> tempStack = new Stack<>();
    while (!input.isEmpty()) {
      int ele = input.poll();
      if (ele == output.peek()) {
        output.poll();
        while (!tempStack.isEmpty()) {
          if (tempStack.peek() == output.peek()) {
            tempStack.pop();
            output.poll();
          } else {
            break;
          }
        }
      } else {
        tempStack.push(ele);
      }
    }
    return (input.isEmpty() && tempStack.isEmpty());

  }

  public static void main(String[] args) {
    // Input Queue
    int input[] = { 1, 2, 3 };

    // Output Queue
    int output[] = { 2, 1, 3 };
    int n = 3;
    if (checkStackPermutation(input, output, n))
      System.out.println("Yes");
    else
      System.out.println("Not Possible");
  }
}
