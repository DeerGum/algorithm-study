package study.nathan_algo_study.week14;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 정렬
 * 링크 : https://www.acmicpc.net/problem/17074
 */

public class Baekjoon17074 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());



    }
}

/*

*/
