// Maximum sum incresing subsequence
// same as longest incresing subsequence just store sum of numbers in max array
public class dp_prob33 {
    public int maximumSumIncresingSub(int input[]) {
        int maxSum[] = new int[input.length];
        int result[] = new int[input.length];
        int maxIndex = 0;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            maxSum[i] = input[i];
            result[i] = i;
        }

        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                if (input[i] > input[j]) {
                    if (maxSum[i] < maxSum[j] + input[i]) {
                        maxSum[i] = maxSum[j] + input[i];
                        result[i] = j;
                    }
                }
            }
        }
        for (int i = 0; i < maxSum.length; i++) {
            if (maxSum[i] > maxVal) {
                maxVal = maxSum[i];
                maxIndex = i;
            }

        }
        int t = maxIndex;
        int newT = maxIndex;
        // do {
        // newT = t;
        // System.out.print(input[t] + " ");
        // t = result[t];
        // } while (t != newT);
        printrec(t, input, result);
        System.out.println();
        return maxVal;
    }

    private void printrec(int t, int[] input, int[] result) {
        if (t == result[t]) {
            System.out.print(input[t] + " ");
            return;
        }

        printrec(result[t], input, result);
        System.out.print(input[t] + " ");
    }

    public static void main(String[] args) {
        dp_prob33 ob = new dp_prob33();
        int input[] = { 4, 6, 1, 3, 8, 4, 6 };
        int result = ob.maximumSumIncresingSub(input);
        System.out.println(result);
    }
}
