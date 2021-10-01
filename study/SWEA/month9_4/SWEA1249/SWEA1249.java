package study.SWEA.month9_4.SWEA1249;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 보급로
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD&categoryId=AV15QRX6APsCFAYD&categoryType=CODE&problemTitle=1249&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA1249 {
    static int N;
    static int[][] map;
    static int[][] cost;
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            cost = new int[N][N];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }

            bfs();

            bw.write("#" + t + " " + cost[N - 1][N - 1] + "\n");
        }
        bw.close();
    }

    public static void bfs() {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.offer(new Pair(0, 0, map[0][0]));

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            if (curr.r == N - 1 && curr.c == N - 1)
                return;

            for (int i = 0; i < dir.length; i++) {
                int dr = curr.r + dir[i][0];
                int dc = curr.c + dir[i][1];
                int nextCost;

                if (dr < 0 || dr >= N || dc < 0 || dc >= N || (nextCost = curr.cost + map[dr][dc]) >= cost[dr][dc])
                    continue;

                cost[dr][dc] = nextCost;
                q.offer(new Pair(dr, dc, nextCost));
            }
        }

    }
}

class Pair implements Comparable<Pair>{
    int r;
    int c;
    int cost;

    public Pair(int r, int c, int cost) {
        this.r = r;
        this.c = c;
        this.cost = cost;
    }

    @Override
    public int compareTo(Pair o) {
        return this.cost - o.cost;
    }
    
}

/*


*/