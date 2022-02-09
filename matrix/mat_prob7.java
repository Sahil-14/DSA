//Rotate a matrix by 90 degree in clockwise direction without using any extra space

public class mat_prob7 {
  static int N = 4;

  static void rotate90Clockwise(int a[][]) {

    // Traverse each cycle
    for (int i = 0; i < N / 2; i++) {
      for (int j = i; j < N - i - 1; j++) {

        // Swap elements of each cycle
        // in clockwise direction
        int temp = a[i][j];
        a[i][j] = a[N - 1 - j][i];
        a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
        a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
        a[j][N - 1 - i] = temp;
      }
    }
  }

  static void rotate90Clockwise2(int arr[][]) {
    // printing the matrix on the basis of
    // observations made on indices.
    for (int j = 0; j < N; j++) {
      for (int i = N - 1; i >= 0; i--)
        System.out.print(arr[i][j] + " ");
      System.out.println();
    }
  }

  static void printMatrix(int arr[][]) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++)
        System.out.print(arr[i][j] + " ");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int arr[][] = { { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 },
        { 13, 14, 15, 16 } };
    rotate90Clockwise(arr);
    printMatrix(arr);
  }
}
