class BubbleSort {
    void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
    }

    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String arg[]) {
        int arr[] = { 5, 4, 3, 2, 1 };
        BubbleSort bs = new BubbleSort();
        System.out.println("before sorting");
        bs.printArray(arr);
        bs.bubbleSort(arr);
        System.out.println("after sorting");

        bs.printArray(arr);

    }
}