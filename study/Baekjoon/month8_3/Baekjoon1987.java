package study.Baekjoon.month8_3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 알파벳
 * 링크 : https://www.acmicpc.net/problem/1987
 */

public class Baekjoon1987 {
    static int R, C;
    static char[][] map;    //입력 배열 저장
    static boolean[] alphabet; //알파벳의 사용유무 저장
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};   //상 하 좌 우
    static int count = 0;   //이동한 칸
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) 
            map[i] = br.readLine().toCharArray();
        
        alphabet = new boolean[26]; 
        alphabet[map[0][0]-'A'] = true; //입력 받은 알파벳 체크
        dfs(0, 0, 1);   //dfs 탐색
        alphabet[map[0][0]-'A'] = false;

        bw.write(count+"\n");
        bw.close();
    }

    public static void dfs(int r, int c, int cnt) {
        count = Math.max(count, cnt);   //카운트의 max값 넣음

        for (int i = 0; i < dir.length; i++) {
            int dr = r + dir[i][0];
            int dc = c + dir[i][1];

            if (dr < 0 || dr >= R || dc < 0 || dc >= C || alphabet[map[dr][dc]-'A']) //범위를 벗어나거나 이미 체크된 알파벳은 무시
                continue;
            
            alphabet[map[dr][dc]-'A'] = true;
            dfs(dr, dc, cnt+1);
            alphabet[map[dr][dc]-'A'] = false;
        }
    }
}

/*


*/
