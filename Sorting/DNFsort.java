public class DNFsort {
    static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void DNF(int a[], int n) {
        int low = 0;
        int mid = 0;
        int high = n - 1;
        while (mid <= high) {
            if (a[mid] == 0) {
                swap(a, low, mid);
                low++;
                mid++;
            } else if (a[mid] == 1) {
                mid++;
            } else {
                swap(a, mid, high);
                high--;
            }
        }
    }

    public static void main(String arg[]) {
        int arr[] = {1,0,2,1,0,1,2,1,2};
        DNF(a rr, arr.length);
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
