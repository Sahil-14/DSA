// Page allocation problem
// n = number of pages in a different book
// m = number of students
// all the books have to be divided amongs m students consecutively . allocate the pages in such a way that maximum pages allocated to 
// student is a minimum

public class prob77 {
    static boolean isPossible(int arr[], int n, int m, int min) {
        int studentRequiered = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > min) {
                return false;
            }
            // pages we are giving to current student
            if (sum + arr[i] > min) {
                studentRequiered++;
                // if we want to give min pages to student cant increase it ferther
                sum = arr[i];
                if (studentRequiered > m) {
                    return false;
                }

            } else {

                sum += arr[i];
            }
        }
        return true;
    }

    static int allocateMinimumPages(int arr[], int n, int m) {
        int sum = 0;
        if (n < m) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }

        int start = 0, end = sum, ans = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isPossible(arr, n, m, mid)) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 12, 34, 67, 90 };
        int n = 4;
        int m = 2;
        System.out.println(allocateMinimumPages(arr, n, m));
    }

}
