package study.Baekjoon.month8_4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제이름 : 최단경로
 * 링크 : https://www.acmicpc.net/problem/1753
 * 통과는 못하지만 2차원 배열로 간단하게 구현한 코드
 */

public class Baekjoon1753_2 {

    static int V, E, K;
    static int[] distance;
    static boolean[] visited;
    static int[][] graph;
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
        graph = new int[V+1][V+1];
        for (int i = 0; i < V+1; i++) {
            distance[i] = Integer.MAX_VALUE;
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u][v] = w;
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
        distance[K] = 0;    //시작지점 거리 입력

        int min, curr;
        for (int i = 1; i < V+1; i++) {
            min = Integer.MAX_VALUE;
            curr = -1;
            for (int j = 1; j < V+1; j++) {
                if (!visited[j] && distance[j] < min) {
                    min = distance[j];
                    curr = j;
                }
            }
            if (curr == -1)    //더이상 정점이 없으면 탈출
                break;
            visited[curr] = true; // 선택정점 방문 처리
            
            for (int c = 1; c < V+1; c++) {
                int nextWeight = min + graph[curr][c];
                if (!visited[c] && graph[curr][c] != Integer.MAX_VALUE && nextWeight < distance[c]) {
                    // 방문하지 않음 && 간선이 있음 && 계산한 새로 도출된 거리가 distance배열 안의 값보다 작음 
                    distance[c] = nextWeight;
                }
            }
        }
    }
}

/*


*/
