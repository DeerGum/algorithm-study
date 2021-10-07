package study.Baekjoon.month10_1;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 게리맨더링
 * 링크 : https://www.acmicpc.net/problem/17471
 */

public class Baekjoon17471 {
    static int N;
    static int[] population;
    static ArrayList<Integer>[] graph;
    static int minDiff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        population = new int[N + 1];
        graph = new ArrayList[N + 1];
        minDiff = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++) {
                int to = Integer.parseInt(st.nextToken());
                graph[i].add(to);
                graph[to].add(i);
            }
        }

        subset(0, 0, new int[N + 1]);
        if (minDiff == Integer.MAX_VALUE) //두 그룹으로 나눌 수 없으면
            minDiff = -1;

        bw.write(minDiff + "\n");
        bw.close();
    }
    
    public static void subset(int cnt, int groupCnt, int[] group) {
        if (cnt == N + 1) {
            int group1 = 0, group2 = 0;
            boolean[] visited = new boolean[N + 1];
            boolean onePass = true, twoPass = true;
            if (groupCnt != 0 && groupCnt != N) { //그룹이 두개로 나뉘면
                for (int i = 1; i < N + 1; i++) { //첫번째 그룹 BFS 탐색
                    if (onePass && !visited[i] && group[i] == 0) {
                        group1 = bfs(i, group, visited);
                        onePass = false;
                    }

                    if (twoPass && !visited[i] && group[i] == 1) {
                        group2 = bfs(i, group, visited);
                        twoPass = false;
                    }
                }

                boolean isPass = true;
                for (int i = 1; i < N + 1; i++) {
                    if (!visited[i])    //한 곳이라도 방문안한 곳이 있으면
                        isPass = false;
                }
                if (isPass)
                    minDiff = Math.min(minDiff, (int)Math.abs(group1 - group2));    //인구수 차이 갱신
            }
            return;
        }

        group[cnt] = 1;
        subset(cnt + 1, groupCnt + 1, group);

        group[cnt] = 0;
        subset(cnt + 1, groupCnt, group);
    }
    
    public static int bfs(int node, int[] group, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { node, group[node] });
        visited[node] = true;
        int pop = 0; //인구수 합
        
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int curr = t[0];
            int groupNum = t[1];
            pop += population[curr];

            for (int next : graph[curr]) {
                if (visited[next] || group[next] != groupNum)
                    continue;

                q.add(new int[] { next, groupNum });
                visited[next] = true;
            }
        }
        
        return pop;
    }
}
    

/*


*/
