/**
 * You are given a list of n-1 integers and these integers are in the range of 1
 * to n. There are no duplicates in the list. One of the integers is missing in
 * the list. Write an efficient code to find the missing integer.
 * 
 * Method 1: make counting array. Method:2 Summation Time Complexity: O(n). Only
 * one traversal of the array is needed. Space Complexity: O(1). No extra space
 * is needed Method :3 Same as summation but their can be overflow of integer to
 * avoid that he approach remains the same but there can be overflow if n is
 * large. In order to avoid integer overflow, pick one number from known numbers
 * and subtract one number from given numbers. This way there won’t have Integer
 * Overflow ever. Method :4 XOR
 * 
 */
public class MissingInterger {
    // method1
    static int missingBycount(int arr[], int n) {
        int mis = 0;
        int count[] = new int[n + 2];
        for (int i = 0; i < n; i++) {
            ++count[arr[i]];
        }
        for (int j = 1; j < count.length; j++) {
            if (count[j] == 0) {
                mis = j;
                break;
            }
        }
        return mis;
    }

    // method2
    static int missingBySummation(int arr[], int n) {
        int neccSum = ((n + 1) * (n + 2)) / 2;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return neccSum - sum;
    }

    // method3
    static int getMissingNo(int a[], int n) {
        int total = 1;
        for (int i = 2; i <= (n + 1); i++) {
            total += i;
            total -= a[i - 2];
        }
        return total;
    }

    static int missingUsingXOR(int a[], int n) {
        int x1 = a[0];
        int x2 = 1;
        for (int i = 1; i < n; i++){
            x1 = x1 ^ a[i];
            
        }
        System.out.println(x1);  
        for (int i = 2; i <= n + 1; i++)
            x2 = x2 ^ i;
        return (x1 ^ x2);
    }

    public static void main(String arr[]) {
        int[] a = { 1, 2, 3, 4, 5 };
        
        int n = a.length;
        // int m = missingBycount(a, n);
        // int m = missingBySummation(a, n);
        int m = missingUsingXOR(a, n);
        System.out.print("Missing element is " + m);
    }
}
