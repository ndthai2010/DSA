package src;

public class Manhattan {

    public int manhattan(int[][] m) {
        int manhattan = 0;
        for (int row = 0; row < m.length; row++) {
            for (int col = 0; col < m[0].length; col++) {
                if (m[row][col] != 0) {

                    int i = (m[row][col] - 1) / m.length;
                    int j = (m[row][col] - 1) % m.length;
                    manhattan += Math.abs(row - i) + Math.abs(col - j);
                }
            }
        }

        return manhattan;
    }
}
