package RCube;


public class Side {
    private final Color lines[][] = new Color[3][3];
    private final Color cols[][] = new Color[3][3];

    public Side(Color color) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                lines[i][j] = color;
                cols[i][j] = color;
            }
        }
    }

    public Color[] get(int x) {
        if (x < 3) {
            return cols[x];
        }
        return lines[x - 3];
    }

    public Color[] getReverse(int x) {
        Color[] temp = get(x);
        Color t = temp[0];
        temp[0] = temp[2];
        temp[2] = t;
        return temp;
    }

    public void sync(boolean ColsToLines) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ColsToLines) {
                    cols[i][j] = lines[j][i];
                } else {
                    lines[i][j] = cols[j][i];
                }
            }
        }
    }

    public void set(Color[] array, int x) {
        if (x < 3) {
            cols[x] = array;
        } else {
            lines[x - 3] = array;
        }
        sync(x > 2);
    }

    public void setCell(int i, int j, Color c) {
        lines[i][j] = c;
        sync(true);
    }

    public Color getCell(int i, int j) {
        return lines[i][j];
    }

    private void swap(int lineNum, int colNum) {
        Color[] temp = lines[lineNum];
        lines[lineNum] = cols[colNum];
        cols[colNum] = temp;
    }

    public void rotateLeft() {
        for (int i = 0; i < 3; i++) {
            swap(i, 2 - i);
        }
        sync(true);
    }

    public void rotateRight() {
        rotateLeft();
        rotateLeft();
        rotateLeft();
    }

    public boolean inSync() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (lines[i][j] != cols[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(lines[i][j]);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
