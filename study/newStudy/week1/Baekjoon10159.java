package study.newStudy.week1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 저울
 * 링크 : https://www.acmicpc.net/problem/10159
 */

public class Baekjoon10159 {
    static int N, M;
    static int[][] w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        w = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int big = Integer.parseInt(st.nextToken());
            int small = Integer.parseInt(st.nextToken());

            w[big][small] = 1;
            w[small][big] = -1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (i == k)
                    continue;
                for (int j = 1; j <= N; j++) {
                    if (j == i || j == k)
                        continue;

                    if (w[i][k] + w[k][j] > 1)
                        w[i][j] = 1;
                    else if (w[i][k] + w[k][j] < -1)
                        w[i][j] = -1;
                }
            }
        }
        
        int cnt;
        for (int i = 1; i <= N; i++) {
            cnt = 0;
            for (int j = 1; j <= N; j++) {
                if (i != j && w[i][j] == 0)
                    cnt++;
            }
            bw.write(cnt+"\n");
        }
        bw.close();

    }
}

/*


*/
