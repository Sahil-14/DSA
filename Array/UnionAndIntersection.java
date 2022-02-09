public class UnionAndIntersection {
    static int[] union(int arr1[], int arr2[]) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0, j = 0, k = 0;
        
        int output[] = new int[n1 + n2];

        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                output[k++] = arr1[i++];
            } else if (arr1[i] == arr2[j]) {
                output[k++] = arr1[i++];
               j++;
            } else {
                output[k++] = arr2[j++];
            }
        }
        while (i < n1) {
            output[k++] = arr1[i++];
        }
        while (j < n2) {
            output[k++] = arr2[j++];
        }
        return output;
    }

    static int[] unionWithoutDuplication(int arr1[], int arr2[]) {
        int m = arr1[arr1.length - 1], i;
        int n = arr2[arr2.length - 1];
        int ans = Math.max(m, n);
        int numTable[] = new int[ans + 1];
        int op[] = new int[arr1.length + arr2.length];

        ++numTable[arr1[0]];

        for (i = 1; i < arr1.length; i++) {
            if (arr1[i] != arr1[i - 1]) {
                ++numTable[arr1[i]];
            }
        }

        for (int j = 0; j < arr2.length; j++) {
            if (numTable[arr2[j]] == 0) {
                ++numTable[arr2[j]];
            }
        }
        int k = 0;
        for (int j = 0; j < numTable.length; j++) {
            if (numTable[j] != 0) {
                op[k++] = j;
            }
        }
        return op;

    }

    static int[] intersection(int arr1[], int arr2[]) {
        int m = arr1[arr1.length - 1], i;
        int n = arr2[arr2.length - 1];
        int ans = Math.max(m, n);
        int numTable[] = new int[ans + 1];
        int op[] = new int[Math.min(arr1.length, arr2.length)];
        ++numTable[arr1[0]];
        for (i = 1; i < arr1.length; i++) {
            if (arr1[i] != arr1[i - 1]) {
                ++numTable[arr1[i]];
            }
        }
        int k = 0;
        if(numTable[arr2[0] ]!= 0)
            op[k++] = arr2[0];
        for (int j = 1; j < arr2.length; j++) {
            if (numTable[arr2[j]] != 0 && arr2[j]!=arr2[j-1]) {
                op[k++] = arr2[j];
            }
        }
        return op;
    }

    public static void main(String args[]) {
        int arr1[] = { 1, 2, 4, 5, 5, 6 };
        int arr2[] = { 2, 2, 3, 5,5, 7 };

        // int[] op = unionWithoutDuplication(arr1, arr2);
        int[] op = intersection(arr1, arr2);

        for (int i : op) {
            if (i != 0) {
                System.out.print(i + " ");
            }
        }
    }
}
