package study.week7;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 최소 스패닝 트리
 * 링크 : https://www.acmicpc.net/problem/1197
 * 알고리즘 분류
 * - 그래프이론
 * - 최소신장트리
 */

public class Baekjoon1197 {

    public static ArrayList<Edge>[] graph;
    public static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[v + 1];
        isVisited = new boolean[v + 1];
        for (int i = 0; i <= v; i++)
            graph[i] = new ArrayList<>();

        int start, end, weight;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(start, end, weight));
            graph[end].add(new Edge(end, start, weight));
        }
        int startEdge = 1;
        bw.write(prim(startEdge) + "\n");
        bw.flush();

    }

    public static int prim(int startEdge) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(); //이동할 정점을 정하기 위한 우선순위 큐
        Queue<Integer> q = new LinkedList<>();  //이동할 정점을 저장하는 큐
        int result = 0;

        q.add(startEdge);

        while (!q.isEmpty()) {
            int cur = q.poll();
            isVisited[cur] = true;

            for (Edge e : graph[cur]) { //현재 정점에서 이동할 수 있는 다른 정점을 확인
                if (!isVisited[e.end])
                    pq.add(e);  //우선순위 큐에 삽입
            }

            while (!pq.isEmpty()) {
                Edge e = pq.poll(); //우선순위 큐에서 가장 가중치가 낮은 정점이 반환
                if (!isVisited[e.end]) {    //아직 방문하지 않았으면
                    q.add(e.end);   //이동할 정점을 저장하는 큐에 삽입
                    isVisited[e.end] = true;
                    result += e.weight;
                    break;
                }
            }
        }

        return result;
    }
}

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int weight;

    Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}