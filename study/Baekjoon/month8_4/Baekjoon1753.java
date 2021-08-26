package study.Baekjoon.month8_4;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 최단경로
 * 링크 : https://www.acmicpc.net/problem/1753
 */

public class Baekjoon1753 {
    static class Edge implements Comparable<Edge>{
        public int nextVertex;
        public int weight;
        public Edge(int toVertex, int weight) {
            this.nextVertex = toVertex;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
        
        
    }

    static int V, E, K;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Edge>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        distance = new int[V+1];
        visited = new boolean[V+1];
        graph = new ArrayList[V+1];
        for (int i = 0; i < V+1; i++) {
            distance[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
        }

        dijkstra();
        
        for (int i = 1; i < V+1; i++) {
            if (distance[i] == Integer.MAX_VALUE) 
                bw.write("INF\n");
            else
                bw.write(distance[i]+"\n");
        }
        bw.close();
    }

    public static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(K, 0)); //시작지점 삽입
        distance[K] = 0;    //시작지점 가중치 0
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int curr = edge.nextVertex;
            if (visited[curr]) 
                continue;
            
            visited[curr] = true;
            for (Edge next : graph[curr]) {
                int nextWeight = distance[curr] + next.weight;
                if (distance[next.nextVertex] >= nextWeight) {
                    distance[next.nextVertex] = nextWeight;
                    pq.add(new Edge(next.nextVertex, nextWeight));
                }
            }
        }
    }
}

/*


*/
