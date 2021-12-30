// package study.newStudy.week4;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : N과 M(3)
 * 링크 : https://www.acmicpc.net/problem/15651
 */

public class Baekjoon15651 {
    static int N;
    static int M;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        perm(0, new int[M]);
        
        bw.write(sb.toString());
        bw.close();
    }

    public static void perm(int cnt, int[] p) {
        if (cnt == M) {
            for (int i = 0; i < p.length; i++) 
                sb.append(p[i]+" ");
            
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            p[cnt] = i;
            perm(cnt+1, p);
        }
    }
}

/*


*/
