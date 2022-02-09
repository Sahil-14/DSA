public class Reverse {
    static int reverse(int n){
        int rev = 0;
        while(n >0){
            int lastdigit = n%10;
            rev = rev*10 +lastdigit;
           
            n = n/10;
        }
        return rev;
    }
    public static void main(String arg[]){
        int res = reverse(1234);
        System.out.println(res);
    }
}
