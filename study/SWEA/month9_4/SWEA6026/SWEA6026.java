package study.SWEA.month9_4.SWEA6026;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 성수의 비밀번호 공격
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWajgCUaaAkDFAWM
 */

public class SWEA6026 {
    static int M, N; //N - 동생 비밀번호 자리, M - 키보드에 묻은 지문 갯수
    static final int P = 1000000007;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            count = 0;
            dfs(0);

            bw.write("#" + t + " " + count + "\n");
        }
        bw.close();
    }
    
    public static void dfs(int cnt) {
        if (cnt == N) {
            count++;
            return;
        }

        for (int i = 0; i < M; i++) {
            
            dfs(cnt+1);
        }
    }
}

/*


*/