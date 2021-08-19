package study.Baekjoon.month8_3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 도영이가 만든 맛있는 음식
 * 링크 : https://www.acmicpc.net/problem/2961
 */

public class Baekjoon2961 {
    static int N;
    static int[][] foods;
    static int minTaste;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        foods = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            foods[i][0] = Integer.parseInt(st.nextToken());
            foods[i][1] = Integer.parseInt(st.nextToken());
        }
        
        minTaste = Integer.MAX_VALUE;
        // cook(0, new boolean[N]);
        cook2(0, 1, 0);
        bw.write(minTaste+"\n");
        bw.flush();

    }

    public static void cook(int cnt, boolean[] v) {
        if (cnt == N) {
            int s = 1;
            int b = 0;
            boolean isEmpty = true;
            for (int i = 0; i < N; i++) {
                if (v[i]) {
                    isEmpty = false;
                    s *= foods[i][0];
                    b += foods[i][1];
                }
            }
            if (!isEmpty)
                minTaste = Math.min(minTaste, (int)Math.abs(s-b));
            return;
        }

        v[cnt] = true;
        cook(cnt+1, v);

        v[cnt] = false;
        cook(cnt+1, v);

    }

    public static void cook2(int cnt, int s, int b) {
        if (cnt == N) {
            if (s == 1 || b == 0) 
                return;
    
            minTaste = Math.min(minTaste, (int)Math.abs(s-b));
            return;
        }

        cook2(cnt+1, s, b);
        cook2(cnt+1, s*foods[cnt][0], b+foods[cnt][1]);
    }
}

/*


*/
