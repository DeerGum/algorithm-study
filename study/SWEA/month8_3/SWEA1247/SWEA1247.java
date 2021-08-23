package study.SWEA.month8_3.SWEA1247;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 최적 경로
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD&categoryId=AV15OZ4qAPICFAYD&categoryType=CODE&problemTitle=%EC%B5%9C%EC%A0%81&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&
 */

public class SWEA1247 {
    static int N;
    static int[] company;
    static int[] home;
    static int[][] customer;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            company = new int[2];
            home = new int[2];
            customer = new int[N][2];

            company[0] = Integer.parseInt(st.nextToken());
            company[1] = Integer.parseInt(st.nextToken());

            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) {
                customer[i][0] = Integer.parseInt(st.nextToken());
                customer[i][1] = Integer.parseInt(st.nextToken());
            }

            min = Integer.MAX_VALUE;
            perm(0, new boolean[N], new int[N]);
            bw.write("#"+t+" "+min+"\n");
        }
        bw.close();
    }
    public static int distance(int[] s, int[] t) {
        return Math.abs(s[0]-t[0]) + Math.abs(s[1]-t[1]);
    }

    public static void perm(int cnt, boolean[] v, int[] p) {
        if (cnt == N) {
            int len = 0;
            //회사에서 첫번째 고객까지
            len += distance(company, customer[p[0]]);
            //첫번째 고객에서 마지막 고객까지
            for (int i = 0; i < N-1; i++) 
                len += distance(customer[p[i]], customer[p[i+1]]);
            //마지막 고객에서 집까지
            len += distance(customer[p[N-1]], home);
            min = Math.min(min, len);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (v[i]) 
                continue;
            v[i] = true;
            p[cnt] = i;
            perm(cnt+1, v, p);
            v[i] = false;
        }
    }
}

/*


*/