package study.week3;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제이름 : 트리의 부모 찾기
 * 링크 : https://www.acmicpc.net/problem/11725
 * 알고리즘 분류
 * - 깊이우선탐색
 * - 그래프이론
 * - 그래프탐색
 * - 트리
 */

public class Baekjoon11725 {
    public static ArrayList<Integer>[] tree;
    public static int[] parents;
    public static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        parents = new int[n+1];
        isVisited = new boolean[n+1];
        StringTokenizer st;
        for (int i = 0; i < tree.length; i++) 
            tree[i] = new ArrayList<>();
        
        int from, to;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());

            tree[from].add(to);
            tree[to].add(from);
        }

        isVisited[1] = true;
        dfs(1);
        
        for (int i = 2; i < parents.length; i++) 
            bw.write(parents[i]+"\n");
        bw.flush();

        
    }

    public static void dfs(int node) {
        int child;
        for (int i = 0; i < tree[node].size(); i++) {
            child = tree[node].get(i);
            if(!isVisited[child]) {
                parents[child] = node;
                isVisited[child] = true;
                dfs(child);
            }
        }
    }
}