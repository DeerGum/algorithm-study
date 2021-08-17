package study.Baekjoon.month8_2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 배열 돌리기 3
 * 링크 : https://www.acmicpc.net/problem/16935
 */

public class Baekjoon16935 {
    static int N, M, R;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) 
            calculate(Integer.parseInt(st.nextToken()));

        bw.write(toStringArr().toString());
        bw.close();
    }

    public static void calculate(int cmd) {
        switch(cmd) {
            case 1:
                reverseTopBottom();
                break;
            case 2:
                reverseLeftRight();
                break;
            case 3:
                rotateRight90();
                break;
            case 4:
                rotateLeft90();
                break;
            case 5:
                rotateClockwise();
                break;
            case 6:
                rotateCounterClockwise();
        }
    }

    public static void reverseTopBottom() {
        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M; j++) {
                int temp = map[N-i-1][j];
                map[N-i-1][j] = map[i][j];
                map[i][j] = temp;
            }
        }
    }

    public static void reverseLeftRight() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M/2; j++) {
                int temp = map[i][M-j-1];
                map[i][M-j-1] = map[i][j];
                map[i][j] = temp;
            }
        }
    }

    public static void rotateRight90() {
        int[][] result = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = map[N-j-1][i];
            }
        }
        int T = M;
        M = N;
        N = T;
        map = result;
    }

    public static void rotateLeft90() {
        int[][] result = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = map[j][M-i-1];
            }
        }
        int T = M;
        M = N;
        N = T;
        map = result;
    }

    public static void rotateClockwise() {
        int[][] m1, m2, m3, m4;
        m1 = new int[N/2][M/2];
        m2 = new int[N/2][M/2];
        m3 = new int[N/2][M/2];
        m4 = new int[N/2][M/2];

        getArr(m1, m2, m3, m4);

        setArr(m3, m1, m4, m2); //시계방향으로 회전
    }

    public static void rotateCounterClockwise() {
        int[][] m1, m2, m3, m4;
        m1 = new int[N/2][M/2];
        m2 = new int[N/2][M/2];
        m3 = new int[N/2][M/2];
        m4 = new int[N/2][M/2];

        getArr(m1, m2, m3, m4);

        setArr(m2, m4, m1, m3); //반시계방향으로 회전
    }

    public static void getArr(int[][] m1, int[][] m2, int[][] m3, int[][] m4) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i < N/2) {
                    if (j < M/2) 
                        m1[i][j] = map[i][j];
                    else
                        m2[i][j-M/2] = map[i][j];
                } else {
                    if (j < M/2) 
                        m3[i-N/2][j] = map[i][j];
                    else
                        m4[i-N/2][j-M/2] = map[i][j];
                }
            }
        }
    }

    public static void setArr(int[][] m1, int[][] m2, int[][] m3, int[][] m4) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i < N/2) {
                    if (j < M/2) 
                        map[i][j] = m1[i][j];
                    else
                        map[i][j] = m2[i][j-M/2];
                } else {
                    if (j < M/2) 
                        map[i][j] = m3[i-N/2][j];
                    else
                        map[i][j] = m4[i-N/2][j-M/2];
                }
            }
        }
    }

    public static StringBuilder toStringArr() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }
        return sb;
    }


}

/*
1 2
3 4

3 1
4 2

2 4
1 3

*/
