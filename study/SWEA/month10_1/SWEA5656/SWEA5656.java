package study.SWEA.month10_1.SWEA5656;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 벽돌깨기
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRQm6qfL0DFAUo&categoryId=AWXRQm6qfL0DFAUo&categoryType=CODE&problemTitle=5656&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA5656 {
    static int N, W, H;
    static int[][] map;
    static int minBlock;
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            minBlock = Integer.MAX_VALUE;
            perm(0, new int[N]);
            // simul(new int[]{2,5,9});
            bw.write("#" + t + " " + minBlock + "\n");
        }
        bw.close();
    }
    
    public static void perm(int cnt, int[] p) {
        if (cnt == N) {
            simul(p);
            return;
        }

        for (int i = 0; i < W; i++) {
            p[cnt] = i;
            perm(cnt + 1, p);
        }
    }
    
    public static void simul(int[] p) {
        int[][] m = copyArr();
        for (int i = 0; i < p.length; i++) {
            crush(m, p[i]);
            blockDown(m);
        }

        int block = counting(m);
        if (block < minBlock) {
            minBlock = block;
        }
        // minBlock = Math.min(minBlock, block);
    }
    
    public static void crush(int[][] m, int idx) {
        for (int i = 0; i < H; i++) {
            if (m[i][idx] == 0)
                continue;

            bfs(i, idx, m);
            break;
        }
    }
    
    public static void bfs(int r, int c, int[][] m) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[H][W];

        q.offer(new int[] { r, c, m[r][c]});

        while (!q.isEmpty()) {
            int[] t = q.poll();
            m[t[0]][t[1]] = 0;

            for (int i = 0; i < dir.length; i++) {
                int dr = t[0];
                int dc = t[1];

                for (int j = 1; j < t[2]; j++) {
                    dr += dir[i][0];
                    dc += dir[i][1];

                    if (dr < 0 || dr >= H || dc < 0 || dc >= W)
                        continue;

                    if (m[dr][dc] > 1)
                        q.offer(new int[] { dr, dc, m[dr][dc]});

                    m[dr][dc] = 0;
                }
            }
        }
    }
    
    public static void blockDown(int[][] m) {
        boolean isSpace = false;
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                if (isSpace && m[j][i] == 0) {
                    for (int k = j - 1; k >= 0; k--)
                        m[k + 1][i] = m[k][i];
                    continue;
                }
                
                if (m[j][i] != 0) {
                    isSpace = true;
                }
            }
        }
    }
    
    public static int[][] copyArr() {
        int[][] temp = new int[H][W];

        for (int i = 0; i < H; i++)
            System.arraycopy(map[i], 0, temp[i], 0, W);

        return temp;
    }
    
    public static int counting(int[][] arr) {
        int result = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (arr[i][j] != 0)
                    result++;
            }
        }
        return result;
    }
}

/*

5
3 10 10
0 0 0 0 0 0 0 0 0 0
1 0 1 0 1 0 0 0 0 0
1 0 3 0 1 1 0 0 0 1
1 1 1 0 1 2 0 0 0 9
1 1 4 0 1 1 0 0 1 1
1 1 4 1 1 1 2 1 1 1
1 1 5 1 1 1 1 2 1 1
1 1 6 1 1 1 1 1 2 1
1 1 1 1 1 1 1 1 1 5
1 1 7 1 1 1 1 1 1 1
2 9 10
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 0 0 0 0 0 0 0
0 1 0 0 0 0 0 0 0
1 1 0 0 1 0 0 0 0
1 1 0 1 1 1 0 1 0
1 1 0 1 1 1 0 1 0
1 1 1 1 1 1 1 1 0
1 1 3 1 6 1 1 1 1
1 1 1 1 1 1 1 1 1
3 6 7
1 1 0 0 0 0
1 1 0 0 1 0
1 1 0 0 4 0
4 1 0 0 1 0
1 5 1 0 1 6
1 2 8 1 1 6
1 1 1 9 2 1
4 4 15
0 0 0 0 
0 0 0 0 
0 0 0 0 
1 0 0 0 
1 0 0 0 
1 0 0 0 
1 0 0 0 
1 0 5 0 
1 1 1 0 
1 1 1 9 
1 1 1 1 
1 6 1 2 
1 1 1 5 
1 1 1 1 
2 1 1 2 
4 12 15
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9

1
3 6 7
1 1 0 0 0 0
1 1 0 0 1 0
1 1 0 0 4 0
4 1 0 0 1 0
1 5 1 0 1 6
1 2 8 1 1 6
1 1 1 9 2 1


2 5 9


*/