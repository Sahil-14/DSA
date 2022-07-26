//maximum sum subsequence not adjecent
public class dp_prob30 {
    public int maxSum(int input[]) {
        int inclusive = input[0];
        int exclusive = 0;
        for (int i = 1; i < input.length; i++) {
            int temp = inclusive;
            inclusive = Math.max(inclusive, exclusive + input[i]);
            exclusive = temp;
        }
        return inclusive;
    }

    

    public static void main(String[] args) {
        dp_prob30 ob = new dp_prob30();
        // int arr[] = { 2, 10, 13, 4, 2, 15, 10 };
        int arr[] = { 5, 5, 10, 100,
                10, 5 };
        System.out.println(ob.maxSum(arr));

    }
}
