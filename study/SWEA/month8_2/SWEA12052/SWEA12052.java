package study.SWEA.month8_2.SWEA12052;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 부서진 타일
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXmwOSJaSNIDFARX
 */

public class SWEA12052 {
    static int n, m;
    static char[][] tile;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            tile = new char[n][m];
            for (int i = 0; i < n; i++) {
                tile[i] = br.readLine().toCharArray();
            }
            
            
        }
    }
}

/*


*/