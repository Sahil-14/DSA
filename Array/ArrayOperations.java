public class ArrayOperations{
    public static int insertAtEnd(int arr[],int key,int capasity,int n){
        if(n >= capasity){
            return n;
        }
        arr[n] = key;
        return (n+1);
    }
    public static int delete(int arr[],int key,int n){
        int pos =search(arr, 0, n-1, key);
        if(pos == -1){
            return -1;
        }
        for(int i = pos;i<n-1;i++){
            arr[i] = arr[i+1];
        }
        return n-1;
    }
    public static int search(int arr[],int l ,int r,int key){
        if(r>=l ){
            int mid = l + (r-l)/2;

            if(key == arr[mid] ){
                return mid;
            }
            if(key > arr[mid]){
            return search(arr,mid+1,r,key);
            }
            return search(arr,l,mid,key);
        }
        return -1;
    }
   
     static void printArray(int arr[],int n){
        for(int i = 0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String arg[]){
        int[] arr = new int[8];
        arr[0] = 12;
        arr[1] = 16;
        arr[2] = 20;
        arr[3] = 40;
        arr[4] = 50;
        arr[5] = 70;
        printArray(arr, 6);
        int capasity = 20;
        int n = 6;
        int i,key = 26;
        // n = insertAtEnd(arr, key, capasity, n);
        System.out.println(" ");
        n = delete(arr, 70, n);
        for(i = 0;i<n;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println(12/5);
    }
}