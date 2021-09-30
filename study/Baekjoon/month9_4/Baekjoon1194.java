package study.Baekjoon.month9_4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 달이 차오른다, 가자.
 * 링크 : https://www.acmicpc.net/problem/1194
 */

public class Baekjoon1194 {
    static int N, M;
    static char[][] map;
    static int[] minsik;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();

        loop: for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '0') {
                    minsik = new int[] { i, j };
                    break loop;
                }
            }
        }

    }
    
    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        


    }
}

/*


*/
