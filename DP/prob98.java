
import java.util.*;

// maximum and minimum difference greedy
//Problem: You are given an array A ,of n elements.You have to remove exactly n/2 elements
// from an array and add it to another array B (intially empty).Find the maximum and minimum 
//values of difference between these two arrays.The difference between those two arrays is sum(abs(A[i]-B[i]).

// for max : sort array 
// diff = a[i] -a[j] a[i] should be as big  as possible and a[j] should be as low as possibel like last - first in sorted array
// simplifies to add all element with index > n/2 and subtract 0 to n/2-1

// for min :sort array
// add all odd and subtract all event index(for minimum differece number should be similar)

public class prob98 {
    public static void main(String[] args) {
        int n = 4;
        Vector<Integer> arr = new Vector<Integer>(n);
        arr.add(-3);
        arr.add(10);
        arr.add(0);
        arr.add(12);
        Collections.sort(arr);
       
        long mx =0,mn = 0;
        for(int i = 0;i<n/2;i++){
            mx += (arr.get(i+n/2)-arr.get(i));
            mn += (arr.get(2*i+1)-arr.get(2*i));
        }

        System.out.println("Max"+": "+mx);
        System.out.println("Min"+": "+mn);


     }
}
