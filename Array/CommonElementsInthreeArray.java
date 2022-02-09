import java.util.HashMap;

public class CommonElementsInthreeArray {
    static int min(int a, int b, int c) {
        if (a <= b && a <= c)
            return a;
        else if (b <= a && b <= c)
            return b;
        else
            return c;
    }

    static int[] getCommon(int arr1[], int arr2[], int arr3[]) {
        int i = 0, j = 0, k = 0, c = 0;
        int n1 = arr1.length, n2 = arr2.length, n3 = arr3.length;
        int op[] = new int[min(n1, n2, n3)];
        while (i < n1 && j < n2 && k < n3) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                if ((i != 0 && arr1[i] == arr1[i - 1]) && (j != 0 && arr2[j] == arr2[j - 1])
                        && (k != 0 && arr3[k] == arr3[k - 1])) {
                    i++;
                    j++;
                    k++;
                } else {
                    op[c++] = arr1[i++];
                    j++;
                    k++;
                }
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }
        return op;

    }

    public static void main(String arg[]) {
        int ar1[] = { 1,1, 5, 10, 20, 40, 80, 80 };
        int ar2[] = { 1,1, 7, 20, 80, 80, 100 };
        int ar3[] = { 1,1, 4, 15, 20, 30, 70, 80, 80, 120 };

        int result[] = getCommon(ar1, ar2, ar3);
        for (int i : result) {
            System.out.print(i + " ");
        }

    }
}
