public class LargestThree {
    public static void largestThree(int arr[],int n){
        int i,first=Integer.MIN_VALUE,second=Integer.MIN_VALUE,third=Integer.MIN_VALUE;
        if(n < 3){
            System.out.println("Invalid array length.");
            return;
        }
        for(i = 0;i<n;i++){
            int current = arr[i];
            if(current > first){
                third = second;
                second = first;
                first = current;
            }
            else if(current >second){
                third = second;
                second  = current;
            }
            else if(current >third){
                third = current;
            }
        }
        System.out.println("First :"+first+" Second :"+second+" Third: "+third);
    }
    public static void main(String[] args)
    {
        int arr[] = { 1,2,3,4,5,6 };
        int n = arr.length;
        largestThree(arr, n);
    }
}
