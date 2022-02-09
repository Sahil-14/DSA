// Given an array, write functions to find the minimum and maximum elements in it. 
public class MinMax {
    public static int getMin(int arr[]){
        int min = arr[0];
        for(int i = 0;i <arr.length;i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
    public static int getMax(int arr[]){
        int max = arr[0];
        for(int i = 0;i<arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    public static void main(String arg[]){
        int arr[] = new int[] { 3, 5, 2, 4,  9,  3,
            1, 7, -3, 11, -12, 3 };

          
            int min = getMin(arr);
            int max =getMax(arr);
            System.out.println("Max :"+max);
            System.out.println("Min:"+min);
    }
}
