public class prob18 {
    // how many numbers between a 1 and 1000 are divisble by 5 or 7
    static int divisible(int n,int a,int b){
        int c1 = n/a;
        int c2 = n/b;
        int c3 = n/(a*b);
        return c1+c2-c3;
    }

    static int gcdByMod(int a,int b){
        int c = a%b;
        while(c != 0){
            a = b;
            b = c;
            c = a%b;
        }
        return b;
    }

    public static void main(String arg[]){
        System.out.println(divisible(1000, 5, 7));
        System.out.println(gcdByMod(42, 24));
    }
}
