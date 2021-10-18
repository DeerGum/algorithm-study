package study.SWEA.etc.SWEA4311;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 오래된 스마트폰
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWL2vlPKMlQDFAUE&categoryId=AWL2vlPKMlQDFAUE&categoryType=CODE&problemTitle=%EC%8A%A4%EB%A7%88%ED%8A%B8%ED%8F%B0&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA4311 {
    static boolean[] useNum;
    static boolean[] useOp;
    static char[] op = { ' ', '+', '-', '*', '4' };
    static int N, O, M, W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            O = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            useNum = new boolean[10];
            useOp = new boolean[5];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int idx = Integer.parseInt(st.nextToken());
                useNum[idx] = true;
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < O; i++) {
                int idx = Integer.parseInt(st.nextToken());
                useOp[idx] = true;
            }

            W = Integer.parseInt(br.readLine());
        }


    }
}

/*
음...
1. 숫자만 눌러서 해결하는 경우

2. 백트래킹 최대 

0 1 2 3 4 7
+ - * /



*/