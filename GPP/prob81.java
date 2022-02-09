// for a given array and integers k and x find the maximum sum subarray of size k and having sum less than x
// sliding window
// calculate sum  of first k elements
// initialize ans with th sum
//iterate over the rest of the arr keep adding one elemets in sum and removing one from start compare new sum with ans in each iteration
public class prob81 {
    static int maxSumSubarryX(int arr[],int k,int x){
        int sum=0;int ans = 0;
        
        for(int i = 0;i<k;i++){
            sum +=arr[i];
        }
        if(sum < x){
            ans = sum;
        }
        for(int i = k;i<arr.length;i++){
       
            sum = sum -arr[i-k] + arr[i];
         
            if(sum < x && sum >ans){
                ans = sum;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {7,5,4,6,8,9};
        int k = 3;
        System.out.println(maxSumSubarryX(arr, k,20));
    }
}
