import java.util.HashMap;

public class NonRepeatingElements {
    static int fistNonRepeating(int arr[],int n){
        for(int i = 0;i<n;i++){
            int j ;
            for(j = 0;j<n;j++){
                if(i != j && arr[i] == arr[j]){
                    break;
                }
            }
            if(j == n){
                return arr[i];
            }

        }
        return -1;
    }
    static int firstNonRepeatingUsingHas(int arr[],int n){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<n;i++){
            if(hm.containsKey(arr[i])){
                hm.put(arr[i], hm.get(arr[i])+1);
            }else{
                hm.put(arr[i], 1);
            }
        }
        for(int i = 0;i<n;i++){
            if(hm.get(arr[i]) == 1){
                return arr[i];
            }
        }
        return -1;

    }
    public static void main(String arg[]){
        int arr[] = { 9, 4, 9, 6, 7, 4 };
        int n = arr.length;
        // System.out.println(fistNonRepeating(arr,n));
System.out.println(firstNonRepeatingUsingHas(arr, n));


    }
}
