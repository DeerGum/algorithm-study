package study.SWEA.month8_1.SWEA1226;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 문제이름 : 미로1
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14vXUqAGMCFAYD&categoryId=AV14vXUqAGMCFAYD&categoryType=CODE&problemTitle=1226&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA1226_2 {
    static int[][] maze;
    static int[][] dir = { {-1,0},{1,0},{0,-1},{0,1} };
    static int n = 16;
    static boolean clear;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = 10;
        for (int t = 1; t <= tc; t++) {
            br.readLine();
            maze = new int[n][n];
            clear = false;
            String str;
            int r = 0;
            int c = 0;
            for (int i = 0; i < n; i++) {
                str = br.readLine();
                for (int j = 0; j < n; j++) {
                    maze[i][j] = str.charAt(j) - 48;
                    if (maze[i][j] == 2) {
                        r = i;
                        c = j;
                    }
                }
            }

            bfs(r, c);
            bw.write("#"+t+" "+(clear?1:0)+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        while (!q.isEmpty()) {
            int[] t = q.poll();

            if (maze[t[0]][t[1]] == 3) {
                clear = true;
                break;
            }
            maze[t[0]][t[1]] = -1;

            for (int i = 0; i < dir.length; i++) {
                int R = t[0] + dir[i][0];
                int C = t[1] + dir[i][1];

                if (R < 0 || R >= n || R < 0 || R >= n || maze[R][C] == 1 || maze[R][C] == -1) 
                    continue;

                q.offer(new int[]{R,C});
            }
        }
    }
}

/*


*/