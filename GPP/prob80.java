// find the peak element

public class prob80 {
    static int peak(int arr[],int low,int high,int n){
     int mid = low+(high - low)/2;
     if( (mid == 0 || arr[mid-1] <= arr[mid]) &&(mid == n-1) || arr[mid +1] <= arr[mid]){
         return mid;
     }
     else if(mid > 0 && arr[mid-1] > arr[mid]){
         return peak(arr,0,mid-1,n);
     } 
     else{
         return peak(arr,mid+1,high,n);
     }
    }
    public static void main(String[] args) {
        int arr[] = {0,6,8,5,7,9};
        int n = 6;
        System.out.println(peak(arr,0,n-1,n));
    }
}
