package study.nathan_algo_study.week58;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 로봇청소기
 * 링크 : https://www.acmicpc.net/problem/14503
 */

public class Baekjoon14503 {
    static int N, M;
    static int[][] map;
    static int currX, currY, currD;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        currX = Integer.parseInt(st.nextToken());
        currY = Integer.parseInt(st.nextToken());
        currD = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


    }

    public static void dfs(int r, int c, boolean[][] v) {
        v[r][c] = true;
    }
}

/*

*/
