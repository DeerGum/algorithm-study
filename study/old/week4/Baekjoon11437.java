package study.old.week4;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제이름 : LCA
 * 링크 : https://www.acmicpc.net/problem/11437
 * 알고리즘 분류
 * - 최소공통조상
 * - 트리
 */

public class Baekjoon11437 {
    public static ArrayList<Integer>[] tree;
    public static boolean[] isVisited; 
    public static int[] parents;
    public static int[] depths;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        isVisited = new boolean[n+1];
        parents = new int[n+1];
        depths = new int[n+1];
        for (int i = 0; i < tree.length; i++) 
            tree[i] = new ArrayList<>();
        
        
        int from, to;
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            tree[from].add(to);
            tree[to].add(from);
        }
        
        isVisited[1] = true;
        dfs(1, 0);

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            
            bw.write(LCA(from, to)+"\n");
        }
        bw.flush();
        
        
    }

    public static void dfs(int node, int depth) {
        int child;
        depths[node] = depth;
        for (int i = 0; i < tree[node].size(); i++) {
            child = tree[node].get(i);
            if(!isVisited[child]) {
                parents[child] = node;
                isVisited[child] = true;
                dfs(child, depth + 1);
            }
        }
    }

    public static int LCA(int node1, int node2) {
        while(true) {
            if(depths[node1] == depths[node2]) {
                if(node1 == node2)
                    return node1;
                else {
                    node1 = parents[node1];
                    node2 = parents[node2];
                }
            }
            else {
                if(depths[node1] > depths[node2]) 
                    node1 = parents[node1];
                else 
                    node2 = parents[node2];
            }
        }
    }
}

