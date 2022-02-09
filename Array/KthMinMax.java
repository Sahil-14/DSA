import java.util.Arrays;

public class KthMinMax {
    // Method :1 c(nlogn)
    public static int Smallest(Integer[] arr,int k){
        Arrays.sort(arr);
        return arr[k-1];
    } 
    // Method : 2 Min-heap

 
}
