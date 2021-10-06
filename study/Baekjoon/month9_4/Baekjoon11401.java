package study.Baekjoon.month9_4;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 이항 계수 3
 * 링크 : https://www.acmicpc.net/problem/11401
 */

public class Baekjoon11401 {
    static final int P = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());
        long k = Integer.parseInt(st.nextToken());

        bw.write(nCr(n, k) + "\n");
        bw.close();

    }

    public static long fact(long n) {
        long re = 1L;
        for (int i = 1; i <= n; i++) {
            re *= i;
            re %= P;
        }
        return re % P;
    }

    //페르마 소정리
    public static long nCr(long n, long k) {
        long re = 1L;
        re *= fact(n);
        re %= P;
        re *= power(fact(n - k), P - 2);
        re %= P;
        re *= power(fact(k), P - 2);
        re %= P;
        return re;
    }
    
    //divide and conquer
    static long power(long x, long y) {
        long re = 1L;
        while (y > 0) {
            if (y % 2 == 1) {
                re *= x;
                re %= P;
            }
            x *= x;
            x %= P;
            y /= 2;
        }
        return re % P;
    }
}

/*


*/
