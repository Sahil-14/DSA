import java.util.*;
public class FirstReapiting {
    static void printReapitingUsingHashMap(int arr[]){
        HashSet<Integer> hm = new HashSet<>();
        int min = -1;
        for(int i =arr.length-1;i>=0;i--){
            if(hm.contains(arr[i])){
                min = i;
            }else{
                hm.add(arr[i]);
            }

        }
        if(min != -1){
            System.out.println("First repeating element :"+arr[min]);
        }else{
            System.out.println("No repeating elements");
        }

    }
    static int printReapitingWithout(int arr[],int n){
        int max = 0;
        for(int x =0;x<n;x++){
            if(arr[x] > max){
                max = arr[x];
            }
        }
        int temp[] = new int[max+1];
        Arrays.fill(temp,0);
        for(int x = 0;x <n;x++){
            int num = arr[x];
            temp[num]++;
        }
        for(int x = 0;x <n;x++){
            int num = arr[x];
            if(temp[num] > 1){
                return x;
            }
        }
        return -1;
    }
    public static void main(String arg[]){
        int arr[] = {10, 5, 3, 4, 3, 5, 6};
        int result = printReapitingWithout(arr, arr.length);
        // System.out.print(arr[result]);
        // printReapitingUsingHashMap(arr);
         System.out.print(-1/2);
    }
}
