package study.old.week7;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 문제집
 * 링크 : https://www.acmicpc.net/problem/1766
 * 알고리즘 분류
 * - 자료구조
 * - 그래프이론
 * - 우선순위 큐
 * - 위상 정렬
 */

public class Baekjoon1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] nextProblem = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) 
            nextProblem[i] = new ArrayList<>();
        int[] prevProblemCount = new int[n+1];
    
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nextProblem[a].add(b);
            prevProblemCount[b]++;
        }

        for (int i = 1; i < n+1; i++) { 
        //이전에 풀어야 하는 문제가 없는 문제를 우선순위 큐에 삽입
            if(prevProblemCount[i] == 0) {
                pq.add(i);
            }
        }
        
        while(!pq.isEmpty()) {
            int currItem = pq.poll();
            for (int i = 0; i < nextProblem[currItem].size(); i++) {
                int nextItem = nextProblem[currItem].get(i);
                prevProblemCount[nextItem]--;
                if(prevProblemCount[nextItem] == 0)  
                    pq.add(nextItem);
            }
            bw.write(currItem+" ");
        }
        bw.newLine();
        bw.flush();
    }
}
