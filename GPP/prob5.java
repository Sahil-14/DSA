import java.lang.Math;
public class prob5 {
    static boolean isPrime(int num){
        for(int i = 2;i<=Math.sqrt(num);i++){
            if((num%i) == 0){
                return false;
            }
        }
        return true;
    }

    static void  fib(int n){
        int t1 = 0;
        int t2 = 1;
        int nextTerm;
        for(int i = 1;i<=n;i++){
            System.out.println(t1);
            nextTerm = t1+t2;
            t1 = t2 ;
            t2 = nextTerm;
        }
    }

    static int fact(int n){
        if(n == 0){
            return 1;
        }
        return fact(n-1)*n;
    }

    static int nCr(int n,int r){
        return fact(n)/(fact(r)*fact(n-r));
    }

    static void pascalTriangle(int n){
        for(int i = 0;i<n;i++){
            for(int j = 0;j<=i;j++){
                System.out.print(nCr(i, j)+" ");
            }
            System.out.println();
        }
    }
    public static void main(String arg[]){
        // for(int i = 10;i<=20;i++){
        //     if(isPrime(i)){
        //         System.out.println(i);
        //     }
        // }
        // fib(5);
    //    System.out.println( fact(5));
    //    System.out.println(nCr(5, 2));
       pascalTriangle(5);
    }
}
