package teisei.algo.leetcode;

/**
 * Created by Teisei on 2016/5/31.
 */
public class p_73_SetMatrixZeroes {
    public static void main(String[] args) {
        new p_73_SetMatrixZeroes().run();
    }

    public void run() {
        int[][] matrix = new int[][]{
                {1},
                {0}
        };
        printMap(matrix);
        setZeroes(matrix);
        printMap(matrix);

    }

    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean firstR = false, firstC = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    //if(i==0) firstR = true;
                    if (j == 0) firstC = true;
                    matrix[i][0] = 0;
                    if(j!=0) matrix[0][j] = 0;
                }
            }
        }
        //if(firstR) for(int j=0;j<m;j++) matrix[0][j]=0;
        //update columns first
        for (int j = 1; j < m; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < n; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        printMap(matrix);

        for (int i = 1; i < n; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) for (int j = 1; j < m; j++) matrix[0][j] = 0;
        if (firstC) for (int i = 0; i < n; i++) matrix[i][0] = 0;
    }

    public void printMap(int[][] matrix) {
        System.out.println("********************************");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();

        }
    }
}
