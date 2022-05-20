import java.util.Arrays;

// binary search ch.1
// given is an  array with n elements that represents n positionas along a
// straight line .
// find k elements such that the mininum distance between
// any 2 elements is the maximum possible


public class prob76 {
    static boolean isFeasible(int mid,int arr[],int n,int k){
        int pos = arr[0],elements = 1;
        for(int i = 1;i<n;i++){
            if(arr[i] - pos >= mid){
                pos =arr[i];
                elements++;
                if(elements == k){
                    return true;
                }
            }
        }
        return false;
    }

    static int largestMinDistance(int arr[],int n,int k){
        Arrays.sort(arr);
        int result = -1;
        int left = 1,right = arr[n-1];
        while(left < right){
            int mid = (left+right)/2;
            if(isFeasible(mid, arr, n, k)){
                result = Math.max(result, mid);
                left = mid+1;
            }{
                right = mid;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,8,4,9};
        int n = 5;int  k = 3;
        System.out.println("Largest minimum distance is :"+largestMinDistance(arr, n, k));

    }

}
