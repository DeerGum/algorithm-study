package study.Baekjoon.month8_3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 색종이 만들기
 * 링크 : https://www.acmicpc.net/problem/
 */

public class Baekjoon2630 {
    static int N;
    static int[][] paper;
    static int W, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        W = 0;
        B = 0;
        color(0, 0, N);
        bw.write(W+"\n"+B+"\n");
        bw.close();

    }

    public static void color(int r, int c, int width) {
        if (width == 1 || sameColor(r,c,width)) {
            if (paper[r][c] == 0) {
                W++;
            } else if (paper[r][c] == 1) {
                B++;
            }
            return;
        }
        int w = width/2;
        color(r, c, w);
        color(r, c+w, w);
        color(r+w, c, w);
        color(r+w, c+w, w);
    }

    public static boolean sameColor(int r, int c, int width) {
        int color = paper[r][c];
        for (int i = r; i < r+width; i++) {
            for (int j = c; j < c+width; j++) {
                if (color != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

/*


*/
