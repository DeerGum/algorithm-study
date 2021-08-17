package study.Baekjoon.month8_2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 색종이
 * 링크 : https://www.acmicpc.net/problem/2563
 */

public class Baekjoon2563 {
    static int[][] paper;
    static int len = 100;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        paper = new int[len][len];  //도화지 초기화
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            attach(r, c);   //색종이 붙이기
        }

        int result = count();   //색종이 붙은 공간 계산
        bw.write(result+"\n");
        bw.close();
        

    }

    public static void attach(int r, int c) {
        for (int i = r; i < r+10; i++) {
            for (int j = c; j < c+10; j++) {
                paper[i][j] = 1;
            }
        }
    }

    public static int count() {
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (paper[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

/*
10
10
7
10
7
2
10
10
5
10
5
2


*/
