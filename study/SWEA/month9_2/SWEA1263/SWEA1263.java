package study.SWEA.month9_2.SWEA1263;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 사람 네트워크2
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18P2B6Iu8CFAZN
 * 플로이드 와샬 알고리즘 사용
 */

public class SWEA1263 {
    static int N;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            dp = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dp[i][j] = Integer.parseInt(st.nextToken());
                    if (i != j && dp[i][j] == 0) {
                        dp[i][j] = 1000001;
                    }
                }
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    if (i == k)
                        continue;
                    for (int j = 0; j < N; j++) {
                        if (j == i || j == k)
                            continue;

                        dp[i][j] = Math.min(dp[i][k] + dp[k][j], dp[i][j]);
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < N; j++)
                    sum += dp[i][j];

                min = Math.min(min, sum);
            }

            bw.write("#" + t + " " + min + "\n");
        }
        bw.close();

    }
}

/*
1
5 0 1 1 0 0 1 0 1 1 1 1 1 0 0 0 0 1 0 0 0 0 1 0 0 0

*/