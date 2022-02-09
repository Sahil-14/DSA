public class exmp {

    void swap(int arr[],int a ,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    int partition(int arr[],int l,int r){
        int i = l-1;
        int j = l;
        int pivot =arr[r];
        while(j < r && arr[j] < pivot){
            i++;
            swap(arr, i, j);
        }
        swap(arr, i+1, j);
        return i+1;
    }
    void sort(int arr[],int l,int r){
        while(r > l){
            int position = partition(arr,l,r);
            partition(arr,l,position-1);
            partition(arr,position+1,r);
        }

    }
}
