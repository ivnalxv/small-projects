package RCube;


public class Cube {
    private Side[] sides = new Side[6];

    public Cube() {
        reset();
    }

    public void reset() {
        sides[0] = new Side(Color.W);
        sides[1] = new Side(Color.O);
        sides[2] = new Side(Color.G);
        sides[3] = new Side(Color.R);
        sides[4] = new Side(Color.B);
        sides[5] = new Side(Color.Y);
    }

    public void turnLs() {
        sides[1].rotateLeft();
        Color[] temp = sides[0].getReverse(0);
        sides[0].set(sides[2].get(0), 0);
        sides[2].set(sides[5].get(0), 0);
        sides[5].set(sides[4].getReverse(2), 0);
        sides[4].set(temp, 2);
    }

    public void turnL() {
        turnLs();
        turnLs();
        turnLs();
    }

    // Good
    public void turnF() {
        sides[2].rotateRight();
        Color[] temp = sides[3].getReverse(0);
        sides[3].set(sides[0].get(5), 0);
        sides[0].set(sides[1].getReverse(2), 5);
        sides[1].set(sides[5].get(3), 2);
        sides[5].set(temp, 3);
    }

    // Check mb, Apparently good
    public void turnU() {
        sides[0].rotateRight();
        Color[] temp = sides[1].get(3);
        sides[1].set(sides[2].get(3), 3);
        sides[2].set(sides[3].get(3), 3);
        sides[3].set(sides[4].get(3), 3);
        sides[4].set(temp, 3);
    }

    // Yes
    public void turnD() {
        sides[5].rotateRight();
        Color[] temp = sides[2].get(5);
        sides[2].set(sides[1].get(5), 5);
        sides[1].set(sides[4].get(5), 5);
        sides[4].set(sides[3].get(5), 5);
        sides[3].set(temp, 5);
    }

    // Yes
    public void turnR() {
        sides[3].rotateRight();
        Color[] temp = sides[0].getReverse(2);
        sides[0].set(sides[2].get(2), 2);
        sides[2].set(sides[5].get(2), 2);
        sides[5].set(sides[4].getReverse(0), 2);
        sides[4].set(temp, 0);
    }

    public void turnB() {
        sides[4].rotateRight();
        Color[] temp = sides[0].getReverse(3);
        sides[0].set(sides[3].get(2), 3);
        sides[3].set(sides[5].getReverse(5), 2);
        sides[5].set(sides[1].get(0), 5);
        sides[1].set(temp, 0);
    }

    public void turn(Turn t) {
        if (t == Turn.L) turnL();
        else if (t == Turn.R) turnR();
        else if (t == Turn.B) turnB();
        else if (t == Turn.D) turnD();
        else if (t == Turn.F) turnF();
        else if (t == Turn.U) turnU();
        else throw new UnsupportedOperationException("This Turn doesn't exist, wtf: " + t);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("  00 01 02 03 04 05 06 07 08 09 10 11\n");

        for (int i = 0; i < 9; i++) {
            sb.append(i);
            for (int j = 0; j < 12; j++) {
                sb.append("  ");
                if (2 < i && i < 6) {
                    sb.append(sides[j/3 + 1].getCell(i % 3, j % 3));
                } else {
                    if (2 < j && j < 6) {
                        sb.append(sides[i < 3 ? 0 : 5].getCell(i % 3, j % 3));
                    } else {
                        sb.append('.');
                    }
                }
            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
