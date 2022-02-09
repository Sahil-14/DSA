import java.util.Arrays;

//find prime number within given range
// find prime numbers by removing all of the non prime numbers
public class Prob17 {
    static void SOE(int n){
        int prime[] = new int[100];
        Arrays.fill(prime, 0);

        for(int i = 2;i<=n;i++){
            if(prime[i] == 0){
                for(int j = i*i;j<=n;j+=i){
                    prime[j] = 1;
                }
            }
        }

        for(int i = 2;i<=n;i++){
            if(prime[i] == 0){
                System.out.println(i);
            }
        }
    }
    //prime factorisation
    static void primeFactor(int n){
        int spf[] = new int[100];
        Arrays.fill(spf, 0);

        for(int i= 0;i<=n;i++){
            spf[i] = i;
        }

        for(int i=2;i<=2;i++){
            if(spf[i] == i){
                for(int j = i*i;j<=n;j+=i){
                    if(spf[j] == j){
                        spf[j] = i;
                    }
                }
            }
        }

        while(n != 1){
            System.out.println(spf[n]);
            n = n/spf[n];
        }
    }
    public static void main(String arg[]){
        // SOE(50);
        primeFactor(48);
    }
}
