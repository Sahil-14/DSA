import java.util.*;

public class inputExample {
  public static void main(String arg[]) {
    Scanner scanner = new Scanner(System.in);
    // scanner.useDelimiter("\n");
    int row = Integer.parseInt(scanner.nextLine());
    int col = Integer.parseInt(scanner.nextLine());
    int n = scanner.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }
    int arr[][] = new int[row][col];
    for (int i = 0; i < row; i++) {
    for (int j = 0; j < col; j++) {
    arr[i][j] = scanner.nextInt();
    }

    // }
    String str = scanner.nextLine();

    System.out.println();
    for (int i = 0; i < row; i++) {
    for (int j = 0; j < col; j++) {
    System.out.print(arr[i][j] + " ");
    }
    System.out.println();
    }
    System.out.println(n);
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println(col);
    System.out.println(str);

  }
}
