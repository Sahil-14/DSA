// print all subset from 1 to n;
public class bit_prob_4 {
  public static void subset(int arr[], int n) {
    for (int i = 0; i < (1 << n); i++) {
      for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) != 0) {
          System.out.print(arr[j] + "\t");
        }
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 4 };
    subset(arr, 4);
  }
}
