package study.Baekjoon.month9_2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 맥주 마시면서 걸어가기
 * 링크 : https://www.acmicpc.net/problem/9205
 */

public class Baekjoon9205 {
    static int N;
    static int[][] node;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {

            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            node = new int[N + 2][2];
            node[0][0] = Integer.parseInt(st.nextToken());  //집 좌표
            node[0][1] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= N; i++) {  //편의점 좌표
                st = new StringTokenizer(br.readLine());
                node[i][0] = Integer.parseInt(st.nextToken());
                node[i][1] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());    // 페스티벌 좌표
            node[N + 1][0] = Integer.parseInt(st.nextToken());
            node[N + 1][1] = Integer.parseInt(st.nextToken());

            initDistance();
            if (bfs()) 
                bw.write("happy\n");
            else
                bw.write("sad\n");
        }
        bw.close();
    }

    public static void initDistance() { //각 좌표간의 거리 계산
        dist = new int[N + 2][N + 2];
        for (int i = 0; i < N + 2; i++) {
            for (int j = 0; j < N + 2; j++) {
                if (i == j || dist[i][j] != 0)
                    continue;

                int x = Math.abs(node[j][0] - node[i][0]);
                int y = Math.abs(node[j][1] - node[i][1]);
                dist[i][j] = x + y;
                dist[j][i] = dist[i][j];
            }
        }
    }

    public static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 2];
        q.offer(0);  //집부터 시작
        visited[0] = true;

        while (!q.isEmpty()) {
            int item = q.poll();
            if (dist[item][N + 1] <= 1000)    //페스티벌 행복 가능
                return true;
            

            for (int i = 1; i < N + 1; i++) {   //편의점만 탐색 0 : 집,  N+1 : 페스티벌
                if (visited[i] || dist[item][i] > 1000) // 거리가 1000넘어가면 불행해지니깐 넘김
                    continue;
                
                q.offer(i);
                visited[i] = true;
            }
        }

        return false;   //페스티벌 행복 불가능
    }
}

/*


*/
