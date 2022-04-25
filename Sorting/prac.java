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
    for (int i = n - 1; i >= 0; i--) {
      ans[--count[arr[i]]] = arr[i];
    }
  }

  public void swap(int arr[], int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  public void bubbleSort(int arr[], int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          swap(arr, j, j + 1);
        }
      }
    }
  }

  public int selectionSort(int arr[], int n) {
    for (int i = 0; i < n; i++) {
      int min = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[min]) {
          min = j;
        }
      }
      swap(arr, i, min);
    }
  }

  public void insertionSort(int arr[], int n) {
    for (int i = 1; i < n; i++) {
      int j = i - 1;
      int current = arr[i];
      while (j >= 0 && current < arr[j]) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = current;
    }
  }

  public int partition(int arr[], int l, int r) {
    int i = l - 1, j;
    int pivot = arr[r];
    for (j = l; j < r; j++) {
      if (arr[j] < pivot) {
        i++;
        swap(arr, i, j);
      }
    }
    swap(arr, i + 1, r);
    return i + 1;
  }

  public void quicksort(int arr[], int l, int r) {
    if (l < r) {
      int position = partition(arr, l, r);
      quicksort(arr, l, position - 1);
      quicksort(arr, position + 1, r);
    }
  }

  public void dnf(int arr[], int n) {
    int low = 0, mid = 0, high = n - 1;
    for (int i = 0; i < n; i++) {
      if (arr[mid] == 0) {
        swap(arr, low, mid);
        low++;
        mid++;
      } else if (arr[mid] == 1) {
        mid++;
      } else {
        swap(arr, mid, high);
        high--;
      }
    }
  }

  public void mergeSort(int arr[], int l, int r) {
    if (l < r) {
      int mid = (l + r) / 2;
      mergeSort(arr, l, mid);
      mergeSort(arr, mid + 1, r);
      merge(arr, l, r);
    }
  }

  public void merge(int arr[], int l, int r) {
    int mid = (l + r) / 2;
    int temp[] = new int[r - l + 1];
    int i = l;
    int j = mid + 1;
    int r = 0;
    while (i <= mid && j <= r) {
      if (arr[i] < arr[j]) {
        temp[r++] = arr[i++];
      } else {
        temp[r++] = arr[j++];
      }
    }
    while (i <= mid) {
      temp[r++] = arr[i++];
    }
    while (j <= r) {
      temp[r++] = arr[j++];
    }

    i = l;
    for (int k = 0; k < temp.length; k++) {
      arr[i++] = temp[k++];
    }

  }

  public int countSort(int arr[], int n) {
    int max = arr[0];
    for (int i = 1; i < n; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    int count[] = new int[max + 1];
    for (int i = 0; i < n; i++) {
      count[arr[i]]++;
    }

    for (int j = 1; j < n; j++) {
      count[j] += count[j - 1];
    }
    int output[] = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i++) {
      output[--count[arr[i]]] = arr[i];
    }
  }

  public int count(int arr[], int exp) {

    int count[] = new int[10];
    for (int i = 0; i < 10; i++) {
      count[(arr[i] / exp) % 10]++;
    }

    for (int j = 1; j < 10; j++) {
      count[j] += count[j - 1];
    }
    int output[] = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i++) {
      output[--count[(arr[i] / exp) % 10]] = arr[i];
    }
  }

  public int radixSort(int arr[]) {
    int max = getMax(arr);
    for (int exp = 1; (max / exp) > 0; exp = exp * 10) {

    }
  }
}