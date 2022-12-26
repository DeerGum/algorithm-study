package study.nathan_algo_study.week42;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제이름 : 도로포장
 * 링크 : https://www.acmicpc.net/problem/1162
 */

public class Baekjoon1162 {
    static int N, M, K;
    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(from, to, weight));
            graph[to].add(new Node(to, from, weight));
        }

        int[][] dist = new int[N+1][N+1];
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (i == k)
                    continue;
                for (int j = 0; j < N; j++) {
                    if (i == j)
                        continue;
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j])
                }
            }
        }
    }
}

class Node {
    int from;
    int to;
    int weight;

    public Node(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

/*

*/
