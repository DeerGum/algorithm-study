package study.SWEA.month8_2.SWEA5215;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 햄버거다이어트
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT&categoryId=AWT-lPB6dHUDFAVT&categoryType=CODE&problemTitle=%ED%96%84%EB%B2%84%EA%B1%B0&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA5215_2 {
    static int n, l;
    static int[][] scoreAndCalorie;
    static int maxScore;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            scoreAndCalorie = new int[n][2];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                scoreAndCalorie[i][0] = Integer.parseInt(st.nextToken());
                scoreAndCalorie[i][1] = Integer.parseInt(st.nextToken());
            }
            maxScore = knapsack(0, 0, l);

            bw.write("#"+t+" "+maxScore+"\n");
        }
        bw.close();
    }

    public static int knapsack(int cnt, int sumScore, int limitCalorie) {
        if (limitCalorie < 0) // 칼로리 오버되면 실패
            return 0;

        if (limitCalorie == 0) 
            return sumScore;

        if (cnt == n)   //모든 음식 확인
            return sumScore;    
            
        //햄버거에 재료를 넣으면 점수 증가, 제한 칼로리 감소
        int m1 = knapsack(cnt+1, sumScore+scoreAndCalorie[cnt][0], limitCalorie-scoreAndCalorie[cnt][1]);

        //재료를 넣지 않으면 그대로
        int m2 = knapsack(cnt+1, sumScore, limitCalorie);
        return Math.max(m1, m2);
    }
}

/*


*/