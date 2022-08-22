package study.nathan_algo_study.week26;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 겹치는 건 싫어
 * 링크 : https://www.acmicpc.net/problem/20922
 */

public class Baekjoon20922 {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


    }

    public static int solution() {


        return 0;
    }
}

/*
0 0
1 0
2 1
3 1
4 2
5 3
6 1
7 1
8 0
9 0






*/
