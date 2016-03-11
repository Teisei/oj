package teisei.leetcode;

import java.util.Stack;

/**
 * Created by Teisei on 2016/3/11.
 */
public class p_130_SurroundedRegions {
    int[][] op = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) {
        p_130_SurroundedRegions test = new p_130_SurroundedRegions();
        test.run();

    }

    public void run() {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'X', 'X'}
        };
        board = new char[][]{
                "XOXOXO".toCharArray(),
                "OXOXOX".toCharArray(),
                "XOXOXO".toCharArray(),
                "OXOXOX".toCharArray()
        };
        printMap(board);
        solve1(board);
        System.out.println("=========================");
        printMap(board);
    }
    public void solve(char[][] board) {
        if(board.length==0) return;
        int h=board.length, w=board[0].length;
        boolean[][] map = new boolean[h][w];
        for(int j=1;j<h-1;j++) dfs(board, map, 0, j);
        for(int j=1;j<h-1;j++) dfs(board, map, h-1, j);
        for(int i=1;i<w-1;i++) dfs(board, map, i, 0);
        for(int i=1;i<w-1;i++) dfs(board, map, i, w-1);
        for(int i=0;i<h;i++)
            for(int j=0;j<w;j++)
                if(!map[i][j]) board[i][j] = 'X';

    }
    public void dfs(char board[][],boolean map[][], int i, int j){
        if(i<0||i>board.length-1||j<0||j>board[0].length-1) return;
        if(map[i][j]) return;
        map[i][j]=true;
        if (board[i][j] == 'X')  return;
        for(int k=0;k<op.length;k++){
            int x=i+op[k][0], y=j+op[k][1];
            dfs(board, map, x, y);
        }
        board[i][j] = 'X';
    }






    public void solve1(char[][] board) {
        if(board.length==0) return;
        int h=board.length, w=board[0].length;
        boolean[][] map = new boolean[h][w];
        for(int j=0;j<w;j++) bfs(board, map, 0, j);
        for(int j=0;j<w;j++) bfs(board, map, h-1, j);
        for(int i=1;i<h-1;i++) bfs(board, map, i, 0);
        for(int i=1;i<h-1;i++) bfs(board, map, i, w-1);
        for(int i=0;i<h;i++)
            for(int j=0;j<w;j++)
                if(!map[i][j]) board[i][j] = 'X';

    }

    public void bfs(char[][] board, boolean[][] map, int i, int j) {
        System.out.println(i + "\t" + j);
        int x, y, xx, yy;
        Stack<Integer> Xstk = new Stack<>();
        Stack<Integer> Ystk = new Stack<>();
        if (!map[i][j]&&board[i][j] == 'O') {Xstk.push(i);Ystk.push(j);}
        map[i][j] = true;
        while (!Xstk.isEmpty()) {
            x=Xstk.pop();y=Ystk.pop();
            for(int k=0;k<op.length;k++){
                xx=x+op[k][0]; yy=y+op[k][1];
                if (xx >= 0 && xx < board.length && yy >= 0 && yy < board[0].length) {
                    if(!map[xx][yy]&&board[xx][yy]=='O'){
                        Xstk.push(xx); Ystk.push(yy);
                    }
                    map[xx][yy] = true;
                }
            }
        }
    }

    public void printMap(char[][] map) {
        for(int i=0;i<map.length;i++) {
            for(int j=0;j<map[0].length;j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
