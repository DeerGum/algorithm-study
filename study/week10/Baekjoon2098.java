package study.week10;

import java.io.*;
import java.util.StringTokenizer;


/**
 * 문제이름 : 외판원 순회
 * 링크 : https://www.acmicpc.net/problem/2098
 * 알고리즘 분류
 * - DP
 * - 비트마스킹
 */

public class Baekjoon2098 {
    public static final int INF = Integer.MAX_VALUE - 1000000;
    public static int n;
    public static int[][] w;
    public static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        w = new int[n][n];
        dp = new int[n][1<<n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(tsp(0, 1) + "\n");
        bw.flush();
    }

    public static int tsp(int curr, int visited) {
        if(visited == (1 << n) - 1) {   //모든 도시 방문
            if(w[curr][0] == 0) // 0번 도시로 돌아갈 수 없는 경우
                return INF;
            return w[curr][0];
        }
        
        if(dp[curr][visited] != 0) // 방문한 적이 있는 경우
            return dp[curr][visited];

        int min = INF;
        for (int i = 0; i < n; i++) {
            if(w[curr][i] != 0 && (visited & (1 << i)) == 0) {  
                //curr에서 i까지 길이 있고 방문한 적 없으면
                int distance = tsp(i, visited | (1 << i)) + w[curr][i];
                min = Math.min(distance, min);
            }
        }
        return dp[curr][visited] = min;
    }
}

