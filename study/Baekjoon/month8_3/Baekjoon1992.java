package study.Baekjoon.month8_3;

import java.io.*;

/**
 * 문제이름 : 쿼드트리
 * 링크 : https://www.acmicpc.net/problem/1992
 */

public class Baekjoon1992 {
    static int N;
    static int[][] video;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        video = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                video[i][j] = str.charAt(j) - '0';
            }
        }

        sb = new StringBuilder();   //결과를 저장할 StringBuilder
        quadTree(0, 0, N);
        bw.write(sb.toString());
        bw.flush();

    }

    public static void quadTree(int r, int c, int width) {
        if (width == 1 || sameCheck(r, c, width)) { //범위가 모두 같으면
            sb.append(video[r][c]); //압축
            return;
        }

        sb.append("(");
        int w = width/2;
        quadTree(r, c, w);      //2사분면
        quadTree(r, c+w, w);    //1사분면
        quadTree(r+w, c, w);    //3사분면
        quadTree(r+w, c+w, w);  //4사분면
        sb.append(")");
    }

    public static boolean sameCheck(int r, int c , int width) { //범위안의 숫자가 모두 같으면
        int same = video[r][c];
        for (int i = r; i < r+width; i++) {
            for (int j = c; j < c+width; j++) {
                if (video[i][j] != same) {
                    return false;
                }
            }
        }
        return true;
    }
}

/*


*/
