package study.Baekjoon.month8_2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 색종이2
 * 링크 : https://www.acmicpc.net/problem/2567
 */

public class Baekjoon2567 {
    static int N;
    static int[][] paper;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}}; //상하좌우
    static boolean[][] v;
    static int len;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        len = 100;
        N = Integer.parseInt(br.readLine());
        paper = new int[len+2][len+2];
        v = new boolean[len+2][len+2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) + 1;
            int c = Integer.parseInt(st.nextToken()) + 1;
            attach(r, c);
        }

        for (int i = 0; i < len+2; i++) {
            for (int j = 0; j < len+2; j++) {
                if (!v[i][j] && paper[i][j] != -1) {
                    bfs(i, j);
                }
            }
        }

        int result = sum();
        bw.write(result+"\n");
        bw.close();
        
    }

    public static void attach(int r, int c) {
        for (int i = r; i < r+10; i++) {
            for (int j = c; j < c+10; j++) {
                paper[i][j] = -1;
            }
        }
    }

    public static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        int R, C, count;
        q.offer(new int[]{r,c});
        v[r][c] = true;
        while (!q.isEmpty()) {
            int[] t = q.poll();
            count = 0;

            for (int i = 0; i < dir.length; i++) {
                R = t[0] + dir[i][0];
                C = t[1] + dir[i][1];

                if (R < 0 || R >= len+2 || C < 0 || C >= len+2 || v[R][C]) 
                    continue;
                
                if (paper[R][C] == -1) {    //주변에 색종이가 있으면
                    count++;
                    continue;
                }

                q.offer(new int[]{R,C});    //비어있는 공간이면
                v[R][C] = true;
            }
            if (t[0] != -1 && t[1] != -1)
                paper[t[0]][t[1]] = count;
        }
    }

    public static int sum() {
        int sum = 0;
        for (int i = 0; i < len+2; i++) {
            for (int j = 0; j < len+2; j++) {
                if (paper[i][j] > 0)
                    sum += paper[i][j];
            }
        }
        return sum;
    }
}

/*


*/
