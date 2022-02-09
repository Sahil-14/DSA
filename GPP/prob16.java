public class prob16 {
    // write a program to find a unique number in array where all numbers exept one
    // are present twice
    static int unique(int arr[], int size) {
        int xorsum = 0;
        for (int i = 0; i < size; i++) {
            xorsum = xorsum ^ arr[i];
        }
        return xorsum;
    }

    static boolean getBit(int n, int pos) {
        return ((n & (1 << pos)) != 0);
    }

    static int setBit(int n, int pos) {
        return (n | (1 << pos));
    }

    // write a program to find a unique number in array where all numbers exept 2
    // are present twice
    // algorithm
    // step1: find xorsum
    // step2 : find the position of rightmost setbit in xorsum
    // step3: get all numbers form array with setbit at prev position and find
    // xorsum
    // step4: our first number is identify
    // step5: now xor 1st number with first xorsum
    static void uniqueTwo(int arr[], int n) {
        int xorsum = 0;
        for (int i = 0; i < n; i++) {
            xorsum = xorsum ^ arr[i];
        }
        int tempxor = xorsum;
        System.out.println("tempxor:" + tempxor);
        int sb = 0;
        int pos = 0;
        // get the position of 1st set bit from right side
        while (sb != 1) {
            sb = xorsum & 1;
            pos++;
            xorsum = xorsum >> 1;
        }
        System.out.print("pos:" + pos);
        int newxor = 0;
        for (int i = 0; i < n; i++) {
            if (getBit(arr[i], pos - 1)) {
                // System.out.println(arr[i]);
                newxor = newxor ^ arr[i];
            }
        }

        System.out.println(newxor);
        System.out.println(tempxor ^ newxor);

    }

    // write a program to find a unique number in an array where all number except
    // one are present thrice
    static int uniqueThree(int arr[], int n) {
        int result = 0;
        for (int i = 0; i < 64; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (getBit(arr[j], i)) {
                    sum++;
                }
            }
            if (sum % 3 != 0) {
                result = setBit(result, i);
            }
        }

        return result;
    }

    public static void main(String arg[]) {
        int arr[] = { 1, 3, 2, 3, 4, 2, 1, 1, 3, 2 };
        System.out.print(uniqueThree(arr, arr.length));
    }
}
