package study.Baekjoon.month9_3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 토마토
 * 링크 : https://www.acmicpc.net/problem/7576
 */

public class Baekjoon7576 {
    static int N, M;
    static int[][] box;
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static boolean[][] visited;
    static Queue<int[]> q;
    static int day;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        visited = new boolean[N][M];
        q = new LinkedList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    q.offer(new int[] { i, j, 0 }); //익은 토마토 큐에 넣음
                    visited[i][j] = true;
                }
            }
        }

        day = 0;    //토마토 익히는데 걸리는 날짜
        bfs();  //토마토 익힘
        if (!isComplete()) //모두 익지 않았으면
            day = -1;
        
        bw.write(day+"\n");
        bw.close();

    }
    
    public static void bfs() {
        while (!q.isEmpty()) {
            int[] t = q.poll();
            box[t[0]][t[1]] = 1;
            day = Math.max(day, t[2]);

            for (int i = 0; i < dir.length; i++) {
                int dr = t[0] + dir[i][0];
                int dc = t[1] + dir[i][1];

                if (dr < 0 || dr >= N || dc < 0 || dc >= M || visited[dr][dc] || box[dr][dc] == -1)
                    continue;

                q.offer(new int[] { dr, dc, t[2] + 1 });
                visited[dr][dc] = true;
            }
        }
    }
    
    public static boolean isComplete() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
}

/*


*/
