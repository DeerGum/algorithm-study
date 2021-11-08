package study.newStudy.week2;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 최소비용 구하기
 * 링크 : https://www.acmicpc.net/problem/1916
 */

public class Baekjoon1916 {
    static class Node implements Comparable<Node> {
        int nextNode;
        int weight;
        public Node(int nextNode, int weight) {
            this.nextNode = nextNode;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    
    static int[] dist;
    static ArrayList<Node>[] graph;
    static int N, M, start, finish;
    static final int INF = Integer.MAX_VALUE - 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dist = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, weight));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        finish = Integer.parseInt(st.nextToken());

        dijkstra();

        bw.write(dist[finish] + "\n");
        bw.close();

    }
    
    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] v = new boolean[N + 1];
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int curr = node.nextNode;

            if (v[curr]) 
                continue;
            
            v[curr] = true;
            for (Node next : graph[curr]) {
                if (dist[next.nextNode] > dist[curr] + next.weight) {
                    dist[next.nextNode] = dist[curr] + next.weight;
                    pq.add(new Node(next.nextNode, dist[next.nextNode]));
                }
            }
        }
    }
}



/*


*/
