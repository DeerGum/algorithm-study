package study.newStudy.week1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제이름 : 운동 
 * 링크 : https://www.acmicpc.net/problem/1956
 */

public class Baekjoon1956 {
    static int V, E;
    static int[][] dist;
    static final int INF = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[V + 1][V + 1];
        for (int[] d : dist)
            Arrays.fill(d, INF);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            dist[from][to] = cost;
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                if (i == k)
                    continue;
                for (int j = 1; j <= V; j++) {
                    if (j == i || j == k)
                        continue;

                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }
        
        int min = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= i; j++) {
                min = Math.min(dist[i][j] + dist[j][i], min);
            }
        }
        if (min == INF) 
            bw.write("-1\n");
        else
            bw.write(min+"\n");
        bw.close();
    }
}

/*


*/
