package study.Baekjoon.month9_2;

import java.io.*;

/**
 * 문제이름 : 1로 만들기
 * 링크 : https://www.acmicpc.net/problem/1463
 */

public class Baekjoon1463 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());

        dp = new int[x + 1];
        bottomUp(x);

        bw.write(dp[x] + "\n");
        bw.close();
    }
    
    public static void bottomUp(int x) {
        for (int i = 2; i < x + 1; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);

            if (i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);

        }
    }

    public static int topDown(int x) {
        if (x == 1) 
            return 0;
        
        if (dp[x] > 0) 
            return dp[x];
        
        if (x % 3 == 0) 
            dp[x] = Math.min(dp[x], dp[x / 3] + 1);
        
        if (x % 2 == 0) 
            dp[x] = Math.min(dp[x], dp[x / 2] + 1);
        
        return dp[x];
    }
}

/*




*/
