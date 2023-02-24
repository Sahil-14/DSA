//fibonnaci series 
// note in fibonnaci we have to return sum 
//staircase problem
public class dp_prob27 {
    public int fibonnaciSeries(int n) {
        n = n + 1;
        int n1 = 0, n2 = 1;
        int sum;
        if (n == n1 || n == n2) {
            return n;
        }

        for (int i = 2; i <= n; i++) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
        return n2;

    }

    static int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    // Returns number of ways to reach s'th stair
    static int countWays(int s) {
        return fib(s + 1);
    }

    // A recursive function used by countWays
    static int countWaysUtil(int n, int m) {
        int res[] = new int[n];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < n; i++) {
            res[i] = 0;
            for (int j = 1; j <= m && j <= i; j++)
                res[i] += res[i - j];
        }
        return res[n - 1];
    }

    // Returns number of ways to reach s'th stair
    static int countWays(int s, int m) {
        return countWaysUtil(s + 1, m);
    }

    public static void main(String[] args) {
        dp_prob27 fb = new dp_prob27();
        System.out.print(countWays(5) + "\n");
        System.out.print(fb.fibonnaciSeries(5));
        int arr[] = { 1, 2, 3 };
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }

}

// note here function return privious value
// eg for n == 3 it return ans for n == 2
// for n == 7 it will return ans of n ==6
