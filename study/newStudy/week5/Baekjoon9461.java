// package study.newStudy.week5;

import java.io.*;

/**
 * 문제이름 : 파도반 수열
 * 링크 : https://www.acmicpc.net/problem/9461
 */

public class Baekjoon9461 {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        dpCal(dp);
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            
            bw.write(dp[n]+"\n");
        }
        bw.close();
    }

    public static void dpCal(long[] arr) {
        for (int i = 6; i < 101; i++) 
            arr[i] = arr[i-1] + arr[i-5];
        
    }
}

/*


*/
