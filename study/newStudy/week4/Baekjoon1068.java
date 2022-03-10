package study.newStudy.week4;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제이름 : 트리
 * 링크 : https://www.acmicpc.net/problem/1068
 */

public class Baekjoon1068 {
    static int N;
    static int[] tree;
    static ArrayList<Integer>[] search;
    static int cutNode;
    static int leafNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new int[N];
        search = new ArrayList[N];
        int rootNode = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            search[i] = new ArrayList<>();
            tree[i] = Integer.parseInt(st.nextToken());
            if (tree[i] == -1) 
                rootNode = i;
            
        }

        cutNode = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            if (i == cutNode) 
                continue;
            
            if (tree[i] != -1)
                search[tree[i]].add(i);
        }
        if (cutNode != rootNode) 
            dfs(rootNode);
        
        bw.write(leafNode + "\n");
        bw.close();
    }
    
    public static void dfs(int curr) {
        if (search[curr].isEmpty()) {
            leafNode++;
            return;
        }

        for (int i = 0; i < search[curr].size(); i++) {
            int next = search[curr].get(i);
            if (next == cutNode) 
                continue;
            
            dfs(next);
        }
    }
}

/*


*/
