import java.util.HashMap;

/**
 * Given an array of integers, and a number ‘sum’, find the number of pairs of integers in the array whose sum is equal to ‘sum’.
 * 
 * Method :1
 * Nested for loop :
 * Time Complexity: O(n2) 
 *  Auxiliary Space: O(1)
 *  Method :2
 * Using hashmap
 * Time Complexity: O(n) 
 * 
 *  

 */
public class PairWithSum {
    public static int  getPairCount(int arr[],int n,int sum){
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(arr[i] + arr[j] == sum)
                    count++;
            }
        }
        return count;
    }
    public static int getpairCountUsingHashMap(int arr[],int n,int sum){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<n;i++){
            if(!hm.containsKey(arr[i])){
                hm.put(arr[i], 0);
            }
            hm.put(arr[i],hm.get(arr[i])+1);
            
        }
        int twice_count = 0;
        for(int i = 0;i<n;i++){
            if(hm.get(sum-arr[i]) != null){
                twice_count+= hm.get(sum-arr[i]);
            }
            if(sum - arr[i] == arr[i]){
                twice_count--;
            }
        }
        return twice_count/2;

    }
    public static void main(String arg[]){
        int[] arr = { 1, 5, 7, -1, 5 };
        int sum = 6;
        int n = arr.length;
        // int result = getPairCount(arr, n, sum);
        int result = getpairCountUsingHashMap(arr, n, sum);
        System.out.println("count :"+result); 
      
    }
}
