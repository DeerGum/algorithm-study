package study.newStudy.week1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제이름 : 플로이드 
 * 링크 : https://www.acmicpc.net/problem/11404
 */

public class Baekjoon11404 {
    static final int INF = 1000000;
    static int N, M;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N + 1][N + 1];
        for (int[] d : dist) 
            Arrays.fill(d, INF);
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            dist[from][to] = Math.min(dist[from][to], cost);

        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (i == k)
                    continue;
                for (int j = 1; j <= N; j++) {
                    if (i == j || k == j)
                        continue;

                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] == INF)
                    bw.write("0 ");
                else
                    bw.write(dist[i][j] + " ");
            }
            bw.newLine();
        }
        bw.close();
    }
}

/*


*/
