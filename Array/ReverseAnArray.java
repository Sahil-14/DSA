

public class ReverseAnArray {
    public void reverse(int arr[],int n){
        for(int i = 0; i< n/2;i++){
            int temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
    }
    public void reverseRec(int arr[],int start,int end){
        int temp;
        if(start >= end){
            return;
        }
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseRec(arr, start+1, end-1);
    }
    public void printArray(int a[]){
        for(int i: a){
            System.out.print(i+" ");
        }
    }
    public static void main(String arg[]){
        ReverseAnArray ra = new ReverseAnArray();
        int A[] = {1,2,3,4,5};
        int n = A.length;
        ra.reverse(A, n);
        ra.reverseRec(A, 0,n-1);
        ra.printArray(A);
    }
}
