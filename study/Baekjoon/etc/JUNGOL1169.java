package study.Baekjoon.etc;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 주사위 던지기
 * 링크 : http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=449&sca=2080
 */

public class JUNGOL1169 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (M == 1) {
            m1(0, new int[N]);
        }else if (M == 2) {
            m2(0, 1, new int[N]);
        } else {
            m3(0, new int[N], new boolean[7]);
        }

    }
    
    public static void m1(int cnt, int[] p) {
        if (cnt == N) {
            for (int i = 0; i < p.length; i++)
                System.out.print(p[i]+" ");
            System.out.println();

            return;
        }
        
        for (int i = 1; i <= 6; i++) {
            p[cnt] = i;
            m1(cnt+1, p);
        }
    }
    public static void m2(int cnt, int start, int[] p) {
        if (cnt == N) {
            for (int i = 0; i < p.length; i++)
                System.out.print(p[i]+" ");
            System.out.println();

            return;
        }
        
        for (int i = start; i <= 6; i++) {
            p[cnt] = i;
            m2(cnt+1, i, p);
        }
        
    }
    public static void m3(int cnt, int[] p, boolean[] v) {
        if (cnt == N) {
            for (int i = 0; i < p.length; i++)
                System.out.print(p[i]+" ");
            System.out.println();

            return;
        }
        
        for (int i = 1; i <= 6; i++) {
            if(v[i])
                continue;
            p[cnt] = i;
            v[i] = true;
            m3(cnt + 1, p, v);
            v[i] = false;
        }
        
    }
}

/*

*/
