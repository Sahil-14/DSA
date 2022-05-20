public class InsertHeap {
    private int[] Heap;
    private int size;
    private int maxsize;

    public InsertHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = 18;
    }

    private void swap(int a, int b) {
        int temp = Heap[a];
        Heap[a] = Heap[b];
        Heap[b] = temp;
    }

    public void insert(int element) {
        Heap[++size] = element;

        int current = size;
        int parent = (current - 1) / 2;
        while (Heap[current] > Heap[parent]) {
            swap(current, parent);
            current = parent;
            parent = (current - 1) / 2;
        }
    }
    public static void printArray(int arr[], int n) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String arg[]) {
        InsertHeap ih = new InsertHeap(15);
        ih.insert(5);
        ih.insert(3);
        ih.insert(17);
        ih.insert(10);
        ih.insert(84);
        ih.insert(19);
        ih.insert(6);
        ih.insert(22);
        ih.insert(9);
        printArray(ih.Heap, ih.size);
    }
    
}
