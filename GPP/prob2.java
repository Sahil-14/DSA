public class prob2 {
    static int reverse(int n){
        int reverseNumber = 0;
        int remainder = 0;
       
        while(n > 0){
            remainder = n%10;
            reverseNumber = reverseNumber*10+remainder;
            n = n/10;
        }
        return reverseNumber;
    }

    public static void main(String arg[]){
        System.out.println(reverse(13534));
    }
}
