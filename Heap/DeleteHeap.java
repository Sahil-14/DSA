public class DeleteHeap {
    public static void swap(int Heap[],int a, int b) {
        int temp = Heap[a];
        Heap[a] = Heap[b];
        Heap[b] = temp;
    }
    public static void heapify(int arr[],int n,int i){
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left <n && arr[left] > arr[largest]){
            largest = left;
        }
        if(right < n && arr[right] > arr[largest]){
            largest = right;
        }

        if(largest != i){
         swap(arr, largest, i);
         heapify(arr, n, largest);
        }
    }
    static void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
  
        System.out.println();
    }
    static int deletRoot(int arr[],int n){
        int lastElement = arr[n-1];
        arr[0] = lastElement;
        n = n-1;
        heapify(arr,n,0);
        return n;
    }
    public static void main(String args[])
    {
        // Array representation of Max-Heap
        // 10
        //    /  \
        // 5    3
        //  / \
        // 2   4
        int arr[] = { 10, 5, 3, 2, 4 };
  
        int n = arr.length;
  
        n = deletRoot(arr, n);
  
        printArray(arr, n);
    }
}
