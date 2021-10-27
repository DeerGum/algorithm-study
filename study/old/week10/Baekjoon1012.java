package study.old.week10;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 유기농 배추
 * 링크 : https://www.acmicpc.net/problem/1012
 * 알고리즘 분류
 * - 깊이우선탐색
 * - 너비우선탐색
 * - 그래프 탐색
 */

public class Baekjoon1012 {
    public static int[][] dir = { {-1,0}, {1,0}, {0,-1}, {0,1} };
    public static int[][] farm;
    public static int m;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            farm = new int[m][n];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                farm[x][y] = 1;
            }

            int count = 0;

            for (int j = 0; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    if(farm[j][l] == 1) {
                        count++;
                        dfs(j, l);
                    }
                }
            }

            bw.write(count+"\n");
        }
        bw.flush();

        
    }

    public static void dfs(int x, int y) {
        farm[x][y] = -1;

        for (int i = 0; i < dir.length; i++) {
            int r = x + dir[i][0];
            int c = y + dir[i][1];

            if(r < 0 || c < 0 || r >= m || c >= n)
                continue;

            if(farm[r][c] == 1) {
                dfs(r, c);
            }
        }
    }

}
