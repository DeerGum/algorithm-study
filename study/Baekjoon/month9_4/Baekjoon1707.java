package study.Baekjoon.month9_4;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제이름 : 이분 그래프
 * 링크 : https://www.acmicpc.net/problem/1707
 */

public class Baekjoon1707 {
    static int V, E;
    static ArrayList<Integer>[] e;
    static int[] vColor;
    static boolean isYes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            vColor = new int[V];
            e = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                vColor[i] = -1;
                e[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;

                e[from].add(to);
                e[to].add(from);
            }


            isYes = true;
            for (int i = 0; i < V; i++) {
                if (vColor[i] == -1) 
                    dfs(i, 0);
                if (!isYes) 
                    break;
            }

            if (isYes)
                bw.write("YES" + "\n");
            else
                bw.write("NO" + "\n");
        }
        bw.close();
    }
    
    public static void dfs(int vertex, int vertexColor) {
        vColor[vertex] = vertexColor;

        for (int nextVertex : e[vertex]) {
            int nextVertexColor = (vertexColor + 1) % 2;    //다음 방문할 정점의 색
            if (vColor[nextVertex] != -1) { //인접한 정점을 방문한 적 있고
                if (vColor[nextVertex] == vertexColor) { // 인접한 정점이 현재 정점과 색이 같으면
                    isYes = false; //이분그래프가 아님
                    return;
                } else  //방문한적만 있으면 넘어감
                    continue;
            }
            
            dfs(nextVertex, nextVertexColor);
        }
    }
}



/*
1
4 5
1 1
1 2
2 3
3 4
4 1



*/
