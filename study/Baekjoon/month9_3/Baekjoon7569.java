package study.Baekjoon.month9_3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 토마토
 * 링크 : https://www.acmicpc.net/problem/7569
 */

public class Baekjoon7569 {
    static int N, M, H;
    static int[][][] box;
    static int[][] dir = { { -1, 0, 0 }, { 1, 0, 0 }, { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 0, 0, 1 } };
    static boolean[][][] visited;
    static Queue<int[]> q;
    static int day;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[N][M][H];
        visited = new boolean[N][M][H];
        q = new LinkedList<>();
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        q.offer(new int[] { i, j, k, 0 });
                        visited[i][j][k] = true;
                    }
                }
                
            }
        }

        day = 0;
        bfs();
        if (!isComplete()) 
            day = -1;
        
        bw.write(day+"\n");
        bw.close();

    }
    
    public static void bfs() {
        while (!q.isEmpty()) {
            int[] t = q.poll();
            box[t[0]][t[1]][t[2]] = 1;
            day = Math.max(day, t[3]);

            for (int i = 0; i < dir.length; i++) {
                int dr = t[0] + dir[i][0];
                int dc = t[1] + dir[i][1];
                int dh = t[2] + dir[i][2];

                if (dr < 0 || dr >= N || dc < 0 || dc >= M || dh < 0 || dh >= H || visited[dr][dc][dh] || box[dr][dc][dh] == -1)
                    continue;

                q.offer(new int[] { dr, dc, dh, t[3] + 1 });
                visited[dr][dc][dh] = true;
            }
        }
    }
    
    public static boolean isComplete() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < H; k++) {
                    if (box[i][j][k] == 0)
                        return false;
                }
            }
        }
        return true;
    }
}

/*


*/
