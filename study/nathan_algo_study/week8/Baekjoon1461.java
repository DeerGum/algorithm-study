package study.nathan_algo_study.week8;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 도서관
 * 링크 : https://www.acmicpc.net/problem/
 */

public class Baekjoon1461 {
    static int N, M;
    static int[] books;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        books = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            books[i] = Integer.parseInt(st.nextToken());


    }
}

/*
-39 -37 -29 -28 -6 2 11

22
12
58
39

34 +


*/
