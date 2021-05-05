package study.week3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 이항 계수1
 * 링크 : https://www.acmicpc.net/problem/11050
 * 알고리즘 분류
 * - 수학
 * - 구현
 * - 조합론
 */

public class Baekjoon11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, k;

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bw.write(combi(n,k)+"\n");
        bw.flush();
        
    }

    public static int combi(int n, int r) {
        
        if(r == n || r == 0) // n C 0 = n C n = 1
            return 1;
        
        return combi(n-1, r-1) + combi(n-1, r); //n+1 C r+1 = (n C r) + (n C r+1)
    }
}
