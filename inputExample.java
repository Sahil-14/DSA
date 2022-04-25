import java.util.*;

public class inputExample {
  public static void main(String arg[]) {
    Scanner scanner = new Scanner(System.in);
    // scanner.useDelimiter("\n");
    int row = scanner.nextInt();
    int col = scanner.nextInt();
    int arr[][] = new int[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        arr[i][j] = scanner.nextInt();
      }

    }

    System.out.println();
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        System.out.print(arr[i][j]+" ");
      }
      System.out.println();
    }

  }
}
