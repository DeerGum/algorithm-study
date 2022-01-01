// package study.newStudy.week4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제이름 : 서강그라운드
 * 링크 : https://www.acmicpc.net/problem/14938
 */

public class Baekjoon14938 {
    static int N, M, R;
    static int[] items;
    static int[][] dist;
    static final int INF = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        items = new int[N];
        dist = new int[N][N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dist[i], INF);
        }

        int a, b, l;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            l = Integer.parseInt(st.nextToken());

            dist[a][b] = l;
            dist[b][a] = l;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (k == i) 
                    continue;
                for (int j = 0; j < N; j++) {
                    if (i == j) 
                        continue;
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            int item = items[i];
            for (int j = 0; j < N; j++) {
                if (dist[i][j] <= M) {
                    item += items[j];
                }
            }
            max = Math.max(item, max);
        }

        bw.write(max+"\n");
        bw.close();

    }
}


/*


*/
