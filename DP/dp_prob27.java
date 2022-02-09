//fibonnaci series 
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

    public static void main(String[] args) {
        dp_prob27 fb = new dp_prob27();
        System.out.print(fb.fibonnaciSeries(0));
    }

}

// note here function return privious value
// eg for n == 3 it return ans for n == 2
// for n == 7 it will return ans of n ==6
