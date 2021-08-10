package study.SWEA.month8_1.SWEA1208;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : Flatten
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh&categoryId=AV139KOaABgCFAYh&categoryType=CODE&problemTitle=fla&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * 알고리즘 분류
 * - 
 */

public class SWEA1208 {
    public static int[] boxs;
    public static int max;
    public static int maxIdx;
    public static int min;
    public static int minIdx;
    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tc = 10;
        
        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            boxs = new int[100];
            max = 0;
            maxIdx = -1;
            min = 101;
            minIdx = -1;
            result = 0;

            for (int i = 0; i < boxs.length; i++) 
                boxs[i] = Integer.parseInt(st.nextToken());
            
            dump(n);
            bw.write("#"+t+" "+result+"\n");

        }
        bw.flush();
    }

    public static void dump(int n) {
        for (int i = 0; i < n; i++) {
            max();
            min();
            if(max - min < 2) 
                break;
            
            boxs[maxIdx]--;
            boxs[minIdx]++;
        }
        max();
        min();
        result = max - min;
    }
    public static void max() {
        max = 0;
        for (int i = 0; i < boxs.length; i++) {
            if (max < boxs[i]) {
                max = boxs[i];
                maxIdx = i;
            }
        }
    }

    public static void min() {
        min = 101;
        for (int i = 0; i < boxs.length; i++) {
            if (min > boxs[i]) {
                min = boxs[i];
                minIdx = i;
            }
        }
    }
}

/*
5 8 3 2 5 6 8 8 3 2 4

2 2 3 3 4 5 5 6 8 8 8

3 2 3 3 4 5 5 6 8 8 7




*/