public class prob15 {
    // check where the number is power of 2 or not
    // hint and operation between n & n-1  return 0
    static boolean isPowerOf2(int n){
       return n!= 0 && ((n & (n-1)) == 0);
    }

    // calculate number of 1ns in binary number
    static int numberOfOnes(int n){
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
    static void subset(int arr[],int n){
        for(int i = 0;i<(1<<n);i++){
            for(int j = 0;j<n;j++){
                // check whether jth bit is set
                if((i & (1 << j)) != 0){
                    System.out.print(arr[j]+ " ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String arg[]){
        // System.out.println(isPowerOf2(128));
        // System.out.println(numberOfOnes(23));
        int arr[] = {1,2,3,4};
        subset(arr, 4);
    }
}
