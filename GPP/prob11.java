import java.util.*;

public class prob11 {
    static void print(int a[][], int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    static void transpose(int a[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        print(a, 3, 3);
    }

    static void matMultiplication(int n1, int n2, int n3) {
        int m1[][] = new int[n1][n2];
        int m2[][] = new int[n2][n3];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                m1[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < n3; j++) {
                m2[i][j] = sc.nextInt();
            }
        }
        int ans[][] = new int[n1][n3];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n3; j++) {
                ans[i][j] = 0;
            }
        }

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n3; j++) {
                for (int k = 0; k < n2; k++) {
                    ans[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }

        System.out.println(ans);

    }

    // Matrix search
    /**
     * Write a algorithm to find given value exist in matrix or not Integer in each
     * row are sorted in left to right manner. Integer in each column are sorted in
     * top to bottom manner. Brute force := same as linear search optimise approch
     * := start from top-right or bottom left and if arr[r][c] > key then c-- if
     * arr[r][c] > key then r++
     */
    static boolean matrixSearch(int a[][],int n,int m,int key){
        int r = 0,c = m-1;
        while(r <n && c >= 0){
            if(a[r][c] == key){
                return true;
            }else if(a[r][c] < key){
                r++;
            }else{
                c--;
            }
        }
        return false;
    }
    public static void main(String arg[]) {
        int a[][] = { { 1, 2,3 }, {4 , 5, 6 }, { 7, 8, 9 } };
        // transpose(a, 3);

        // matMultiplication(2, 4, 3);
        if(matrixSearch(a, 3, 3, 0)){
            System.out.println("Present");
        }else{
            System.out.println("Absent");
        }
    }
}
