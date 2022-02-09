public class Armstrong {
    static void armstrong(int n){
        int sum = 0;
        int originalNo = n;
        while(n > 0){
            int current = n % 10;
            sum += Math.pow(current, 3);
            n = n/10;
        }
        // System.out.println(sum+" "+n);
        if(sum == originalNo){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
    public static void main(String arg[]){
        armstrong(153);
        armstrong(1453);armstrong(343);
    }
}
