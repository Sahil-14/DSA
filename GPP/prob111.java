
//snake and ladder
/**
 * Given a snake and ladder board, find the minimum number of dice throws
 * required to reach the destination or last cell from source or 1st cell.
 * Basically, the player has total control over outcome of dice throw and wants
 * to find out minimum number of throws required to reach last cell. If the
 * player reaches a cell which is base of a ladder, the player has to climb up
 * that ladder and if reaches a cell is mouth of the snake, has to go down to
 * the tail of snake without a dice throw.
 * 
 * 
 */
import java.util.*;

public class prob111 {
    static class qentry {
        int v;
        int dist;
    }

    static int getMinimumDicThrow(int moves[], int n) {
        int visited[] = new int[n];
        Queue<qentry> q = new LinkedList<>();
        qentry qe = new qentry();
        visited[0] = 1;
        qe.v = 0;
        qe.dist = 0;
        q.add(qe);

        while (!q.isEmpty()) {
            qe = q.remove();
            int v = qe.v;

            if (v == n - 1)
                break;

            for (int j = v + 1; j < (v + 6) && j < n; j++) {
                if (visited[j] != 1) {
                    qentry a = new qentry();
                    a.dist = qe.dist + 1;
                    visited[j] = 1;

                    if (moves[j] != -1) {
                        a.v = moves[j];
                    } else {
                        a.v = j;
                    }
                    q.add(a);
                }
            }
        }
        return qe.dist;
    }

    public static void main(String[] args) {
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println("Min Dice throws required is " + getMinimumDicThrow(moves, N));
    }
}
