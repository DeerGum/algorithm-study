import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제이름 : LCA2
 * 링크 : https://www.acmicpc.net/problem/11438
 * 알고리즘 분류
 * - 최소공통조상
 * - 트리
 * - 자료구조
 * - 희소배열
 */

public class Baekjoon11438 {
    public static ArrayList<Integer>[] tree;
    public static int[] depths;
    public static int[][] parents;
    public static boolean[] isVisted;
    public static final int MAX_D = 17;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        depths = new int[n+1];
        parents = new int[n+1][MAX_D+1];
        isVisted = new boolean[n+1];
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
        isVisted[1] = true;
        dfs(1, 0);

        for (int i = 0; i < MAX_D-1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(parents[j][i] != 0)
                    parents[j][i+1] = parents[parents[j][i]][i];
            }
        }
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
            if(!isVisted[child]) {
                isVisted[child] = true;
                parents[child][0] = node;
                dfs(child, depth + 1);
            }
        }
    }

    public static int LCA(int node1, int node2) {
        if(depths[node1] < depths[node2]) { //node1이 더 크게 변경
            int temp = node1;
            node1 = node2;
            node2 = temp;
        }
        
        for (int i = MAX_D; i >= 0; i--) {
            if(depths[node1]-depths[node2] >= (1 << i)) {
                node1 = parents[node1][i];
            }
        }
        if(node1 == node2)
            return node1;

        for (int i = MAX_D; i >= 0; i--) {
            if(parents[node1][i] != parents[node2][i]) {
                node1 = parents[node1][i];
                node2 = parents[node2][i];
            }
        }
        return parents[node1][0];
    }
}