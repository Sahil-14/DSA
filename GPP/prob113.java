// surrounded regions
/**
 * 
 * Given a matrix where every element is either ‘O’ or ‘X’, replace ‘O’ with ‘X’
 * if surrounded by ‘X’. A ‘O’ (or a set of ‘O’) is considered to be by
 * surrounded by ‘X’ if there are ‘X’ at locations just below, just above, just
 * left and just right of it.
 */

public class prob113 {
    static int M = 6;
    static int N = 6;

    static void floodFillUtil(char screen[][], int x, int y, char prevC, char newC) {
        // check for grid limit
        if (x < 0 || x >= M || y < 0 || y >= N)
            return;
        if (screen[x][y] != prevC)
            return;

        screen[x][y] = newC;

        int xP[] = { 0, 0, 1, -1 };
        int yp[] = { -1, 1, 0, 0 };

        for (int i = 0; i < 4; i++) {
            floodFillUtil(screen, x + xP[i], y + yp[i], prevC, newC);
        }
    }

    static void surroundedRegion(char screen[][]) {
        // step 1: replace all 'o' wih '-'
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                if (screen[i][j] == 'O')
                    screen[i][j] = '-';

        // step2 : call floodfill for all '-' on edges
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                if (i == 0 || j == 0 || i == M - 1 || j == N - 1)
                    floodFillUtil(screen, i, j, '-', 'O');

        // step3 : replace remaining '-' with 'x'
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                if (screen[i][j] == '-')
                    screen[i][j] = 'X';
    }

    public static void main(String[] args) {
        char[][] mat = { { 'X', 'O', 'X', 'O', 'X', 'X' }, { 'X', 'O', 'X', 'X', 'O', 'X' },
                { 'X', 'X', 'X', 'O', 'X', 'X' }, { 'O', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'O', 'X', 'O' },
                { 'O', 'O', 'X', 'O', 'O', 'O' } };

        surroundedRegion(mat);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(mat[i][j] + " ");

            System.out.println("");
        }
    }

}
