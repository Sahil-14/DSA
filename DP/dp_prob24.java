//optimal stratergy game pick from end of array
//hard
public class dp_prob24 {
    static class Pair {
        int first, second;
        int pick = 0;

        public String toString() {
            return first + " " + second + " " + pick;
        }
    }

    public Pair[][] findMoves(int pots[]) {

        Pair[][] moves = new Pair[pots.length][pots.length];

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < moves[i].length; j++) {
                moves[i][j] = new Pair();
            }
        }

        for (int i = 0; i < pots.length; i++) {
            moves[i][i].first = pots[i];
            // to track the sequence of moves
            moves[i][i].pick = i;
        }

        for (int l = 2; l <= pots.length; l++) {
            for (int i = 0; i <= pots.length - l; i++) {
                int j = i + l - 1;
                if (pots[i] + moves[i + 1][j].second > moves[i][j - 1].second + pots[j]) {
                    moves[i][j].first = pots[i] + moves[i + 1][j].second;
                    moves[i][j].second = moves[i + 1][j].first;
                    moves[i][j].pick = i;
                } else {
                    moves[i][j].first = pots[j] + moves[i][j - 1].second;
                    moves[i][j].second = moves[i][j - 1].first;
                    moves[i][j].pick = j;
                }
            }
        }

        return moves;
    }

    // prints the sequence of values and indexes
    public void printSequence(int pots[], Pair moves[][]) {
        int i = 0;
        int j = pots.length - 1;
        int step;
        for (int k = 0; k < pots.length; k++) {
            step = moves[i][j].pick;
            // this is the value of pick and its index
            System.out.print("value: " + pots[step] + " " + "index: " + step + " ");
            System.out.println();
            if (step <= i) {
                i = i + 1;
            } else {
                j = j - 1;
            }
        }
    }

    public static void main(String args[]) {
        dp_prob24 npg = new dp_prob24();
        // int pots[] = { 3, 1, 5, 6, 2, 9, 3 };
        int pots[] = { 3, 9, 1, 2 };
        Pair[][] moves = npg.findMoves(pots);
        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < moves[i].length; j++) {
                System.out.print(moves[i][j] + "  ");
            }
            System.out.print("\n");
        }
        System.out.println("The moves by first player and second player:");
        npg.printSequence(pots, moves);
    }
}
