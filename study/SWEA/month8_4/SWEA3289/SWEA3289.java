package study.SWEA.month8_4.SWEA3289;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 서로소 집합
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJKA6qr2oDFAWr&categoryId=AWBJKA6qr2oDFAWr&categoryType=CODE&problemTitle=3289&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA3289 {
    static int N, M;
    static int[] parents;
    static int[] rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb;
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            makeSet();
            sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (cmd == 0) {
                    union(a, b);
                } else if (cmd == 1) {
                    sb.append(find(a) == find(b)?"1":"0");
                }
            }

            bw.write("#"+t+" "+sb.toString()+"\n");
        }
        bw.close();
    }

    public static void makeSet() {
        parents = new int[N+1];
        rank = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            parents[i] = i;
            rank[i] = 1;
        }
    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) 
            return;
        
        parents[bRoot] = aRoot;
    }

    public static int find(int a) {
        if (parents[a] == a) 
            return a;
        else
            return parents[a] = find(parents[a]);
    }
}

/*


*/