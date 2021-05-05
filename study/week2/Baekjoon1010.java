package study.week2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 다리 놓기
 * 링크 : https://www.acmicpc.net/problem/1010
 * 알고리즘 분류
 * - 수학
 * - DP
 * - 조합론
 */

public class Baekjoon1010 {
    public static int dp[][] = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int n, m;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            bw.write(combi(m, n)+"\n");
        }
        bw.flush();
        
    }

    public static int combi(int n, int r) {
        if(dp[n][r] > 0)
            return dp[n][r];

        if(n == r || r == 0)
            return dp[n][r] = 1;

        return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
}