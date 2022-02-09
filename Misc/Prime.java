public class Prime {
    static void Isprime(int n) {
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.println(n + "  is not prime");
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println(n + " is Prime Number");
        }
    }

    public static void main(String arg[]) {
        Isprime(45);
        Isprime(2);
        Isprime(30);
        Isprime(17);
        Isprime(81);
    }
}
