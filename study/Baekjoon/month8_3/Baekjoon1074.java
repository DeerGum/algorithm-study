package study.Baekjoon.month8_3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : Z
 * 링크 : https://www.acmicpc.net/problem/1074
 */

public class Baekjoon1074 {
    static int N, R, C;
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        sum = 0;
        z(0, 0, 1<<N);
    }

    public static void z(int r, int c, int width) {
        if (r == R && c == C) {
            System.out.println(sum);
            return;
        }
        
        if (R < r || R >= r+width || C < c || C >= c+width) {   //범위를 벗어나면
            sum += width*width;
            return;
        }

        int halfWidth = width/2;
        z(r, c, halfWidth);
        z(r, c+halfWidth, halfWidth);
        z(r+halfWidth, c, halfWidth);
        z(r+halfWidth, c+halfWidth, halfWidth);
    }
}

/*


*/
