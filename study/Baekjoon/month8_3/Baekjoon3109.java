package study.Baekjoon.month8_3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 빵집
 * 링크 : https://www.acmicpc.net/problem/3109
 */

public class Baekjoon3109 {
    static int[][] dir = {{-1,1},{0,1},{1,1}};  //오른쪽 위, 오른쪽, 오른쪽 아래
    static char[][] map;
    static int R, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) 
            map[i] = br.readLine().toCharArray();

        int pipe = 0;
        for (int i = 0; i < R; i++) {
            if (map[i][0] == '.' && dfs(i, 0)) {
                pipe++;
            }
        }
        bw.write(pipe+"\n");
        bw.close();
    }

    // 지나간 경로 표시를 그대로 냅두는 이유
    // 도착에 실패했으면 - 다른 경로를 통해 이 루트를 다시 온다고 해도 도착 못하기 때문에 냅둠
    // 도착에 성공했으면 - 파이프라인이 연결되었으므로 다른 파이프라인이 겹치는걸 방지하기 위해 냅둠
    public static boolean dfs(int r, int c) {
        if (c == C - 1) 
            return true;
        
        map[r][c] = 'x';

        for (int i = 0; i < dir.length; i++) {
            int dr = r + dir[i][0];
            int dc = c + dir[i][1];

            if (dr < 0 || dr >= R || dc < 0 || dc >= C || map[dr][dc] == 'x') 
                continue;
            
            if (dfs(dr, dc))    //연결에 성공하면 true 반환 
                return true;
        }
        return false;
    }

}

/*
6 6
.....
.xxx.
...x.
.xxx.
.....

5 9
.x.....x.
.x..x..x.
.x..x..x.
....x....
.x..x..x.

*/
