//number without consecutive 1ns in binary representative
//fibonacci serice with n1 = 2,n2 = 3 (inital state a = 1,b = 1)
public class dp_prob36 {
  public int count(int n) {
    int a[] = new int[n];
    int b[] = new int[n];
    a[0] = 1;
    b[0] = 1;
    for (int i = 1; i < n; i++) {
      a[i] = a[i - 1] + b[i - 1];
      b[i] = a[i];
    }
    return a[n - 1] + b[n - 1];
  }

  public int countSimple(int n) {
    int a = 1;
    int b = 1;
    for (int i = 1; i < n; i++) {
      int temp = a;
      a = a + b;
      b = temp;
    }
    return a + b;
  }

  public static void main(String[] args) {
    dp_prob36 ob = new dp_prob36();
    System.out.println(ob.countSimple(4));
  }
}
