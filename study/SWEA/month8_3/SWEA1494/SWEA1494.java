package study.SWEA.month8_3.SWEA1494;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 사랑의 카운슬러
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV2b_WPaAEIBBASw&categoryId=AV2b_WPaAEIBBASw&categoryType=CODE&problemTitle=%EC%82%AC%EB%9E%91%EC%9D%98&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA1494 {
    static int N;
    static int[][] worm;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            N = Integer.parseInt(br.readLine());
            worm = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                worm[i][0] = Integer.parseInt(st.nextToken());
                worm[i][1] = Integer.parseInt(st.nextToken());
            }


        }

    }
}

/*


*/