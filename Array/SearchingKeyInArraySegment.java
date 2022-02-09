// Check if a key is present in every segment of size k in an array
/**
 * Input : arr[] = { 3, 5, 2, 4, 9, 3, 1, 7, 3, 11, 12, 3} x = 3 k = 3 Output :
 * Yes There are 4 non-overlapping segments of size k in the array, {3, 5, 2},
 * {4, 9, 3}, {1, 7, 3} and {11, 12, 3}. 3 is present all segments.
 */
public class SearchingKeyInArraySegment {
    static boolean findxinkindowSize(int N, int[] arr, int x, int k) {
        int i;
        boolean b = false;

        // Iterate from 0 to N - 1
        for (i = 0; i < N; i = i + k) {

            // Iterate from 0 to k - 1
            for (int j = 0; j < k; j++) {
                if (i + j < N && arr[i + j] == x)
                    break;

                if (j == k)
                    return false;
                if (i + j >= N)
                    return false;
            }
        }
        if (i >= N)
            return true;
        else
            return b;
    }

    public static void main(String args[])
    {
        int arr[] = new int[] { 3, 5, 2, 4,  9,  3,
                                1, 7, 3, 11, 12, 3 };
        int x = 7, k = 3;
        int n = arr.length;
        if (findxinkindowSize(n, arr, x, k))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
