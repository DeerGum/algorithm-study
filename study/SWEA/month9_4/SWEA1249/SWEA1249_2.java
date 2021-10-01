package study.SWEA.month9_4.SWEA1249;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 보급로
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD&categoryId=AV15QRX6APsCFAYD&categoryType=CODE&problemTitle=1249&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA1249_2 {
    static int N;
    static int[][] map;
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }

            bw.write("#" + t + " " + dijkstra(0, 0) + "\n");
        }
        bw.close();
    }

    public static int dijkstra(int startR, int startC) {
        boolean[][] visited = new boolean[N][N];
        int[][] minTime = new int[N][N];

        //최소값이 갱신되도록 큰값으로 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                minTime[i][j] = INF;
        }

        minTime[startR][startC] = 0;
        int r = 0, c = 0;
        int dr = 0, dc = 0;
        int minCost = 0;

        while (true) {
            //step1
            minCost = INF;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && minCost > minTime[i][j]) {
                        minCost = minTime[i][j];
                        r = i;
                        c = j;
                    }
                }
            }

            visited[r][c] = true;
            if (r == N - 1 && c == N - 1)
                return minCost;

            // step2 : 1에서 선택된 정점을 경유지로 해서 인접정점 따져보기
            // 이 문제에서는 인접정점이 4방 정점
            for (int d = 0; d < dir.length; d++) {
                dr = r + dir[d][0];
                dc = c + dir[d][1];

                if (dr < 0 || dr >= N || dc < 0 || dc >= N || visited[dr][dc]
                        || minTime[dr][dc] <= minCost + map[dr][dc])
                    continue;

                minTime[dr][dc] = minCost + map[dr][dc];

            }

        }

    }
}

/*
1
4
0100
1110
1011
1010

*/