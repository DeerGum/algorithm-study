package study.Baekjoon.month8_2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 배열 돌리기 1
 * 링크 : https://www.acmicpc.net/problem/16926
 */

public class Baekjoon16926 {
    static int N, M, R;
    static int[][] map;
    static int[][] dir = { {1,0},{0,1},{-1,0},{0,-1} }; //하 우 상 좌
    static int startR, startC;
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

        rotation(R);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(map[i][j]+" ");
            }
            bw.newLine();
        }
        bw.close();
        
    }

    public static void rotation(int r) {
        int low = Math.min(N, M);
        int len = (low%2 == 1)?low/2+1:low/2;   // 그룹 갯수

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < len; j++) {
                startR = j;
                startC = j;
                int n = N - 2*j;
                int m = M - 2*j;
                if( n == 1 || m == 1) //그룹이 1줄일 경우
                    rotation(j, M-j-1, 3, j, map[j][j]);   
                else    //일반적인 경우
                    rotation(j+1, j, 0, j, map[j][j]);    
            }
        }
    }

    private static void rotation(int r, int c, int d, int depth, int prev) {
        int curr = map[r][c];
        map[r][c] = prev;

        if (r == startR && c == startC) 
            return;

        int R = r + dir[d][0];
        int C = c + dir[d][1];

        if (R < depth || R >= N-depth || C < depth || C >= M-depth) {   //범위 벗어나면
            d = (d+1)%4;    //방향전환
            R = r + dir[d][0];
            C = c + dir[d][1];
        }

        rotation(R, C, d, depth, curr);
    }
}

/*
4 4 1
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

2 3 4 8
1 7 11 12
5 6 10 16
9 13 14 15 

3 4 1
1 2 3 4
5 6 7 8
9 10 11 12
*/
