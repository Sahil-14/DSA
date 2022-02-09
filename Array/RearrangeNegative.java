public class RearrangeNegative {
    public static void rearrangeByPartition(int arr[]) {
        int pivot = 0;
        int i = -1;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }

    public static void rearrangeByTwoPointer(int arr[]) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            // Condition to check if the left and the right elements are  negative
            if(arr[left] <0 && arr[right] <0)
                left++;
            else if(arr[left] >0 && arr[right] <0){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }else if(arr[left] >0 && arr[right] >0){
                    right--;
            }else{
                left++;
                right--;
            }
        }
    }

    static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String arg[]) {
        int arr[] = { -1, 2, -3, 4, 5, 6, -7, 0, 9 };

        // rearrange(arr);
        rearrangeByTwoPointer(arr);
        printArray(arr);
    }
}
