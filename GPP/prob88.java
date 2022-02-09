import java.util.Map.Entry;
import java.util.*;

///  count number frequecy in array using hashing

public class prob88 {
    static void calFreq(int arr[], int n) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for(int i = 0;i<n;i++){
            int key = arr[i];
            if(hm.containsKey(arr[i])){
                hm.put(arr[i], hm.get(arr[i])+1);
            }else{
                hm.put(key, 1);
            }
        }

        hm.forEach((k,v) -> System.out.println(k+" : "+v));
    }
    public static void main(String[] args) {
        int arr[] = {1, 5, 2, 1, 3, 2, 1};
        int n = arr.length;
        calFreq(arr, n);
    }

}
