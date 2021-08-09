package study.Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 경비원
 * 링크 : https://www.acmicpc.net/problem/2564
 */

public class Baekjoon2564 {
    static int[][] map;
    static int[][] dir = { {-1,0},{1,0},{0,-1},{0,1} };
    static boolean[][] visited;
    static int[] min;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //1 북, 2 남, 3 서, 4 동
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[m+1][n+1];
        for (int i = 1; i < map.length-1; i++) 
            for (int j = 1; j < map[i].length-1; j++) 
                map[i][j] = -1;
        
        int shopN = Integer.parseInt(br.readLine());
        int[][] shops = new int[shopN][2];
        for (int i = 0; i < shops.length; i++) {
            st = new StringTokenizer(br.readLine());
            shops[i][0] = Integer.parseInt(st.nextToken());
            shops[i][1] = Integer.parseInt(st.nextToken());
            switch(shops[i][0]) {
                case 1: //북
                    map[0][shops[i][1]] = i+1;
                    break;
                case 2: //남
                    map[m][shops[i][1]] = i+1;
                    break;
                case 3: //서
                    map[shops[i][1]][0] = i+1;
                    break;
                case 4: //동
                    map[shops[i][1]][n] = i+1;
                    break;
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] donguen = new int[2];
        donguen[0] = Integer.parseInt(st.nextToken());
        donguen[1] = Integer.parseInt(st.nextToken());

        
        min = new int[shopN];
        for (int i = 0; i < min.length; i++) 
            min[i] = Integer.MAX_VALUE;
        
        for (int i = 1; i <= shopN; i++) {
            visited = new boolean[m+1][n+1];
            switch(donguen[0]) {
                case 1: //북
                    dfs(0, donguen[1], i, 0);
                    break;
                case 2: //남
                    dfs(m, donguen[1], i, 0);
                    break;
                case 3: //서
                    dfs(donguen[1], 0, i, 0);
                    break;
                case 4: //동
                    dfs(donguen[1], n, i, 0);
                    break;
            }
        }

        int result = 0;
        for (int i : min) 
            result += i;
        bw.write(result+"\n");
        bw.close();
    }

    public static void dfs(int r, int c, int shop, int count) {
        if (map[r][c] == shop) {
            min[shop-1] = Math.min(min[shop-1], count);
            return;
        }
        
        visited[r][c] = true;

        for (int i = 0; i < dir.length; i++) {
            int R = r + dir[i][0];
            int C = c + dir[i][1];

            if (R < 0 || R > m || C < 0 || C > n || map[R][C] == -1 || visited[R][C]) 
                continue;

            dfs(R, C, shop, count+1);
        }
    }
}

/*


*/
