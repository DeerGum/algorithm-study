package study.SWEA.month8_4.SWEA1238;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : Contact
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD&categoryId=AV15B1cKAKwCFAYD&categoryType=CODE&problemTitle=1238&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA1238 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int maxNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = 10;
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            graph = new ArrayList[101];
            for (int i = 0; i < 101; i++) 
                graph[i] = new ArrayList<>();
            int n = Integer.parseInt(st.nextToken());
            int startNode = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n/2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from].add(to);
            }
            visited = new boolean[101];
            bfs(startNode);

            bw.write("#"+t+" "+maxNode+"\n");
        }
        bw.close();
    }

    public static void bfs(int startNode) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startNode, 0});   //연락할 수 있는 노드, 순번
        visited[startNode] = true;
        int maxNum = -1;
        ArrayList<Integer> maxNums = new ArrayList<>();
        while (!q.isEmpty()) {
            int[] t = q.poll();
            if (maxNum < t[1]) {
                maxNum = t[1];
                maxNums = new ArrayList<>();
            }
            maxNums.add(t[0]);
            for (int i = 0; i < graph[t[0]].size(); i++) {
                int temp = graph[t[0]].get(i);
                if (visited[temp]) 
                    continue;
                
                q.offer(new int[]{temp,t[1]+1});
                visited[temp] = true;
            }
        }
        maxNode = -1;
        for (int i = 0; i < maxNums.size(); i++) 
            maxNode = Math.max(maxNode, maxNums.get(i));
        
    }
}

/*


*/