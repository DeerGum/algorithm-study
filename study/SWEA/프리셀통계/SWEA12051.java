package study.SWEA.프리셀통계;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 프리셀 통계
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXmwMidaSLIDFARX
 * 실패
 */

public class SWEA12051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int tc = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());

            boolean isPossible = true;

            if (D > 0 && G == 0) {
                isPossible = false;
            } else if (D < 100 && G == 100) {
                isPossible = false;
            } else if (D != 0 && ((D * 0.01) * N) % 1 != 0) {
                isPossible = false;
            }

            if (isPossible) 
                bw.write("#"+t+" Possible\n");
            else
                bw.write("#"+t+" Broken\n");
        }
        bw.close();

    }
}

/*
총 진행한 게임 수 - G
오늘 진행한 최대 게임 수 - N
오늘 진행한 게임 수(D <= N) - D 
오늘 한 D판의 승률 - PD
지금까지한 G판의 승률 - PG

N PD PG
100 1 50

오늘 한판이라도 이겼으면 승률은 최소 1%
오늘 한판도 못이겼으면 승률은 최대 99%
이긴 판수는 무조건 정수


*/