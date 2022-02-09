/**
 * Given an array arr of integer elements, the task is to find the range and coefficient of range of the given array where: 
Range: Difference between the maximum value and the minimum value in the distribution. 
Coefficient of Range: (Max – Min) / (Max + Min).
Input: arr[] = {15, 16, 10, 9, 6, 7, 17} 
Output: Range : 11 
Coefficient of Range : 0.478261 
Max = 17, Min = 6 
Range = Max – Min = 17 – 6 = 11 
Coefficient of Range = (Max – Min) / (Max + Min) = 11 / 23 = 0.478261
 */

public class RangeAndCoefficientOfArray {
    static void rangeAndCoeffient(int arr[]){
        int max = MinMax.getMax(arr);
        int min = MinMax.getMin(arr);

        float range = max - min;
        float coef = range /(max+min);
        System.out.println("Range :"+range);
        System.out.println("Coef :"+coef);
    }
    public static void main(String arg[]){
        int arr[] = { 5, 10, 15 };
        rangeAndCoeffient(arr);
    }
}

