package study.nathan_algo_study.week19;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 
 * 링크 : https://www.acmicpc.net/problem/
 */

public class Baekjoon1941 {
    static final int N = 5;
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        arr = new char[N][];
        for (int i = 0; i < N; i++)
            arr[i] = br.readLine().toCharArray();



    }
}

/*
25C7 = 25! / 18! * 7!

25 24 23 22 21 20 19
7 6 5 4 3 2

25 4 23 22 21 20 19
7 5 4 3 2

25 4 23 22 3 20 19
5 4 3 2

5 4 23 22 3 20 19
4 3 2

5 23 22 3 10 19
3

5 23 22 10 19



*/
