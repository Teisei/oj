package teisei.algo.bop;

/**
 * Created by Teisei on 2016/4/23.
 */
public class P3 {
    public static void main(String[] args) {
        int r1 = 0, c1 = 0, r2 = 2, c2 = 6;
        String[] strs = new String[]{
                ".#.....",
                ".#.#.#.",
                "...#.#."
        };


        System.out.println(Puzzle(r1, c1, r2, c2, strs));

    }

    static int[][] step;
    static boolean[][] vst;
    static boolean[][] map;
    static int N, M;

    public static void init() {
        step = new int[4][2];
        step[0] = new int[]{0, 1};
        step[1] = new int[]{1, 0};
        step[2] = new int[]{0, -1};
        step[3] = new int[]{-1, 0};
    }

    public static String Puzzle(int r1, int c1, int r2, int c2, String[] strs) {
        init();
        map = getMap(strs);
        N = map.length;
        M = map[0].length;
        vst = new boolean[N][M];

        int length = dfs(r1, c1, r2, c2, 0);
        if(length>=0) return "" + length;
        return "No path found!";
    }

    public static int dfs(int x, int y, int r2, int c2, int len) {
        vst[x][y] = true;
        if(x == r2 && y == c2 && map[x][y]) return len;
        for (int i = 0; i < step.length; i++) {
            int xx = x + step[i][0];
            int yy = y + step[i][1];
            if(xx>=0 && xx<N && yy>=0 && yy<M)
                if (!vst[xx][yy] && map[xx][yy]) {
                    int length = dfs(xx, yy, r2, c2, len + 1);
                    if(length>=0) return length;
                }
        }
        return -1;
    }

    public static boolean[][] getMap(String[] strs) {
        boolean[][] map = new boolean[strs.length][strs[0].length()];
        for (int i = 0; i < strs.length; i++) {
            String line = strs[i];
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j) == '.';
            }
        }
        return map;
    }
}
