/**
 * Max consecutive ones
 * given ans array A of 0 and 1 mwe may change up to k values from 0 to1
 * return the length of the longest continues subarray that contains only 1s
 * mean (k = 2) we can change 2 zero to 1
 * Input = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * output 6;
 * [1,1,1,0,0,1,1,1,1,1,1]
 */
public class prob51 {

    static int maxConsZero(int a[], int n, int k) {
        int zerocount = 0, i = 0, ans = 0;
        for (int j = 0; j < n; j++) {
            if (a[j] == 0) {
                zerocount++;
            }
            while (zerocount > k) {
                if (a[i] == 0) {
                    zerocount--;
                }
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    static int maxcon1(int arr[], int n, int k) {
        int zeroCount = 0, i = 0, ans = 0;
        for (int j = 0; j < n; j++) {
            if(arr[j] == 0){
                zeroCount++;
            }

            while(zeroCount < k){
                if(arr[i] == 0){
                    zeroCount--;
                }
                i++;
            }
            ans = Math.max(ans,j -i+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int a[] = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        System.out.println(maxConsZero(a, a.length, 2));

    }
}
