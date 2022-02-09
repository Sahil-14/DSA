/**
 * It is a process to rearrange the elements of the heap in order to maintain
 * the heap property. It is done when a certain node causes an imbalance in the
 * heap due to some operation on that node.
 * t(n) = o(n)
 * // 
 * Convert maxheap to minHeap or vise-versa
 * top -> bottom approch
 * parent = (i - 1)/2
 * left   = 2*i +1
 * right =  2*i
 */
public class Heapity {
    static void maxHeapify(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            maxHeapify(arr, n, largest);
        }
    }

    static void minHeapify(int arr[], int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }
        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;
            minHeapify(arr, n, smallest);
        }
    }

    static void buildHeap(int arr[], int n) {
        int startInx =( n / 2 )-1;
        for (int i = startInx; i >= 0; i--) {
            maxHeapify(arr, n, i);
            // minHeapify(arr, n, i);
        }
    }

    public static void printArray(int arr[], int n) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String arg[]) {
        int arr[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };

        int n = arr.length;

        buildHeap(arr, n);

        printArray(arr, n);
    }
}
