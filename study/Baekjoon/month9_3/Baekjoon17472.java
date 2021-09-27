package study.Baekjoon.month9_3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 다리 만들기2
 * 링크 : https://www.acmicpc.net/problem/17472
 */

public class Baekjoon17472 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //섬 매핑
        visited = new boolean[N][M];
        int number = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    landMapping(i, j, ++number);
                }
            }
        }

        //섬끼리 이을 수 있는 다리 구함
        


    }
    
    public static void landMapping(int r, int c, int number) {
        visited[r][c] = true;
        map[r][c] = number;

        for (int i = 0; i < dir.length; i++) {
            int dr = r + dir[i][0];
            int dc = c + dir[i][1];

            if (dr < 0 || dr >= N || dc < 0 || dc >= M || visited[dr][dc] || map[dr][dc] == 0)
                continue;

            landMapping(dr, dc, number);
        }
    }

    public static void bridgeSearch() {

    }
    
    
}

/*


*/
