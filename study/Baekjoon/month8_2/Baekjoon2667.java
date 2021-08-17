package study.Baekjoon.month8_2;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 문제이름 : 단지번호붙이기
 * 링크 : https://www.acmicpc.net/problem/2667
 */

public class Baekjoon2667 {
    static int n;
    static int[][] map;
    static int[][] dir = { {-1,0},{1,0},{0,-1},{0,1} };
    static LinkedList<Integer> result;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        result = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int cnt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    count = 0;
                    dfs(i, j, ++cnt);
                    result.add(count);
                }
            }
        }   
        Collections.sort(result);
        bw.write(result.size()+"\n");
        while (!result.isEmpty()) 
            bw.write(result.poll()+"\n");
        bw.close();
        
    }

    public static void dfs(int r, int c, int group) {
        map[r][c] = group;
        count++;
        for (int i = 0; i < dir.length; i++) {
            int R = r + dir[i][0];
            int C = c + dir[i][1];

            if (R < 0 || R >= n || C < 0 || C >= n || map[R][C] != 1) 
                continue;
            
            dfs(R, C, group);
        }
    }
}

/*


*/
