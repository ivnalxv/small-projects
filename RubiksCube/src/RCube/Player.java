package RCube;

import java.util.Map;

public class Player {
    private final Cube cube = new Cube();
    private final boolean loggingOn;
    private final String[] args;

    private static final Map<Character, Turn> TURNS = Map.of(
            'L', Turn.L,
            'R', Turn.R,
            'F', Turn.F,
            'B', Turn.B,
            'U', Turn.U,
            'D', Turn.D
    );

    public Player(String[] args, boolean loggingOn) {
        this.loggingOn = loggingOn;
        this.args = args;
    }

    public void play() {
        log();
        if (args.length == 0) return;

        char saved = 'a';
        for (int ind = 0; ind < args.length; ind++) {
            for (int i = 0; i < args[ind].length(); i++) {
                char c = args[ind].charAt(i);
                if (Character.isWhitespace(c)) continue;

                if (TURNS.containsKey(c)) {
                    if (saved != 'a') {
                        turn(TURNS.get(saved));
                    }
                    saved = c;
                } else {
                    if (saved != 'a') {
                        turnCube(new Move(TURNS.get(saved), 3));
                    }
                    saved = 'a';
                }
            }
        }

        turnCube(new Move(TURNS.get(saved), 1));
    }

    public void turn(Turn t) {
        turnCube(new Move(t, 1));
    }

    private void turnCube(Move move) {
        for (int i = 0; i < move.getCnt(); i++) {
            cube.turn(move.getTurn());
        }
        log();
    }

    private void log() {
        if (loggingOn) {
            System.out.println(cube);
        }
    }

    @Override
    public String toString() {
        return cube.toString();
    }
}
