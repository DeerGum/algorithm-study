package study.SWEA.month9_4.SWEA5643;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 키순서
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXQsLWKd5cDFAUo&categoryId=AWXQsLWKd5cDFAUo&categoryType=CODE&problemTitle=5643&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * dp 풀이
 */

public class SWEA5643_2 {
    static int N, M;
    // static ArrayList<Integer>[] graph;  //키 큰 학생들에 대한 단방향 그래프
    static int[][] dp; // 각 학생들보다 큰 사람이 누가 있는지 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            dp = new int[N+1][N+1];
            for (int i = 0; i < N; i++) 
                dp[i][0] = -1;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                dp[from][to] = 1;
            }
            

            for (int i = 1; i <= N; i++) {
                if (dp[i][0] == -1)
                    dfs(i); //dp 배열 채움
            }
            
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) 
                    dp[0][j] += dp[i][j];
            }

            int count = 0;
            for (int i = 1; i <= N; i++) {
                if (dp[i][0] + dp[0][i] == N - 1)    // dp배열의 i행0열~i행N-1열+ 0행i열~N-1행i열을 모두 더한 값이 N-1이면 순서 유추 가능 
                    count++;
            }

            bw.write("#" + t + " " + count + "\n");
        }
        bw.close();
    }
    
    public static int dfs( int curr) {
        for (int next = 1; next <= N; next++) {
            if (dp[curr][next] == 1) {
                if (dp[next][0] == -1)
                    dfs(next);

                if (dp[next][0] > 0) {
                    for (int i = 1; i <= N; i++) {
                        if (dp[next][i] == 1)
                            dp[curr][i] = 1;
                    }
                }
            }
        }
        
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (dp[curr][i] == 1)
                cnt++;
        }
        return dp[curr][0] = cnt;
    }
}

/*


*/