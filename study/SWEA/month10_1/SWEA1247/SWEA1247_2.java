package study.SWEA.month10_1.SWEA1247;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 최적 경로
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD&categoryId=AV15OZ4qAPICFAYD&categoryType=CODE&problemTitle=%EC%B5%9C%EC%A0%81&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&
 */

public class SWEA1247_2 {
    static int N;
    static int[][] pos;
    static int[] home;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            pos = new int[N + 1][2];    //회사 + 고객 좌표
            home = new int[2];          //집 좌표
            dp = new int[N + 2][1 << N + 2];    // 

            pos[0][0] = Integer.parseInt(st.nextToken());   //회사 좌표
            pos[0][1] = Integer.parseInt(st.nextToken());

            home[0] = Integer.parseInt(st.nextToken());     //집 좌표
            home[1] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= N; i++) {  //고객 좌표
                pos[i][0] = Integer.parseInt(st.nextToken());
                pos[i][1] = Integer.parseInt(st.nextToken());
            }

            bw.write("#" + t + " " + tsp(0, 1) + "\n");
        }
        bw.close();
    }

    public static int tsp(int curr, int visited) {
        if (visited == (1 << N + 1) - 1) // 회사, 고객 모두 방문했으면
            return distance(pos[curr], home);
        
        if (dp[curr][visited] != 0) 
            return dp[curr][visited];
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N + 1; i++) {
            int cost = distance(pos[curr], pos[i]);
            if (cost != 0 && (visited & (1 << i)) == 0) {
                int dist = tsp(i, visited | (1 << i)) + cost;
                min = Math.min(min, dist);
            }
        }
        return dp[curr][visited] = min;
    }
    
    public static int distance(int[] a, int[] b) {  //거리 계산
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}

/*
2
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20
6
88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14

MIPS

*/