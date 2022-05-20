// for a given array and integer k find the maximum perfect numbers in a subarray of size k
/**
 *  Perfect Number
 * perfect number is a number if it is equal to the sum of its proper divisors exept for the number itself
 * approch 1 : generate all subarrays of size k  and count the number of perfect numbers O(n * k)
 * approch 2 : convert given array into binary array with values 0 and 1   and use sliding window approch (n *sqrt(n))
 * 
 * eg number = 6  , proper divisors =[1,2,3] and theire sum 6
 * 
 */
public class prob85 {
    static boolean isNumberPerfect(int n){
        int sum = 1;
        for(int i = 2;i<Math.sqrt(n);i++){
            if(n % i == 0){
                if(i == n/i){
                    sum += i;
                }else{
                    sum+= i + (n/i);
                }
            }
        }

        if(sum == n && n!= 1){
            return true;
        }
     
        return false;
    }
    static int maxSum(int arr[],int n,int k){
        if(n < k){
            return -1;
        }
        int res = 0;
        for(int i = 0;i<k;i++){
            res += arr[i] ;
        }
        int sum = res;
        for(int i = k;i<n;i++){
            sum += arr[i] - arr[i-k];
            res = Math.max(sum, res);
        }
        return res;
    }
    static int maxNumberOfPerfect(int arr[],int n,int k){
        for(int i = 0;i<n;i++){
            if(isNumberPerfect(arr[i])){
                arr[i] = 1;
            }else{
                arr[i] = 0;
            }
        }
        return maxSum(arr, n, k);
    }
    public static void main(String[] args) {
        int arr[] = {28,2,3,6,496,99,8128,24};
        int k = 4;
        int n = 8;
        System.out.println(maxNumberOfPerfect(arr, n, k));
    }
}
