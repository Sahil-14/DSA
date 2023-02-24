import java.util.Scanner;

public class HackerEarth {
  public static void swap(Integer i, Integer j) {
    Integer temp = new Integer(i);
    i = j;
    j = temp;
  }

  public static void main(String[] args) {

    // Scanner sc = new Scanner(System.in);
    // // n
    // int row = Integer.parseInt(sc.nextLine());
    // int col = Integer.parseInt(sc.nextLine());
    // int arr[][] = new int[row][col];
    // for (int i = 0; i < row; i++) {
    // for (int j = 0; j < col; j++) {
    // arr[i][j] = sc.nextInt();
    // }
    // }
    // System.out.println();

    // System.out.println(row);
    // System.out.println(col);
    // for (int i = 0; i < row; i++) {
    // for (int j = 0; j < col; j++) {
    // System.out.print(arr[i][j] + " ");
    // }
    // System.out.println();
    // }

    Ingeger i = new Ingeger(10);
    Ingeger j = new Ingeger(20);
    swap(i, j);
    System.out.println(i + " " + j);

  }
}
