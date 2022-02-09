/**
 * You are given an array of 0s and 1s in random order. Segregate 0s on left side and 1s on 
 * right side of the array. Traverse array only once.
 */
public class OsAnd1ns {
    static void segregateOand1(int arr[]){
        int count  = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 0){
                count++;
            }
        }
        int j;
        for(j=0;j<count;j++){
            arr[j]=0;
        }
        System.out.println("====="+j+"===== ");
        for(;j<arr.length;j++){
            arr[j] = 1;
        }
    }
    static void byUsingTwoPointer(int arr[]){
        int n = arr.length;
        int left = 0,right = n-1;
        while(left < right){
            while(arr[left] == 0 && left < right){
                left++;
            }
            while(arr[right] == 0 && left <right){
                right--;
            }
            if(left > right){
                
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }

    }
    static void printArray(int arr[]){
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args)
    {
        int arr[] = new int[]{ 0, 1, 0, 1, 1, 1,0,0,1 };
       
       
        segregateOand1(arr);
        // byUsingTwoPointer(arr);
        printArray(arr);
         
    }
}
