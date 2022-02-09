class MinHeapNode{
    int element;
    int i;
    int j;
    public MinHeapNode(int element,int i,int j){
        this.element = element;
        this.i = i;
        this.j = j;

    }
};
public class prob87 {
    MinHeapNode[] hrr;
    int heap_size;
    public prob87(MinHeapNode a[],int size){
        heap_size = size;
        hrr = a;
        int i = (heap_size -1)/2;
        while(i >= 0){
            Minheapify(i);
            i--;
        }
        
    }
    void swap(MinHeapNode[] arr, int i, int j) {
        MinHeapNode temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 
    // A utility function to print array elements
    static void printArray(int[] arr) {
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
    void Minheapify(int i){
        int l = 2*i+1;
        int r = 2*i+2;
        int smallest = i;
        if(l <heap_size && hrr[l].element < hrr[i].element){
            smallest =l;
        }
        if(r <heap_size && hrr[r].element < hrr[i].element){
            smallest =r;
        }
        if(smallest != i){
            swap(hrr, smallest, i);
            Minheapify(smallest);
        }
    }
    MinHeapNode getMin()
    {
        if(heap_size <= 0)
        {
            System.out.println("Heap underflow");
            return null;
        }
        return hrr[0];
    }
    // to replace root with new node
    // "root" and heapify() new root
    void replaceMin(MinHeapNode root) {
        hrr[0] = root;
        Minheapify(0);
    }
    static void mergeKsortedArrays(int[][] arr,int k){
        MinHeapNode[] hArr = new MinHeapNode[k];
        int resultSize = 0;
        for(int i = 0;i<arr.length;i++){
            MinHeapNode node = new MinHeapNode(arr[i][0], i, 1);
            hArr[i] = node;
            resultSize+= arr[i].length;
        }
        
    }
    public static void main(String[] args) {
        
    }
}
