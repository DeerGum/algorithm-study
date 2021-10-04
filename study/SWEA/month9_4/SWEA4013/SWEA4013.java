package study.SWEA.month9_4.SWEA4013;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 특이한 자석
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeV9sKkcoDFAVH&categoryId=AWIeV9sKkcoDFAVH&categoryType=CODE&problemTitle=%ED%8A%B9%EC%9D%B4%ED%95%9C&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA4013 {
    static final int N = 4, M = 8;
    static int K;
    static int[][] m;   // 자석배열
    static int[][] mIdx;// 각 자석의 화살표 인덱스, 이전자석 맞물리는 인덱스, 다음자석 맞물리는 인덱스 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            K = Integer.parseInt(br.readLine());

            m = new int[N][M];
            // m배열의 {화살표 인덱스, 다음자석과 맞물리는 인덱스, 이전자석과 맞물리는 인덱스}
            mIdx = new int[][] { { 0, 2, -1 }, { 0, 2, 6 }, { 0, 2, 6 }, { 0, -1, 6 } };
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) 
                    m[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int mNum = Integer.parseInt(st.nextToken()) - 1;
                int d = Integer.parseInt(st.nextToken());
                simul(mNum, d, new boolean[N]);
            }

            bw.write("#" + t + " " + cal() + "\n");
        }
        bw.close();
    }
    
    public static void simul(int curr, int d, boolean[] visited) {
        visited[curr] = true;
        int prev = curr - 1;
        int next = curr + 1;

        if (prev >= 0 && !visited[prev] && m[curr][mIdx[curr][2]] != m[prev][mIdx[prev][1]])
        // 이전 자석이 있고 현재 자석과 이전 자석의 맞물리는 인덱스의 값이 다르면
        simul(prev, -d, visited);
        
        if (next < N && !visited[next] && m[curr][mIdx[curr][1]] != m[next][mIdx[next][2]])
        // 다음 자석이 있고 현재 자석과 다음 자석의 맞물리는 인덱스의 값이 다르면
            simul(next, -d, visited);

        rotation(curr, d);
    }
    
    
    //mIdx배열 회전
    public static void rotation(int mNum, int d) {
        if (d == 1) { // 시계방향
            for (int i = 0; i < mIdx[mNum].length; i++)
                mIdx[mNum][i] = (M + mIdx[mNum][i] - 1) % M;
        } else { // 반시게방향
            for (int i = 0; i < mIdx[mNum].length; i++)
                mIdx[mNum][i] = (mIdx[mNum][i] + 1) % M;
        }
    }
    
    //점수 계산
    public static int cal() {
        int p = 1;
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (m[i][mIdx[i][0]] == 1)
                result += p;
            p <<= 1;
        }
        return result;
    }
}

/*

시계 방향 이동 -> idx - 1
반시계 방향 이동 -> idx + 1

2
2
0 0 1 0 0 1 0 0
1 0 0 1 1 1 0 1
0 0 1 0 1 1 0 0
0 0 1 0 1 1 0 1
1 1
3 -1
2
1 0 0 1 0 0 0 0
0 1 1 1 1 1 1 1
0 1 0 1 0 0 1 0
0 1 0 0 1 1 0 1
3 1
1 1

*/