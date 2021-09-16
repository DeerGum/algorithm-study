package study.Baekjoon.month9_2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 치즈
 * 링크 : https://www.acmicpc.net/problem/2636
 */

public class Baekjoon2636 {
    static int N, M;
    static int[][] cheese;
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cheese = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cheeseCnt = 0;
        int prevCheeseCnt = 0;
        int time = 0;
        while ((cheeseCnt = nextCheese()) != 0) {
            dfs(0, 0, new boolean[N][M]);
            time++;
            prevCheeseCnt = cheeseCnt;  //다음 while문 시작하기 전에 치즈 갯수 저장 (치즈가 0개이면 종료이기 때문)
        }

        bw.write(time+"\n"+prevCheeseCnt);
        bw.close();
    }
    
    public static void dfs(int r, int c, boolean[][] v) {
        v[r][c] = true;

        if (cheese[r][c] == 1) {    //외부 공기와 접촉한 치즈 체크
            cheese[r][c] = 2;   //외부 공기와 접촉하면 2로 변경
            return;
        }

        for (int i = 0; i < dir.length; i++) {
            int dr = r + dir[i][0];
            int dc = c + dir[i][1];

            if (dr < 0 || dr >= N || dc < 0 || dc >= M || v[dr][dc])
                continue;

            dfs(dr, dc, v);
        }
    }
    
    public static int nextCheese() {    //한시간 후의 치즈
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cheese[i][j] == 2)  //외부 공기와 접촉한 치즈 녹임
                    cheese[i][j] = 0;
                else if (cheese[i][j] == 1) //남아있는 치즈 갯수 카운트
                    count++;
            }
        }
        return count;
    }
}

/*


*/
