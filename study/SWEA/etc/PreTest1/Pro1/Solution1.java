package study.SWEA.etc.PreTest1.Pro1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1 {
    static int N;
    static int[][] board;
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static int countDol;
    static boolean[][] v;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            countDol = 0;
            int startR = -1;
            int startC = -1;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    if (board[i][j] == 2) {
                        startR = i;
                        startC = j;
                        board[i][j] = 0;
                    }
                }
            }
            v = new boolean[N][N];

            dfs(startR, startC, 0);
            bw.write("#" + t + " " + countDol + "\n");
        }
        bw.close();
    }

    public static void dfs(int row, int col, int cnt) {
        if (cnt == 3)
            return;

        for (int i = 0; i < dir.length; i++) {
            int dr = row + dir[i][0];
            int dc = col + dir[i][1];
            boolean findDol = false;
            while (!isOver(dr, dc) && !findDol) { // 돌 찾을 때까지 이동
                if (board[dr][dc] == 1) {
                    findDol = true;
                }
                dr += dir[i][0];
                dc += dir[i][1];
            }

            if (!findDol || isOver(dr, dc)) // 돌을 못찾았거나 이미 범위를 벗어났으면
                continue;

            boolean nextDol = false;
            do { // 이동할 좌표 탐색
                if (board[dr][dc] == 1) { // 두번째 돌을 찾으면
                    nextDol = true; // 탐색종료
                    if (!v[dr][dc]) { // 잡은적이 없으면
                        board[dr][dc] = 0; // 돌 잡음
                        countDol++;
                        v[dr][dc] = true;
                    }
                }
                dfs(dr, dc, cnt + 1);
                if (nextDol) // 돌잡고 탐색끝나면 다시 되돌려 놓음
                    board[dr][dc] = 1;

                dr += dir[i][0];
                dc += dir[i][1];
            } while (!isOver(dr, dc) && !nextDol);
        }
    }

    public static boolean isOver(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= N;
    }
}
/*
 13 0 1 0 0 0 0 0 0 0 0 0 0 0 0 x 0 0 0 0 0 0 x x 0 x 0 0 x 0 0 0 0 0 0 x 0 0
 0 0 0 0 x 1 0 0 0 0 0 0 0 0 0 0 0 2 0 1 0 x 0 0 0 0 0 0 0 1 0 0 0 1 0 x 1 0 0
 1 0 0 0 0 0 0 0 0 0 0 0 x 0 0 x 0 0 x 0 1 x 0 0
 3 5 0 1 0 0 1 1 1 0 0 0 0 1 1 0 1 0 0 2 0 0 1 0 1 1 0 10 0 1 0 0 0 0 0 0 0 0
 0 0 0 0 1 0 0 0 0 0 0 1 1 0 1 0 0 1 0 0 0 0 0 0 1 0 0 0 0 0 0 1 1 0 0 0 0 0 0
 0 0 0 0 0 2 0 1 0 1 0 0 0 0 0 0 0 1 0 0 0 1 0 1 1 0 0 1 0 0 0 0 0 0 0 0 0 0 0
 1 0 0 1 0 0 1 0 1 1 0 0 20 0 0 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1 0
 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0
 0 0 2 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0
 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0
 0 0 1 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 1 0 0 0 0 0 0 0 0
 0 0 0 0 0 0 0 0 0 1 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1 0 0
 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 1 0 0 0 0 0 1
 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0
 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1
 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0
 
 
 
 */