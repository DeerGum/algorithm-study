package study.nathan_algo_study.week20;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : Moo 게임
 * 링크 : https://www.acmicpc.net/problem/5904
 */

public class Baekjoon5904 {
    static int N;
    static StringBuilder moo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        moo = new StringBuilder("moo");


    }

    public static void createMoo() {

    }
}

/*

S(k) = S(k-1) + "m" + ("o" x (k+2)) + S(k-1)
1000000000


0 moo
1 moo mooo moo
2 moomooomoo moooo moomooomoo
3 moomooomoomoooomoomooomoo mooooo moomooomoomoooomoomooomoo

*/
