public abstract class temp {
    public static int partition(int l,int r,int arr[]){
        int j ,i = l -1;
        int pivot = arr[r];
        for(j =l;j<r;i++ ){
            if(arr[j] < pivot){
                i++;
                swap(i,j);
            }
        }
        swap(i+1,j);
        return i+1;
    }
}
