package study.newStudy.week3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 레이저 통신
 * 링크 : https://www.acmicpc.net/problem/6087
 */

public class Baekjoon6087 {
    static int W, H;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];

        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                char c = str.charAt(j);
                if (c == '*') {
                    map[i][j] = -1;
                } else if (c == 'C') {
                    map[i][j] = -2;
                }
            }
        }
        
        
        
        
        
    }
}

/*


*/
