package study.SWEA.month9_2.SWEA8382;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 방향전환
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWyNQrCahHcDFAVP&categoryId=AWyNQrCahHcDFAVP&categoryType=CODE&problemTitle=8382&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA8382 {
    static int x1, x2, y1, y2;
    static int minCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st.nextToken()) + 100;
            y1 = Integer.parseInt(st.nextToken()) + 100;
            x2 = Integer.parseInt(st.nextToken()) + 100;
            y2 = Integer.parseInt(st.nextToken()) + 100;
            minCnt = 0;
            int x = Math.abs(x2 - x1);
            int y = Math.abs(y2 - y1);

            if ((x+y)%2 == 0) {
                minCnt = Math.max(x, y) * 2;
            } else {
                minCnt = Math.max(x, y) * 2 - 1;
            }

            bw.write("#"+t+" "+minCnt+"\n");
        }
        bw.close();

    }
}


/*
3
0 0 1 0
-1 -1 0 0
0 0 0 2

*/