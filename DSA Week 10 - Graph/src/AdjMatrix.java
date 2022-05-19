package src;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings({ "unchecked", "deprecation" })
public class AdjMatrix {

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

            matrix = new int[n][n];

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

    public List<String> getAdjList() {
        List<String> adjList = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            String list = v[i];
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    list += "->" + v[j];
                }
            }
            adjList.add(list);
        }
        return adjList;
    }

}
