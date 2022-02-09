/**
 * Given a boolean 2D array, where each row is sorted. Find the row with the
 * maximum number of 1s.
 * 
 * 
 */

public class MaxNoOf1sInRow {
    static int R = 4, C = 4;

    // Method :1 Using Binary search  t(o) = mLogn (m = row,n = column)
    static int firstOcc(int arr[], int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || arr[mid - 1] == 0) && arr[mid] == 1)
                return mid;
            else if (arr[mid] == 0)
                return firstOcc(arr, mid + 1, high);
            else
                return firstOcc(arr, low, mid - 1);

        }
        return -1;
    }

    static int rowWithMax1s(int mat[][]) {
        int max_row_index = 0, Max = -1;
        int i, index;
        for (i = 0; i < R; i++) {
            index = firstOcc(mat[i], 0, C - 1);
            if (index != -1 && C - index > Max) {
                Max = C - index;
                max_row_index = i;
            }
        }
        return max_row_index;
    }
    // Method :2
    static int rowWithMax1s2(int mat[][]){
        int max_row_index = 0;
        int j = firstOcc(mat[0], 0, C-1);
        if(j == -1);
            j = C-1;
        for(int i = 1;i<R;i++){
            while(j >= 0 && mat[i][j]==1){
                j = j-1;
                max_row_index = i;
            }
        }
        return max_row_index;
    }
    public static void main(String arg[]) {
        int mat[][] = { { 0, 0, 0, 1 }, { 0, 1, 1, 1 }, { 0, 0, 1, 1 }, { 0, 0, 0, 0 } };
        System.out.println("Index of row with maximum 1s is " + rowWithMax1s(mat));
        System.out.println("Index of row with maximum 1s is " + rowWithMax1s2(mat));

    }
}
