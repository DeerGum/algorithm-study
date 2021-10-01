package study.SWEA.month9_4.SWEA1953;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 탈주범 검거
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpLlKAQ4DFAUq&categoryId=AV5PpLlKAQ4DFAUq&categoryType=CODE&problemTitle=1953&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA1953 {
    static int N, M, R, C, L;
    static int[][] map;
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };  //상 하 좌 우
    static int[][] pipe = { {}, { 0, 1, 2, 3 }, { 0, 1 }, { 2, 3 }, { 0, 3 }, { 1, 3 }, { 1, 2 }, { 0, 2 } };   //각 파이프 이동할 수 있는 방향 pipe[0]은 무시
    static int[] input = { 1, 0, 3, 2 }; // 각 방향으로 이동하면 다음 파이프는 대칭되는 방향이 뚤려있어야 함

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   //행
            M = Integer.parseInt(st.nextToken());   //열
            R = Integer.parseInt(st.nextToken());   //시작 행
            C = Integer.parseInt(st.nextToken());   //시작 열
            L = Integer.parseInt(st.nextToken());   //경과한 시간

            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            bw.write("#" + t + " " + bfs(R, C) + "\n");
        }
        bw.close();

    }
    
    public static int bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        q.offer(new int[] { row, col, 1 });
        visited[row][col] = true;

        int count = 0;
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int r = t[0];
            int c = t[1];
            int time = t[2];    //현재 좌표까지 오는데 걸리는 시간
            int pipeNum = map[r][c];    //현재 좌표의 파이프 넘버
            count++;

            for (int i = 0; i < pipe[pipeNum].length; i++) {
                int d = pipe[pipeNum][i];
                int dr = r + dir[d][0];
                int dc = c + dir[d][1];
                int nextTime = time + 1;

                if (dr < 0 || dr >= N || dc < 0 || dc >= M || nextTime > L || visited[dr][dc]
                        || !hasInput(dr, dc, input[d])) //d방향의 대칭 방향을 입력으로 줌 - input[d]
                    continue;

                q.offer(new int[] { dr, dc, nextTime });
                visited[dr][dc] = true;
            }
        }

        return count;
    }
    
    //해당하는 좌표의 파이프 inputDir방향이 뚤려있는지
    public static boolean hasInput(int r, int c, int inputDir) {   
        int pipeNum = map[r][c];
        for (int i = 0; i < pipe[pipeNum].length; i++) {
            int d = pipe[pipeNum][i];
            if (d == inputDir)
                return true;
        }
        return false;
    }
}

/*
2
5 6 2 1 3
0 0 5 3 6 0
0 0 2 0 2 0
3 3 1 3 7 0
0 0 0 0 0 0
0 0 0 0 0 0

5 6 2 2 6
3 0 0 0 0 3
2 0 0 0 0 6
1 3 1 1 3 1
2 0 2 0 0 2
0 0 4 3 1 1
10 10 4 3 9

*/