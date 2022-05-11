package src;

import java.util.*;

public class NPuzzle {

    private int[][] puzzle;

    public NPuzzle(int[][] puzzle) {
        this.puzzle = puzzle;
    }

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

    public Iterable<int[][]> neighbors(int[][] m) {
        List<int[][]> res = new ArrayList<int[][]>();
        int i = 0;
        int j = 0;

        for (i = 0; i < m.length; i++) {
            boolean isNext = true;
            for (j = 0; j < m[0].length; j++)
                if (m[i][j] == 0) {
                    isNext = false;
                    break;
                }
            if (!isNext) {
                break;

            }
        }
        int[] x = { 1, -1, 0, 0 };
        int[] y = { 0, 0, 1, -1 };
        for (int t = 0; t < x.length; t++) {
            int i2 = i + x[t];
            int j2 = j + y[t];
            if (i2 >= 0 && i2 < m.length && j2 >= 0 && j2 < m.length) {
                int[][] tokens = copyMatrix(m);
                swap(tokens, i, j, i2, j2);
                res.add(tokens);
            }
        }
        return res;
    }

    public int[][] copyMatrix(int[][] matrix) {
        int[][] tokens = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                tokens[i][j] = matrix[i][j];

        return tokens;
    }

    public int dimension() {
        return puzzle.length;
    }

    private void swap(int[][] m, int i, int j, int x, int y) {
        int t = m[i][j];
        m[i][j] = m[x][y];
        m[x][y] = t;
    }

    public boolean isEqual(int[][] m) {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[0].length; j++) {
                if (puzzle[i][j] != m[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public String toString() {
        String res = "";
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[0].length; j++) {
                res += puzzle[i][j] + "";
            }
            res = " ";
        }
        return res;
    }
}
