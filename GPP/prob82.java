// size of smallest subarray with sum < x
//use variable sum,add, start
// Iterate over array and start adding elemets to sum
// if sum > x remove from the start
public class prob82 {
    static int minimumSumLenghX(int arr[],int x,int n){
       
        int minLength = n+1;
        int sum = 0;
        int start = 0,end = 0;
       while(end < n){
           while(sum <=x && end < n){
               sum+=arr[end++];
           }
           while(sum > x && start >n){
               if(end -start < minLength){
                   minLength = end-start;
                 
               }
               sum-=arr[start++];
             
           }
       }
       return minLength;

    }
    public static void main(String[] args) {
        int arr[] = {1,4,45,6,10,19};
        int x = 51;
        int n = arr.length;
        int minLength = minimumSumLenghX(arr, x, n);
        
        if(minLength == n+1){
            System.out.println("No such element in subarray");
        }else{
            System.out.println("Smallest length subarry :"+minLength);
        }
    }
}
