package study.week2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 숨바꼭질
 * 링크 : https://www.acmicpc.net/problem/1697
 * 알고리즘 분류
 * - 그래프 이론
 * - 그래프 탐색
 * - 너비우선 탐색
 */

public class Baekjoon1697 {
    public static int[] count = new int[100001];
    public static int[] move = {1,-1,2};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));    
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, k;
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if(n == k)
            bw.write("0\n");
        else 
            bw.write(bfs(n,k)+"\n");
        bw.flush();
        
    }

    public static int bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        count[start] = 1;

        int now, next;
        while(!q.isEmpty()) {
            now = q.poll();

            for (int i = 0; i < move.length; i++) {
                if(i != 2) 
                    next = now + move[i];
                else
                    next = now * move[i];

                if(next == target) 
                    return count[now];
                
                if(next >= 0 && next < count.length && count[next] == 0) {
                    count[next] = count[now] + 1;
                    q.add(next);
                }
            }
        }
        return 0;
    }
}