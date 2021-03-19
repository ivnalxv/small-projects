package RCube;

public class Move {
    private final Turn turn;
    private final int cnt;

    public Move(Turn turn, int cnt) {
        this.turn = turn;
        this.cnt = cnt % 4;
    }

    public int getCnt() {
        return cnt;
    }

    public Turn getTurn() {
        return turn;
    }
}
