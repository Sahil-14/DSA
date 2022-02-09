public class prob3 {

    
    static int  decimalToBinary(int n){
        int bn[] = new int[100];
        int i = 0;
        while(n > 0){
           bn[i++] = n%2;
           n = n/2;
        }
        int binaryNumber = 0;
       for(int j = i-1;j>=0;j--){
           binaryNumber = binaryNumber*10 + bn[j];
       }
       return binaryNumber;
    }



    public static void main(String arg[]){
       System.out.println( decimalToBinary(456));
    }

}
