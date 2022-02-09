//bursting balloons to max value
/**
 *
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a
 * number on it represented
 * by array nums. You are asked to burst all the balloons. If the you burst
 * balloon i you will
 * get nums[left] * nums[i] * nums[right] coins. Here left and right are
 * adjacent indices of i. After the burst,
 * the left and right then becomes adjacent.
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Time complexity O(n^3)
 * Space complexity O(n^2)
 */
public class dp_prob29 {
    public int maxValBottomUp(int nums[]) {
        int T[][] = new int[nums.length][nums.length];

        for (int l = 1; l <= nums.length; l++) {
            for (int i = 0; i <= nums.length - l; i++) {
                int j = i + l - 1;
                // k represent the last selected bollon index
                for (int k = i; k <= j; k++) {
                    int leftval = 1;
                    int rightval = 1;
                    if (i != 0) {
                        leftval = nums[i - 1];
                    }
                    if (j != nums.length - 1) {
                        rightval = nums[j + 1];
                    }
                    int before = 0;
                    int after = 0;
                    if (i != k) {
                        before = T[i][k - 1];
                    }
                    if (j != k) {
                        after = T[k + 1][j];
                    }
                    T[i][j] = Math.max(T[i][j], before + leftval * nums[k] * rightval + after);
                }
            }
        }
        return T[0][nums.length - 1];

    }

    public static void main(String[] args) {
        dp_prob29 ob = new dp_prob29();
        int input[] = { 3, 1, 5, 8 };
        System.out.println(ob.maxValBottomUp(input));  
    }
}
