package study.nathan_algo_study.week9;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 파일 합치기
 * 링크 : https://www.acmicpc.net/problem/11066
 */

public class Baekjoon11066 {
    static int[][] dp;
    static int K;
    static int[] files;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            files = new int[K];
            for (int j = 0; j < K; j++)
                files[j] = Integer.parseInt(st.nextToken());

            dp = new int[K][K];
            
        }
    }
}

/*

40 30 30 50

60 100 150 = 310

60 90 150 = 300


1 21 3 4 5 35 5 4 3 5 98 21 14 17 32



*/
