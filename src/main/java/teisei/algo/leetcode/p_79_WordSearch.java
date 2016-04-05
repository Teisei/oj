package teisei.algo.leetcode;

/**
 * Created by Teisei on 2016/2/15.
 */
public class p_79_WordSearch {

    char[][] board;
    String word;
    boolean vst[][];
    int dir[][] = new int[][]{
            {-1,0},
            {1,0},
            {0,1},
            {0,-1}
    };

    public static void main(String[] args) {
        p_79_WordSearch test = new p_79_WordSearch();
        test.init();
        test.run();
    }

    public void init() {
        board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        word = "SEE";
//        board = new char[][]{
//                {'C','A','A'},
//                {'A','A','A'},
//                {'B','C','D'},
//        };
//        word = "AAB";
    }

    public void run() {
        boolean res = exist(board, word);
        System.out.println(res);
    }
    public boolean exist(char[][] board, String word) {
        boolean res = false;
        vst = new boolean[board.length][board[0].length];
        for(int i = 0;i<board.length;i++) {
            for(int j = 0;j<board[i].length;j++) {
                if (dfs(board, vst, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return res;
    }

    public boolean dfs(char[][] board, boolean vst[][], String word, int i, int j, int num) {
        boolean res = false;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || vst[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(num)) {
            return false;
        }
        if (num == word.length() - 1) {
            return true;
        }
//            System.out.println(i + "  " + j + "  " + num);
        vst[i][j] = true;
        boolean tmp_flag = false;
        for (int k = 0; k < dir.length; k++) {
            if (dfs(board, vst, word, i + dir[k][0], j + dir[k][1], num + 1)) {
                return true;
            }
        }
        return res;
    }
}
