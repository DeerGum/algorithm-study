package study.SWEA.month8_3.SWEA1247;

import java.io.*;
import java.util.ArrayList;
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
            perm(0, new boolean[N], new ArrayList<String>());
            System.out.println();

        }
    }

    public static void perm(int cnt, boolean[] v, ArrayList<String> list) {
        if (cnt == N) {
            
            return;
        }
        for (int i = 0; i < N; i++) {
            if (v[i]) 
                continue;
            v[i] = true;
            list.add((i+2)+"");
            perm(cnt+1, v,list);
            v[i] = false;
            list.remove((i+2)+"");
            
        }
    }
}

/*


*/