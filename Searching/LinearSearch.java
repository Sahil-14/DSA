public class LinearSearch{
    int search(int arr[],int key){
        int index = -1,i;
        for(i = 0;i< arr.length;i++){
            if(arr[i] == key){
                index = i;
                break;
            }
        }
        return index;
    }
    public static void main(String arg[]){
        LinearSearch ls = new LinearSearch();
        int A[] = {2,3,4,65,7,6,8,90};
        int result = ls.search(A,90);
        if(result != -1){
            System.out.println("Element found at index :"+result);
        }else{
            System.out.println("Element not found ");
        }
    }
}

