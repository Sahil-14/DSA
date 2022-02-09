public class prob4 {
    static void rectangle(int row, int col) {
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void holloRectangel(int row, int col) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (i == 1 || i == row || j == 1 || j == col) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }
    }

    static void invertedHalfPyramid(int row, int col) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col - i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void halfPyramid180(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j <= n - i) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    static void halfNumberPyramid(int n) {
        int k = 1;
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(k++ + " ");
            }
            System.out.println();
        }
    }

    static void butterfly(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= 2 * n - 2 * i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= 2 * n - 2 * i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void invertedPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void zeroOnePyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    static void rhombus(int n) {
        for (int i = 1; i <= 5; i++) {
            for (int k = 1; k <= n - i; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void numberPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

    static void palindromePyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= n - i; k++) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            if (i != 1) {
                for (int j = 2; j <= i; j++) {
                    System.out.print(j);
                }
            }

            System.out.println();
        }
    }

    static void pyramid2(int n) {
        for (int i = 1; i <= n; i++) {
            int j;
            for (j = 1; j < n - i; j++) {
                System.out.print(" ");
            }
            int k = i;
            for (; j <= n; j++) {
                System.out.print(k--);
            }
            k = 2;
            for (; j <= n + 1 - i; j++) {
                System.out.print(k++);
            }

            System.out.println();
        }
    }

    static void starPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void ziczac(int n) {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= n; j++) {
                if ((i + j) % 4 == 0 || (i == 2 && j % 4 == 0)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String arg[]) {
        // rectangle(4, 4);
        // System.out.println();
        // holloRectangel(4, 4);
        // System.out.println();
        // invertedHalfPyramid(4, 4);
        // halfPyramid180(4);
        // halfNumberPyramid(4);
        // butterfly(5);
        // invertedPyramid(5);
        // zeroOnePyramid(5);
        // rhombus(5);
        // numberPyramid(5);
        // palindromePyramid(5);
        // pyramid2(5);
        starPattern(5);
        System.out.println();
        ziczac(9);
    }
}
