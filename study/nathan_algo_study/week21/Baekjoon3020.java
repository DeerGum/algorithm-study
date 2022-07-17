package study.nathan_algo_study.week21;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 개똥벌레
 * 링크 : https://www.acmicpc.net/problem/3020
 */

public class Baekjoon3020 {
    static int N, H;
    static int[] obstacles;
    static int[] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        obstacles = new int[N];
        prefixSum = new int[H];
        for (int i = 0; i < N; i++) {
            obstacles[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                addSum(obstacles[i], true);
            } else {
                addSum(obstacles[i], false);
            }
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            if (min > prefixSum[i]) {
                min = prefixSum[i];
                cnt = 1;
            } else {
                cnt++;
            }
        }

        System.out.println(min + " " + cnt);

    }

    public static void addSum(int num, boolean isUp) {
        if (isUp) {
            for (int i = H - 1; i > H - 1 - num; i--) {
                prefixSum[i]++;
            }
        } else {
            for (int i = 0; i < num; i++) {
                prefixSum[i]++;
            }
        }
    }
}

/*

 */
