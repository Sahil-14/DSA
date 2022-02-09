import java.util.*;  
import java.lang.Math;
public class prob6 {
    static int sum(int n){
        int ans = 0;
        for(int i = 1;i<=n;i++){
            ans+=i;
        }
        return ans;
    }

    static boolean pythagoranTriplet(int x,int y,int z){
        int a = Math.max(x, Math.max(y, z));
        int b,c;
        if(a == x){
            b = y;
            c = z;
        }else if(a == y){
            b = x;
            c = z;
        }else{
            b = x;
             c = y;
        }

        if(a*a == (b*b + c*c)){
            return true;
        }

        return false;
    }

    public static void main(String arg[]){
        Scanner sc= new Scanner(System.in);
        int x,y,z;
        // int res = sc.nextInt();
        // System.out.println(sum(res));
        if(pythagoranTriplet(3, 4, 5)){
            System.out.println("PT");
        }else{
            System.out.println("NPT");
        }
    }
}
