package study.SWEA.winter_session_1.SWEA1865;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 동철이의 일 분배
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LuHfqDz8DFAXc
 */

public class SWEA1865 {
    static int N;
    static double[][] P;
    static double maxPercent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            N = Integer.parseInt(br.readLine());
            P = new double[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++)
                    P[i][j] = Double.parseDouble(st.nextToken()) / 100.0;
            }
            maxPercent = 0;
            combi(0, new boolean[N], new int[N], 1.0);
            maxPercent *= 100;

            bw.write(String.format("#%d %.6f", t, maxPercent));
            bw.newLine();
        }
        bw.close();
    }
    
    public static void combi(int cnt, boolean[] v, int[] p, double percent) {
        if (cnt == N) {
            maxPercent = Math.max(percent, maxPercent);
            return;
        }
        
        for (int i = 0; i < N; i++) {
            double nextPercent = percent * P[cnt][i];
            if (v[i] || nextPercent == 0.0 || nextPercent < maxPercent) 
                continue;
            
            p[cnt] = i;
            v[i] = true;
            combi(cnt + 1, v, p, nextPercent);
            v[i] = false;
        }
    }
}

/*
1
4
71 51 30 1
29 63 32 93
84 94 33 21
56 40 80 31

#1 49.654560

71 0
93 3
94 1
80 2



*/