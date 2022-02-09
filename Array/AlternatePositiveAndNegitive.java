import java.io.*;
import java.lang.*;
import java.util.*;
public class AlternatePositiveAndNegitive {
    static void fill1(int a[], int neg, int pos) {
        // function which works in the condition when number of
    // negative numbers are lesser or equal than positive
    // numbers
        //odd
        if (neg % 2 == 1) {
            for (int i = 1; i < neg; i += 2) {
                int temp = a[i];
                a[i] = a[i + neg];
                a[i + neg] = temp;
            }
        } else {
            //even
            for (int i = 1; i <= neg; i += 2) {
                int temp = a[i];
                a[i] = a[i + neg - 1];
                a[i + neg - 1] = temp;
            }
        }
    }

    static void fill2(int a[], int neg, int pos) {
        if (pos % 2 == 1) {
            for (int i = 1; i < pos; i += 2) {
                int c = a[i];
                int d = a[i + pos];
                int temp = c;
                a[i] = d;
                a[i + pos] = temp;
            }
        } else {
            for (int i = 1; i <= pos; i += 2) {
                int c = a[i];
                int d = a[i + pos - 1];
                int temp = c;
                a[i] = d;
                a[i + pos - 1] = temp;
            }
        }
    }

    static void reverse(int arr[], int n) {
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;

        }
    }
    static void print(int a[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
    public static void main(String[] args)
    throws java.lang.Exception
{
    // Given array
    int[] arr = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
    int n = arr.length;

    int neg = 0, pos = 0;
    for (int i = 0; i < n; i++) {
        if (arr[i] < 0)
            neg++;
        else
            pos++;
    }
    // Sort the array
    Arrays.sort(arr);

    if (neg <= pos) {
        fill1(arr, neg, pos);
    }
    else {
        // reverse the array in this condition
        reverse(arr, n);
        fill2(arr, neg, pos);
    }
    print(arr, n);
}
}
