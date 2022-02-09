/**
 * T(n) = T(k) + T(n-k-1) + \theta(n)
 * Worst Case:
 *  The worst case occurs when the partition process always picks greatest or smallest 
 * element as pivot. If we consider above partition strategy where last element is
 *  always picked as pivot, the worst case would occur when the array is already sorted in
 *  increasing or decreasing order. Following is recurrence for worst case. * 
 * Best Case: 
 * The best case occurs when the partition process always picks the middle element 
 * as pivot. Following is recurrence for best case.
 *  T(n) = 2T(n/2) + \theta(n)
 * 
 * Average Case: 
 * To do average case analysis, we need to consider all possible permutation of array 
 * and calculate time taken by every permutation which doesn’t look easy.
 *  We can get an idea of average case by considering the case when partition puts 
 * O(n/9) elements in one set and O(9n/10) elements in other set.
 *  Following is recurrence for this case. 
 * T(n) = T(n/9) + T(9n/10) + \theta(n)
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class SortUsingQuicksort {
    static  void swap(int arr[],int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    static int partition(int arr[],int l,int r){
        int pivot = arr[r];
        int i = l-1,j;
        for( j = l;j<r;j++){
            if(arr[j] < pivot){
                i++;
                swap(arr, i,j);
            }
        }
        swap(arr,i+1,r);
        return i+1;
    }
    static void quickSort(int arr[],int l,int r){
        if(l < r){
            int p = partition(arr, l, r);
            quickSort(arr, l, p-1);
            quickSort(arr, p+1, r);
        }
    }
    public static void main(String arg[]){
        int A[] = { 11, 19, 0, -1, 5, 6, 16, -3, 6, 0, 14, 18, 7, 21, 18, -6, -8 };
        quickSort(A, 0, A.length-1);
       
        for(int i : A){
            System.out.print(i+" ");
        }
    }
}

/**
 * Is QuickSort stable? 
The default implementation is not stable.
 However any sorting algorithm can be made stable by considering indexes as
  comparison parameter. 

Is QuickSort In-place? 
As per the broad definition of in-place algorithm it
 qualifies as an in-place sorting algorithm as it uses extra space only for 
 storing recursive function calls but not for manipulating the input. 


 Why Quick Sort is preferred over MergeSort for sorting Arrays 
Quick Sort in its general form is an in-place sort (i.e. it doesn’t require any extra storage) whereas merge sort requires O(N) extra storage, N denoting the array size which may be quite expensive. Allocating and de-allocating the extra space used for merge sort increases the running time of the algorithm. Comparing average complexity we find that both type of sorts have O(NlogN) average complexity but the constants differ. For arrays, merge sort loses due to the use of extra O(N) storage space.
Most practical implementations of Quick Sort use randomized version. The randomized version has expected time complexity of O(nLogn). The worst case is possible in randomized version also, but worst case doesn’t occur for a particular pattern (like sorted array) and randomized Quick Sort works well in practice.
Quick Sort is also a cache friendly sorting algorithm as it has good locality of reference when used for arrays.
Quick Sort is also tail recursive, therefore tail call optimizations is done.

Why MergeSort is preferred over QuickSort for Linked Lists? 
In case of linked lists the case is different mainly due to difference in memory allocation of arrays and linked lists. Unlike arrays, linked list nodes may not be adjacent in memory. Unlike array, in linked list, we can insert items in the middle in O(1) extra space and O(1) time. Therefore merge operation of merge sort can be implemented without extra space for linked lists.
In arrays, we can do random access as elements are continuous in memory. Let us say we have an integer (4-byte) array A and let the address of A[0] be x then to access A[i], we can directly access the memory at (x + i*4). Unlike arrays, we can not do random access in linked list. Quick Sort requires a lot of this kind of access. In linked list to access i’th index, we have to travel each and every node from the head to i’th node as we don’t have continuous block of memory. Therefore, the overhead increases for quick sort. Merge sort accesses data sequentially and the need of random access is low. 
 */
