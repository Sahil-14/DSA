import java.lang.Math;
public class prob1 {
    public static void main(String arg[]) {
        int n = 17;
        int flag = 0;
        for(int i = 2;i< Math.sqrt(n) ;i++){
            if(n%i == 0){
                System.out.println("Non-prime");
                flag = 1;
                break;
            }
        }

        if(flag == 0){
            System.out.println("prime");
        }
    }
}
