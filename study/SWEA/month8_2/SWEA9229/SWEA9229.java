package study.SWEA.month8_2.SWEA9229;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 한빈이와 Spot Mart
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN&categoryId=AW8Wj7cqbY0DFAXN&categoryType=CODE&problemTitle=%ED%95%9C%EB%B9%88&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA9229 {
    static int n, m;
    static int[] snack;
    static int maxWeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            snack = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                snack[i] = Integer.parseInt(st.nextToken());
            }

            maxWeight = -1;
            subSet(0, 0, 0);

            bw.write("#"+t+" "+maxWeight+"\n");
        }
        bw.close();
    }

    public static void subSet(int cnt, int pickUp, int weight) {
        if (weight > m) {
            return;
        }
        
        if (pickUp == 2) {
            maxWeight = Math.max(maxWeight, weight);
            return;
        }

        if (cnt == n) {
            return;
        }

        subSet(cnt+1, pickUp, weight);

        subSet(cnt+1, pickUp+1, weight+snack[cnt]);
    }
}

/*

*/