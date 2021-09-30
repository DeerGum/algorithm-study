package study.SWEA.month9_4.SWEA6026;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 성수의 비밀번호 공격
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWajgCUaaAkDFAWM
 */

public class SWEA6026 {
    static int M, N; //N - 동생 비밀번호 자리, M - 키보드에 묻은 지문 갯수
    static final int P = 1000000007;
    static long[] fact;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            factorialInit();
            long total = solve();
            bw.write("#"+t+" "+total+"\n");
        }
        bw.close();
    }
    
    public static void factorialInit() {
        fact = new long[101];
        fact[0] = fact[1] = 1;
        for (int i = 2; i < fact.length; i++)
            fact[i] = (fact[i - 1] * i) % P;

    }
    
    // 함수의 개수 : ∑(-1)^i * kCi * (k-i)^n
    public static long solve() {
        long total = 0;
        for (int i = 0; i <= M; i++) {
            long l1 = i % 2 == 0 ? 1 : -1;
            long l2 = nCr(i);
            long l3 = power(M - i, N);
            long result = ((l1 * l2) % P * l3) % P;
            total = (total + result + P) % P;
        }
        return total;
    }

    // nCr = (n! / ((n-r)! * r!) ) % MOD = (n! * ((n-r)! * r!) ^ (mod-2) ) % MOD
    public static long nCr(int r) {
        if (r == 0)
            return 1;

        long l1 = fact[M];
        long l2 = power(fact[M-r], P-2);
        long l3 = power(fact[r], P-2);

        return ((l1 * l2) % P * l3) % P;
    }
    
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