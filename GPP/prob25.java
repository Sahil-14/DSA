public class prob25 {

    long long merge(int arr[],int l,int mid ,int r){
        long long inv = 0;
        int n1 = mid -l+1;
        int n2 = r -mid;
        int a[] = new int[n1];
        int b[]  = new int[n2];
        for(int i = 0;i<n1;i++){
            a[i] = arr[l+i];
        }
        for(int i = 0;i<n2;i++){
            b[i] = arr[mid+1+i];
        }
        int i=0,j=0,k=l;
        while(i < n1 && j <n2){
            if(a[i] <= b[j]){
                arr[k++] = a[i++];
            }else{
                arr[k] = b[j];
                inv += n1-i; // important
                k++;j++;
            }
        }

        while(i < n1){
            arr[k++] = arr[i++];
        }
        while(j < n2){
            arr[k++] = b[j++];
        }

    }

    long long  mergeSort(int arr[],int l,int r){
        long long inv = 0;
        if(l < r){
            int mid = (l+r)/2;
            inv += mergeSort(arr, l, mid);
            inv += mergeSort(arr, mid+1, r);
            inv += merge(arr,l,mid,r);
        }
        return inv;
    }
    public static void main(String arg[]){
        int arr[] = {3,5,6,9,1,2,7,8};

    }
}
