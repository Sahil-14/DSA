//count the total nuber of preorder bt from given n;
public class dp_prob39 {
  public int countPreorder(int n) {
    int T[] = new int[n + 1];
    T[0] = 1;
    T[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        T[i] += T[j] * T[i - j - 1];
      }
    }
    return T[n];
  }

  public static void main(String[] args) {
    dp_prob39 ob = new dp_prob39();
    System.out.println(ob.countPreorder(5));
  }

  public int catalin(int n) {
    int arr[] = new int[n + 1];
    arr[0] = 1;
    arr[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        arr[i] += arr[j] * arr[i - j - 1];
      }
    }
  }
}
