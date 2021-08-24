package study.Baekjoon.month8_4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : DFS와 BFS
 * 링크 : https://www.acmicpc.net/problem/1260
 */

public class Baekjoon1260 {
    static int N, M, V; //입력값
    static ArrayList<Integer>[] graph;  //그래프 간선저장
    static boolean[] visited;   //방문체크
    static StringBuilder sb;    //출력 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) 
            graph[i] = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
            graph[to].add(from);
        }

        for (int i = 1; i < N+1; i++) 
            Collections.sort(graph[i]); //노드번호가 낮은 순서대로 정렬
        

        visited = new boolean[N+1];
        sb = new StringBuilder();
        visited[V] = true;
        dfs(V);
        bw.write(sb.toString()+"\n");
        
        sb = new StringBuilder();
        visited = new boolean[N+1];
        bfs();

        bw.write(sb.toString()+"\n");
        bw.close();
    }

    public static void dfs(int node) {
        sb.append(node+" ");

        for (int i = 0; i < graph[node].size(); i++) {
            int to = graph[node].get(i);
            if (visited[to]) 
                continue;
            
            visited[to] = true;
            dfs(to);
        }
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(V);
        visited[V] = true;

        while (!q.isEmpty()) {
            int from = q.poll();
            sb.append(from+" ");

            for (int i = 0; i < graph[from].size(); i++) {
                int to = graph[from].get(i);
                if (visited[to]) 
                    continue;
                
                q.offer(to);
                visited[to] = true;
            }
        }
    }
}

/*


*/
