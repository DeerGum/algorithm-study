package study.newStudy.week2;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 특정 거리의 도시 찾기 
 * 링크 : https://www.acmicpc.net/problem/18352
 */

public class Baekjoon18352 {
    static int N, M, K, X;
    static ArrayList<Node>[] graph;
    static int[] dis;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        dis = new int[N + 1];
        v = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dis[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, 1));
        }

        dijkstra();

        boolean isPrint = false;
        for (int i = 1; i <= N; i++) {
            if (dis[i] == K) {
                isPrint = true;
                bw.write(i + "\n");
            }
        }
        
        if (!isPrint) 
            bw.write(-1 + "\n");
        
        bw.close();

    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(X, 0));
        dis[X] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int curr = node.nextVertex;
            if (v[curr])
                continue;

            v[curr] = true;
            for (Node next : graph[curr]) {
                if (dis[next.nextVertex] >= dis[curr] + next.weight) {
                    dis[next.nextVertex] = dis[curr] + next.weight;
                    pq.add(new Node(next.nextVertex, dis[next.nextVertex]));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int nextVertex;
    int weight;

    public Node(int nextVertex, int weight) {
        this.nextVertex = nextVertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

/*


*/
