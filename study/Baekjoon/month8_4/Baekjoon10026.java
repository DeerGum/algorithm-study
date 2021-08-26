package study.Baekjoon.month8_4;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 적록색약
 * 링크 : https://www.acmicpc.net/problem/10026
 */

public class Baekjoon10026 {
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static char[][] map;
    static int N;
    static boolean[][] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) 
            map[i] = br.readLine().toCharArray();
        
        v = new boolean[N][N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!v[i][j]) {
                    dfs(i, j, map[i][j]);
                    count++;
                }
            }
        }

        changeMap();

        v = new boolean[N][N];
        int count2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!v[i][j]) {
                    dfs(i, j, map[i][j]);
                    count2++;
                }
            }
        }

        bw.write(count+" "+count2+"\n");
        bw.close();
    }

    public static void dfs(int r, int c, char color) {
        v[r][c] = true;

        for (int i = 0; i < dir.length; i++) {
            int dr = r + dir[i][0];
            int dc = c + dir[i][1];

            if (dr < 0 || dr >= N || dc < 0 || dc >= N || v[dr][dc] || map[dr][dc] != color) 
                continue;
            
            dfs(dr, dc, color);
        }
    }

    public static void changeMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G') { // 초록색을 빨간색으로 변경
                    map[i][j] = 'R';
                }
            }
        }
    }
}

/*
5
RRRBB
GGBBB
BBBRR
BBRRR
RRRRR

RRRBB
RRBBB
BBBRR
BBRRR
RRRRR


*/
