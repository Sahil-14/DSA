
// RECURSION
//when function call itself to make problem smaller.
public class prob19 {
    static int sum(int n){
        if(n == 0){
            return 0;
        }

        int prevsum = sum(n-1);
        return n+ prevsum;
    }

    // n raised to power p
    static int power(int n,int p){
        if(p == 0){
            return 1;
        }
        int prevPower = power(n, p-1);
        return n * prevPower;
    }
    static int factorial(int n){
        if(n == 0){
            return 1;
        }
        return factorial(n-1)*n;
    }
    //print nth fibonacci;
    static int fibonacci(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    public static void main(String arg[]){
        // System.out.println(sum(5));
        // System.out.println(power(4,12));
         System.out.println(fibonacci(4));
    }
}
