/**
 * Find duplicates in O(n) time and O(1) extra space
 * Given an array of n elements that contains elements from 0 to n-1,
 *  with any of these numbers appearing any number of times. 
 * Find these repeating numbers in O(n) and using only constant memory space.
 * 
 * 
 * 
 * 
 * 
 */
public  class Duplicates {
    void printRepeating(int arr[], int size)
    {
        int i;
        System.out.println("The repeating elements are : ");
          
        for (i = 0; i < size; i++) {
            int j = Math.abs(arr[i]);
            if (arr[j] >= 0)
                arr[j] = -arr[j];
            else
                System.out.print(j + " ");
        }
    }
    public static void main(String[] args)
    {
        Duplicates duplicate = new Duplicates();
        int arr[] = { 1, 2, 3, 1, 3, 6, 6 };
        int arr_size = arr.length;
  
        duplicate.printRepeating(arr, arr_size);
    }
}

