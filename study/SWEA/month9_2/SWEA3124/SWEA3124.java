package study.SWEA.month9_2.SWEA3124;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 최소 스패닝 트리
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV_mSnmKUckDFAWb&categoryId=AV_mSnmKUckDFAWb&categoryType=CODE&problemTitle=%EC%8A%A4%ED%8C%A8%EB%8B%9D&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA3124 {
    static ArrayList<Edge>[] tree;
    static int V, E;
    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            tree = new ArrayList[V + 1];
            for (int i = 0; i < V + 1; i++)
                tree[i] = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                long w = Long.parseLong(st.nextToken());

                tree[a].add(new Edge(b, w));
                tree[b].add(new Edge(a, w));
            }

            result = 0;
            prim(1);
            bw.write("#" + t + " " + result + "\n");
        }
        bw.close();

    }
    
    public static void prim(int startNode) {
        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>(); //방문할 수 있는 정점
        Queue<Integer> q = new LinkedList<>();  //방문한 정점

        q.offer(startNode);
        visited[startNode] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();

            for (Edge e : tree[curr]) { //현재 정점과 연결된 방문하지 않은 정점을 우선순위 큐에 저장
                if (visited[e.to])
                    continue;
                pq.add(e);
            }
            
            while (!pq.isEmpty()) {
                Edge item = pq.poll();  //연결된 정점 중에 가장 작은 가중치를 가진 요소를 꺼냄
                if (!visited[item.to]) {    //방문한 정점이 아니면
                    result += item.weight;
                    visited[item.to] = true;
                    q.offer(item.to);
                    break;
                }
            }
        }
    }
}

class Edge implements Comparable<Edge>{
    int to;
    long weight;

    public Edge(int to, long weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return (int)(this.weight - o.weight);
    }
}

/*


*/