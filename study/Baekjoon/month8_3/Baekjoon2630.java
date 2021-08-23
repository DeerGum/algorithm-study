package study.Baekjoon.month8_3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 색종이 만들기
 * 링크 : https://www.acmicpc.net/problem/2630
 */

public class Baekjoon2630 {
    static int N;
    static int[][] paper;
    static int W, B;    //흰색, 파란색 종이 갯수
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
        //기저조건 - 길이가 1이거나 범위안쪽이 같은 종이로만 구성되어있으면
        if (width == 1 || sameColor(r,c,width)) {   
            if (paper[r][c] == 0) {
                W++;
            } else if (paper[r][c] == 1) {
                B++;
            }
            return;
        }
        int w = width/2;
        color(r, c, w); //2사분면
        color(r, c+w, w);//1사분면
        color(r+w, c, w);//3사분면
        color(r+w, c+w, w);//4사분면
    }

    //색깔이 같은지 판별
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
