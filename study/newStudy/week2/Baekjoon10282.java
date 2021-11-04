package study.newStudy.week2;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 해킹
 * 링크 : https://www.acmicpc.net/problem/10282
 */

public class Baekjoon10282 {
    static int T, N, D, C;
    static ArrayList<Vertex>[] graph;
    static int[] dis;
    static final int INF = Integer.MAX_VALUE - 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N + 1];
            dis = new int[N + 1];
            for (int i = 0; i <= N; i++) {
                graph[i] = new ArrayList<>();
                dis[i] = INF;
            }

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                graph[b].add(new Vertex(a, s));
            }

            dijkstra();
            int max = 0;
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (dis[i] != INF) {
                    max = Math.max(max, dis[i]);
                    cnt++;
                }
            }
            bw.write(cnt + " " + max + "\n");
        }
        bw.close();
    }
    
    public static void dijkstra() {
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        boolean[] v = new boolean[N + 1];
        pq.add(new Vertex(C, 0));
        dis[C] = 0;

        while (!pq.isEmpty()) {
            Vertex vertex = pq.poll();
            int curr = vertex.nextVertex;

            if (v[curr]) 
                continue;
            
            v[curr] = true;
            for (Vertex next : graph[curr]) {
                if (dis[next.nextVertex] > dis[curr] + next.weight) {
                    dis[next.nextVertex] = dis[curr] + next.weight;
                    pq.add(new Vertex(next.nextVertex, dis[next.nextVertex]));
                }
            }
        }
    }
}

class Vertex implements Comparable<Vertex>{
    int nextVertex;
    int weight;

    public Vertex(int nextVertex, int weight) {
        this.nextVertex = nextVertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Vertex o) {
        return this.weight - o.weight;
    }
}

/*


*/
