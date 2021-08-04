

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : N과 M(2)
 * 링크 : https://www.acmicpc.net/problem/15650
 * 알고리즘 분류
 * - 백트래킹
 */

public class Baekjoon15650 {
    public static int[] arr;
    public static boolean[] isVisited;
    public static StringBuilder sb;
    public static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        isVisited = new boolean[n];
        
        dfs(0);

        bw.write(sb.toString());
        bw.flush();
    }

    public static void dfs(int num) {
        if(num == m) {
            for(int i : arr) 
                sb.append(i+" ");
            sb.append("\n");
        }
        else {
            int lastIdx = (num == 0) ? 0 : arr[num-1];
            for (int i = lastIdx; i < n; i++) {
                if(!isVisited[i]) {
                    isVisited[i] = true;
                    arr[num] = i+1;
                    dfs(num+1);
                    isVisited[i] = false;
                }
            }
        }
    }
}