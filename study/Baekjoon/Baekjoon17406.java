package study.Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 배열 돌리기 4
 * 링크 : https://www.acmicpc.net/problem/17406
 */

public class Baekjoon17406 {
    static int N, M, K;
    static int[][] map;
    static int[][] temp;
    static int[][] dir = { {0,1},{1,0},{0,-1},{-1,0} }; //우 하 좌 상
    static int[][] cal;
    static int resultMin;
    static int startR, startC;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cal = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            cal[i][0] = Integer.parseInt(st.nextToken())-1;
            cal[i][1] = Integer.parseInt(st.nextToken())-1;
            cal[i][2] = Integer.parseInt(st.nextToken());
        }

        resultMin = Integer.MAX_VALUE;

        cases(0, new int[K], new boolean[K]);

        bw.write(resultMin+"\n");
        bw.close();

    }

    public static void cases(int cnt, int[] p, boolean[] v) {
        if (cnt == K) {
            arrInit(temp);  //배열 초기화
            for (int i = 0; i < K; i++) //경우의 수에 따라 회전
                rotation(cal[p[i]][0], cal[p[i]][1], cal[p[i]][2]);
            
            resultMin = Math.min(resultMin, min(temp));
            return;
        }

        for (int i = 0; i < K; i++) {
            if (v[i]) 
                continue;
            
            v[i] = true;
            p[cnt] = i;
            cases(cnt+1, p, v);
            v[i] = false;
        }
    }

    public static void rotation(int r, int c, int s) {
        for (int R = r-s,C = c-s, depth = 0; R < r; R++, C++, depth++) {
            startR = R;
            startC = C;
            rotation(R, C+1, 0, 2*(s-depth)+1, temp[R][C]);
        }
    }

    private static void rotation(int r, int c, int d, int len, int prev) {
        int curr = temp[r][c];
        temp[r][c] = prev;

        if (startR == r && startC == c) 
            return;
        
        int R = r + dir[d][0];
        int C = c + dir[d][1];

        if (R < startR || R >= startR+len || C < startC || C >= startC+len) {
            d = (d+1)%4;
            R = r + dir[d][0];
            C = c + dir[d][1];
        }

        rotation(R, C, d, len, curr);
    }

    public static void arrInit(int[][] arr) {
        for (int i = 0; i < map.length; i++) 
            System.arraycopy(map[i], 0, arr[i], 0, map[i].length);
    }

    public static int min(int[][] arr) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++)
                sum += arr[i][j];
            result = Math.min(result, sum);
        }
        return result;
    }
}

/*
5 6 1
1 2 3 2 5 6
3 8 7 2 1 3
8 2 3 1 4 5
3 4 5 1 1 1
9 3 2 1 4 3
3 4 2


*/
