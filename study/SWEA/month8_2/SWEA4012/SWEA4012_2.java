package study.SWEA.month8_2.SWEA4012;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 문제이름 : 요리사
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH
 * 느린코드
 */

public class SWEA4012_2 {
    static int[][] table;
    static int N, R;
    static LinkedList<int[]> combi;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            N = Integer.parseInt(br.readLine());
            table = new int[N+1][N+1];
            for (int i = 1; i < N+1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < N+1; j++) 
                    table[i][j] = Integer.parseInt(st.nextToken());
            }
            R = N/2;
            result = Integer.MAX_VALUE;
             
            select(1, 0, new boolean[N+1], new int[R]);
 
            bw.write("#"+t+" "+result+"\n");
        }
        bw.flush();
    }
 
    // p는 0부터 시작
    public static void select(int start, int cnt, boolean[] v, int[] p) {
        if (cnt == R) {
            cook(v, p);
            return;
        }
 
        for (int i = start; i < N+1; i++) {
            if (v[i]) 
                continue;
             
            v[i] = true;
            p[cnt] = i;
            select(i+1, cnt+1, v, p);
            v[i] = false;
        }
    }
 
    public static void cook(boolean[] v, int[] p1) {
        int[] p2 = new int[R];
        for (int i = 0, idx = 1; i < N/2; idx++) {
            if (!v[idx]) 
                p2[i++] = idx;
        }
 
        int p1Sum = 0;
        int p2Sum = 0;
 
        combi = new LinkedList<>();
        cookCombi(0, 0, new boolean[R], new int[2], p1);
        while (!combi.isEmpty()) {
            int[] item = combi.poll();
            p1Sum += table[item[0]][item[1]] + table[item[1]][item[0]];
        }
 
        cookCombi(0, 0, new boolean[R], new int[2], p2);
        while (!combi.isEmpty()) {
            int[] item = combi.poll();
            p2Sum += table[item[0]][item[1]] + table[item[1]][item[0]];
        }
 
        result = Math.min(result, (int)Math.abs(p1Sum - p2Sum));
    }
 
    public static void cookCombi(int start, int cnt, boolean[] v, int[] p, int [] num) {
        if (cnt == 2) {
            int[] temp = {p[0], p[1]};
            combi.offer(temp);
            return;
        }
 
        for (int i = start; i < R; i++) {
            if (v[i]) 
                continue;
             
            v[i] = true;
            p[cnt] = num[i];
            cookCombi(i+1, cnt+1, v, p, num);
            v[i] = false;
        }
    }
}

/*
a b c

ab ac bc 

d e f

4
4
0 5 3 8
4 0 4 1
2 5 0 3
7 2 3 0
4
0 7 1 1
7 0 6 2
1 1 0 2
10 1 9 0
6
0 37 26 52 77 20
32 0 15 26 75 16
54 33 0 79 37 90
92 10 66 0 92 3
64 7 89 89 0 21
80 49 94 68 5 0
6
0 73 30 81 27 94
98 0 91 9 97 24
51 100 0 35 41 98
26 26 96 0 26 90
73 37 39 57 0 16
90 88 97 9 95 0

*/