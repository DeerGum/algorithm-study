package study.SWEA.month9_4.SWEA5643;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제이름 : 키순서
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXQsLWKd5cDFAUo&categoryId=AWXQsLWKd5cDFAUo&categoryType=CODE&problemTitle=5643&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA5643 {
    static int N, M;
    static ArrayList<Integer>[] graph;  //키 큰 학생들에 대한 단방향 그래프
    static int[][] dp;  // 각 학생들보다 큰 사람이 누가 있는지 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            graph = new ArrayList[N];
            for (int i = 0; i < N; i++) 
                graph[i] = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;

                graph[from].add(to);
            }
            dp = new int[N][N];

            for (int i = 0; i < N; i++)
                dfs(i, i,new boolean[N]);   //dp 배열 채움

            int count = 0;
            for (int i = 0; i < N; i++) {
                if (sum(i) == N - 1)    // dp배열의 i행0열~i행N-1열+ 0행i열~N-1행i열을 모두 더한 값이 N-1이면 순서 유추 가능 
                    count++;
            }

            bw.write("#" + t + " " + count + "\n");
        }
        bw.close();
    }
    
    public static void dfs(int start, int curr, boolean[] visited) {
        visited[curr] = true;
        for (int next : graph[curr]) {
            if (visited[next]) 
                continue;
            
            dp[start][next]++;
            dfs(start, next, visited);
        }
    }

    public static int sum(int n) {
        int sum = 0;
        for (int i = 0; i < N; i++) 
            sum += dp[n][i] + dp[i][n]; //n행의 합은 n번째 학생보다 키가 작은 학생들, n열의 합은 n번째 학생보다 큰 학생들
        
        return sum;
    }
}

/*


*/