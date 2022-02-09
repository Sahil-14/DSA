import java.util.*;

import javax.swing.text.AbstractDocument.Content;

public class practice {
  int size = 0;

  public void swap(int a, int b, int arr[]) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  public void maxheapWithoutHeapify(int heap[], int n) {
    for (int i = 1; i < n; i++) {
      int current = i;
      int parent = (current - 1) / 2;
      while (current > 0 && heap[current] > heap[parent]) {
        swap(current, parent, heap);
        current = parent;
        parent = (current - 1) / 2;
      }
    }
  }

  public void insert(int arr[], int n) {
    // if size is 0
    if (size == 0) {
      arr[size] = n;
      return;
    }
    // increaset heap size and insert elenent at end
    arr[++size] = n;
    int current = size;
    int parent = (current - 1) / 2;
    // maintain maxheap;
    while (current > 0 && arr[current] > arr[parent]) {
      swap(current, parent, arr);
      current = parent;
      parent = (current - 1) / 2;
    }
  }

  public int maxHeapify(int arr[], int i, int n) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && arr[left] > arr[largest]) {
      largest = left;
    }
    if (right < n && arr[right] > arr[largest]) {
      largest = right;
    }

    if (largest != i) {
      swap(largest, i, arr);
      maxHeapify(arr, largest);
    }
  }

  public void deleteHeap(int arr[], int n) {
    int temp = arr[0];
    arr[0] = arr[n - 1];
    maxHeapify(arr, 0, n);
  }

  public int buildHeap(int arr[], int n) {
    int startInx = (n / 2) - 1;
    for (int i = startInx; i >= 0; i--) {
      maxHeapify(arr, i);
    }
  }

  public void soe(int n) {
    int prime[] = new int[100];
    Arrays.fill(prime, 0);

    for (int i = 2; i <= n; i++) {
      if (prime[i] == 0) {
        for (int j = i * i; i <= n; j += i) {
          prime[i] = 1;
        }
      }
    }

    for (int i = 0; i <= n; i++) {
      if (prime[i] == 0) {
        System.out.println(i);
      }
    }
  }

  public void primeFactorise(int n) {
    int primeFact[] = new int[100];
    Arrays.fill(primeFact, 0);

    for (int i = 0; i <= n; i++) {
      primeFact[i] = i;
    }
    for (int i = 2; i <= n; i++) {
      if (primeFact[i] == i) {
        for (int j = i * i; j <= n; j++) {
          if (primeFact[j] == j) {
            primeFact[j] = i;
          }
        }
      }
    }
  }

  public static void reverse(String s) {
    if (s.length() == 0) {
      return;
    }
    char ch = s.charAt(0);
    String ros = s.substring(1);
    reverse(ros);
    System.out.print(ch);
  }

  public void replacepi(String s) {
    if (s.length() == 0) {
      return;
    }
    if (s.charAt(0) == 'p' && s.charAt(1) == 'i') {
      System.out.print("3.14");
      replacepi(s.substring(2));
    } else {
      System.out.print(s.charAt(0));
      replacepi(s.substring(1));
    }
  }

  public void towerOfHonoi(int n, char src, char dest, char help) {
    if (n == 0) {
      return;
    }
    towerOfHonoi(n - 1, src, help, dest);
    System.out.print("move " + n + src + " to " + dest);
    towerOfHonoi(n, help, dest, src);
  }

  public String removeAdjacent(String s) {
    if (s.length() == 0) {
      return "";
    }
    char ch = s.charAt(0);
    String ros = s.substring(1);
    if (ros.charAt(0) == ch) {
      return res;
    }

    return ch + ros;

  }

  public String moveXToend(String s) {
    if (s.length() == 0) {
      return "";
    }
    char ch = s.charAt(0);
    String ros = s.substring(1);
    if (ch == 'x') {
      return ros + ch;
    }

    return ch + ros;

  }

  public void subSting(String s, String ans) {
    if (s.length() == 0) {
      System.out.println(ans);
      return;
    }
    String ros = s.substring(1);
    char ch = s.charAt(0);
    subSting(ros, ans);
    subSting(ros, ans + ch);

  }

  public void permutations(String s, String ans) {
    if (s.length() == 0) {
      System.out.print(ans);
      return;
    }

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      String ros = s.substring(0, i) + s.substring(i + 1);
      permutations(ros, ans + ch);
    }
  }

  public int numberPath(int start,int end){
    int count = 0;
    if(s == e){
      return 1;
    }
    if(s > e){
      return 0;
    }
    for(int i = 1;i<=6;i++){
      count+= numberPath(start+i, end);
    }
    return count;
  }

  public static void main(String[] args) {
    reverse("binod");
  }
}
