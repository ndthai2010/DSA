package src;

public class Robot {
    

    public int count(int M, int N, int i, int j) {
        if(i == M || j == N){
            return 1;
        }else{
            return count(M, N, i + 1, j) + count(M, N, i, j + 1);
        }
    }

    public int countPath(int M, int N, int t){
        return count(M, t, 1, 1) + count(M, N - t, 1, 1);
    }
}
