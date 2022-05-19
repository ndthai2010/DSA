package src;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

@SuppressWarnings({ "unchecked", "deprecation" })
public class GraphDegree {

    private int[][] matrix;// ma trận kề
    private String[] v;// danh sách các đỉnh
    private int n;// số đỉnh

    public void loadGraphFromFile(String fileName) {
        try {
            Scanner sc = new Scanner(new FileReader(fileName));
            n = Integer.parseInt(sc.nextLine());
            v = new String[n];

            for (int i = 0; i < n; i++) {
                v[i] = sc.nextLine();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public int[] getDegree() {
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    degree[i]++;
                }
            }
        }
        return degree;
    }

}
