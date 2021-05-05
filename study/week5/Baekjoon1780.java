package study.week5;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 종이의 개수
 * 링크 : https://www.acmicpc.net/problem/1780
 * 알고리즘 분류
 * - 분할정복
 * - 재귀
 */

public class Baekjoon1780 {
    public static int[] paperCount;
    public static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        paperCount = new int[3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) 
                paper[i][j] = Integer.parseInt(st.nextToken());
        }

        cutting(0, 0, n);

        for (int i = 0; i < paperCount.length; i++) 
            bw.write(paperCount[i]+"\n");
        bw.flush();
    }

    public static void cutting(int r, int c, int n) {
        if(n < 1)
            return;
        
        if(isEqual(r, c, n)) {
            int paperNum = paper[r][c];
            switch(paperNum) {
                case -1: 
                    paperCount[0]++;
                    break;
                case 0 : 
                    paperCount[1]++;
                    break;
                case 1 : 
                    paperCount[2]++;
                    break;
            }
        }
        else {
            int m = n/3;
            for (int i = 0; i < 3; i++) 
                for (int j = 0; j < 3; j++) 
                    cutting(r+i*m, c+j*m, m);
                
        }
    }

    public static boolean isEqual(int r, int c, int n) {
        int paperNum = paper[r][c];
        for (int i = r; i < r+n; i++) {
            for (int j = c; j < c+n; j++) {
                if(paper[i][j] != paperNum) {
                    return false;
                }
            }
        }
        return true;
    }
}

/*
1 4
2 3
3 2
4 1
5 5


 */