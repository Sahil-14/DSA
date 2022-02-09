public class prob7 {

    static int binaryToDecimal(int n){
        int ans = 0;
        int x = 1;
        while(n > 0){
            int y = n%10;
            ans += x*y;
            x*=2;
            n = n/10;
        }
        return ans;
    }

    static int octalToDecimal(int n){
        int ans = 0;
        int x = 1;
        while(n > 0){
            int y = n%10;
            ans += x*y;
            x*=8;
            n = n/10;
        }
        return ans;
    }
    static int hexadecimalToDecimal(String n){
        int ans = 0;
        int x = 1;
        int  s = n.length();
        for(int i = s-1;i>=0;i--){
            if(n.charAt(i) >= '0'  &&  n.charAt(i) <='9'){
                ans+=x*(n.charAt(i) - '0');
            }else if(n.charAt(i) >= 'A'  &&  n.charAt(i) <='F'){
                ans+=x*(n.charAt(i)-'A'+10);
            }
            x*=16;
        }
        return ans;
    }
    // find highest divisable degree

    static int decimalToBinary(int n){
        int x = 1;
        int ans = 0;
        while(x<=n){
            x *= 2;
        }
        x/=2;

        while(x>0){
            int lastdigit = n/x;
            n-= lastdigit*x;
            x/=2;
            ans = ans*10+lastdigit;
        }
        
        return ans;
    }
    public void decToBinaryBitwise(int n)
        {
            // Size of an integer is assumed to be 32 bits
            for (int i = 31; i >= 0; i--) {
                int k = n >> i;
                if ((k & 1) > 0)
                    System.out.print("1");
                else
                    System.out.print("0");
            }
        }
   
    static int reverse(int n){
        int ans = 0;
        while(n > 0){
            int lastdigit = n%10;
            ans = ans*10 + lastdigit;
            n /= 10;
        }
        return ans ;
    }

    static int binaryAddition(int a,int b){
        int ans = 0;
        int prevCarry = 0;
        while(a > 0 && b>0){
            if(a%2 == 0 && b%2 == 0){
                ans = ans*10+prevCarry;
                prevCarry = 0;
            }else if((a%2 == 0 && b%2 == 1) || (a%2 == 1 && b%2 == 0) ){
                if(prevCarry == 1){
                    ans = ans*10 + 0;
                    prevCarry = 1;
                }else{
                    ans = ans*10+1;
                    prevCarry = 0;
                }
            }else{
                ans = ans*10 + prevCarry;
                prevCarry = 1;
            }
            a /= 10;
            b /= 10;
        }

        while(a >0){
            if(prevCarry == 1){
                if(a%2 == 1){
                    ans = ans*10 + 0;
                    prevCarry = 1;
                }else{
                    ans = ans*10 + 1;
                    prevCarry = 0;
                }
            }else{
                ans = ans*10 + (a%2);
            }
            a /= 10;
        }

        while(b > 0){
            if(prevCarry == 1){
                if(b % 2 == 1){
                    ans = ans*10 + 0;
                    prevCarry = 1;
                }else{
                    ans = ans*10 +1;
                    prevCarry = 0;
                }
            }else{
                ans = ans*10 + (b%2);
            }
            b /= 10;
        }
        if(prevCarry == 1){
            ans = ans*10 +1;
        }

        return reverse(ans);

    }

    static int decimalToOctal(int n){
        int x = 1;
        int ans = 0;
        while(x <= n){
            x *= 8;
        }
        x /=8;

        while(x>0){
            int lastdigit = n/x;
            n-=lastdigit*x;
            x/=8;
            ans = ans*10+lastdigit;
        }
        return ans;
    }

    static String decimalToHexadecimal(int n){
        int x = 1;
        String ans = "";
        while(x <= n){
            x *= 16;
        }
        x /= 16;
        while(x > 0 ){
            int lastdigit = n/x;
            n -= lastdigit*x;
            x /= 16;
            if(lastdigit <= 9){
                ans = ans+ String.valueOf(lastdigit);
            }else{
                char c = (char)('A'+lastdigit-10);
                ans = ans + c;
            }
        }
        return ans;
    }
    public static void main(String arg[]){
        System.out.println(binaryAddition(10101,1101));
    }
}


  
