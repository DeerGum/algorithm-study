package study.Baekjoon.month9_4;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 녹색 옷 입은 애가 젤다지?
 * 링크 : https://www.acmicpc.net/problem/4485
 */

public class Baekjoon4485 {
    static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }; // 하 우 상 좌
    static int N;
    static int[][] cave;
    static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = 1;
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            cave = new int[N][N];
            cost = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }

            bfs();
            bw.write("Problem " + (t++) + ": " + cost[N - 1][N - 1] + "\n");
        }
        bw.close();
    }

    public static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node( 0, 0, cave[0][0]));
        cost[0][0] = cave[0][0];

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.r == N - 1 && curr.c == N - 1) 
                return;

            for (int i = 0; i < dir.length; i++) {
                int dr = curr.r + dir[i][0];
                int dc = curr.c + dir[i][1];
                int nextCost;
                if (dr < 0 || dr >= N || dc < 0 || dc >= N || (nextCost = curr.cost + cave[dr][dc]) >= cost[dr][dc])
                    continue;

                cost[dr][dc] = nextCost;
                pq.offer(new Node(dr, dc, nextCost));
            }
        }
    }
}

class Node implements Comparable<Node> {
    int r;
    int c;
    int cost; //누적 비용

    public Node(int r, int c, int cost) {
        this.r = r;
        this.c = c;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

/*
3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4
0

1
5 5 1
3 9 1
3 2 7
0
*/
