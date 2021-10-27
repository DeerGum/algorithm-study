package study.old.week11;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 최대공약수와 최소공배수
 * 링크 : https://www.acmicpc.net/problem/2609
 * 알고리즘 분류
 * - 수학
 * - 정수론
 * - 유클리드 호제법
 */

public class Baekjoon2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int gcd = gcd(a, b);
        bw.write(gcd+"\n"+(a*b/gcd));
        bw.flush();
    }

    public static int gcd(int a, int b) {
        if(b == 0) 
            return a;
        else 
            return gcd(b, a%b);
    }
}
