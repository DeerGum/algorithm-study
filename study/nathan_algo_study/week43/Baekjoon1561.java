package study.nathan_algo_study.week43;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 놀이 공원
 * 링크 : https://www.acmicpc.net/problem/1561
 */

public class Baekjoon1561 {
    static long N;
    static int M;
    static int[] times;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        times = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            times[i] = Integer.parseInt(st.nextToken());

        long start = 0;
        long end = 2000000000L * 30L;
        while (start <= end) {
            long mid = (start + end) / 2;

        }
    }
}

/*

*/
