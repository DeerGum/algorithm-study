package study.Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 오목
 * 링크 : https://www.acmicpc.net/problem/2615
 * 알고리즘 분류
 * - 수학
 * - 비트마스킹
 */

public class Baekjoon2615 {
    public static final int N = 19;
	public static int x, y, winner;
	public static int[][] board;
    public static int[][][] memo;
	public static int[][] dir = {{-1,1},{0,1},{1,0},{1,1}};	//우상, 우, 하, 우하 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 구현하세요.
		StringTokenizer st;
		board = new int[N][N];
		memo = new int[N][N][4];
 
		for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) 
				board[i][j] = Integer.parseInt(st.nextToken());
        }
			
		
	}

}

/*

0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0

*/