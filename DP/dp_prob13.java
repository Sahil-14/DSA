//number of jump needed to reach the end
/**
 * 
 * *
 * * Given an array of non negative integers where each element represents the
 * max
 * number of steps that can be made forward from that element. Write a function
 * to
 * return the minimum number of jumps to reach the end of the array from first
 * element
 * 
 * Solution
 * Have 2 for loop. j trails i. If arr[j] + j >= i then you calculate new jump
 * and result.
 * 
 * Space complexity O(n) to maintain result and min jumps
 * Tim
 */

public class dp_prob13 {
    public int minJump(int arr[], int result[]) {
        int n = arr.length;
        int jump[] = new int[arr.length];
        jump[0] = 0;
        if (n == 0 || arr[0] <= 0) {
            return Integer.MAX_VALUE;
        }
        

        for (int i = 1; i < arr.length; i++) {
            jump[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + arr[j] >= i && jump[j] != Integer.MAX_VALUE){
                    jump[i] = Math.min(jump[i],jump[j] + 1);
                    result[i] = j;
                    break;
                }
            }
        } 
        // print path
        System.out.print(result[0]);
        for (int i = 0; i < arr.length - 1; i++) {
            if (result[i + 1] != result[i]) {
                System.out.print(" - " + result[i + 1]);
            }
        }
        System.out.print(" - " + (arr.length - 1));
        System.out.println();
        return jump[jump.length - 1];
    }

  
    static int minJumps(int arr[]) {
        if (arr.length <= 1)
            return 0;

        // Return -1 if not possible to jump
        if (arr[0] == 0)
            return -1;
        // initialization
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        // Start traversing array
        for (int i = 1; i < arr.length; i++) {
            // Check if we have reached the end of the array
            if (i == arr.length - 1)
                return jump;

            // updating maxReach
            maxReach = Math.max(maxReach, i + arr[i]);

            // we use a step to get to the current index
            step--;

            // If no further steps left
            if (step == 0) {
                // we must have used a jump
                jump++;

                // Check if the current index/position or lesser index
                // is the maximum reach point from the previous indexes
                if (i >= maxReach)
                    return -1;

                // re-initialize the steps to the amount
                // of steps to reach maxReach from position i.
                step = maxReach - i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        dp_prob13 mj = new dp_prob13();
        int arr[] = { 1, 3, 5, 3, 2, 2, 6, 1, 6, 8, 9 };
        int arr2[] = { 2, 3, 1, 1, 2, 4, 2, 0, 1, 1 };
        int r[] = new int[arr.length];
        int result = mj.minJump(arr2, r);
        System.out.println(result);
    }

}
