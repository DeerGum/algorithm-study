package study.newStudy.week3;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 문제이름 : 레이저 통신
 * 링크 : https://www.acmicpc.net/problem/6087
 */

public class Baekjoon6087 {
    static int W, H;
    static int[][] map;
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static int[] rDirIdx = { 1, 0, 3, 2 };
    static int result;
    static int endR;
    static int endC;
    static final int MAX = 9;
    static final int EXIT = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        int startR = -1;
        int startC = -1;
        endR = -1;
        endC = -1;
        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                char c = str.charAt(j);
                if (c == '*') {
                    map[i][j] = -2;
                } else if (c == 'C') {
                    map[i][j] = EXIT;
                    if (startR == -1) {
                        startR = i;
                        startC = j;
                    } else {
                        endR = i;
                        endC = j;
                    }
                } else {
                    map[i][j] = MAX;
                }
            }
        }

        result = 0;
        bfs(startR, startC);
        for (int i = 0; i < H; i++) {
            bw.write(Arrays.toString(map[i]) + "\n");
        }
        bw.write(result + "\n");
        bw.close();

    }

    public static void bfs(int r, int c) {
        Deque<int[]> dq = new ArrayDeque<>();

        dq.addFirst(new int[] { r, c, -1, -1 });
        boolean[][] v = new boolean[H][W];
        map[r][c] = -999;

        while (!dq.isEmpty()) {
            int[] curr = dq.removeFirst();
            int currR = curr[0];
            int currC = curr[1];
            int prevDir = curr[2];
            int currCost = curr[3];

            if (currR == endR && currC == endC) {
                result = currCost;
                return;
            }

            for (int i = 0; i < dir.length; i++) {
                int dr = currR + dir[i][0];
                int dc = currC + dir[i][1];

                if (dr < 0 || dr >= H || dc < 0 || dc >= W || map[dr][dc] == -2 || map[dr][dc] < currCost)
                    continue;

                int nextCost = (i == prevDir) ? currCost : currCost + 1;

                if (i == prevDir) { // 이전 방향이랑 같으면
                    if (map[dr][dc] > currCost) {
                        dq.addFirst(new int[] { dr, dc, i, currCost });
                        map[dr][dc] = currCost;
                    }
                } else if (prevDir != rDirIdx[i]) { // 왔던 방향이 아니고 이전 방향이랑 다르면
                    if (map[dr][dc] > nextCost) {
                        dq.addLast(new int[] { dr, dc, i, nextCost });
                        map[dr][dc] = nextCost;
                    }
                }

            }
        }

    }
}

/*


*/
