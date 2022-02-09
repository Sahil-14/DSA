// heapsort
// make maxheap
//delete one-by one
class prac {
  public void heapsort(int arr[], int n) {
    int startindex = n / 2 - 1;
    // makemaxheap
    for (int i = startindex; i >= 0; i--) {
      heapify(arr, n, i);
    }
    // start deleting
    for (int i = n - 1; i > -0; i--) {
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      heapify(arr, n, i);
    }
  }

  public void heapify(int arr[], int n, int i) {
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
      int temp = arr[i];
      arr[i] = arr[largest];
      arr[largest] = temp;
      heapify(arr, n, largest);
    }
  }

  public void countsort(int arr[], int n) {
    // find max from arr[]
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    // make count arry
    int count[] = new int[max + 1];
    for (int i = 0; i < n; i++) {
      count[arr[i]]++;
    }
    // modify count arry with privious sum
    for (int j = 1; j < count.length; j++) {
      count[j] += count[j - 1];
    }
    // make ans array
    int ans[] = new int[n];
    // traverse arr from reverse and fill ans arrray
    for(int i = n-1;i>=0;i--){
      ans[--count[arr[i]]] = arr[i];
    }
  }
}