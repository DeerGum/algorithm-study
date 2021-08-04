package study.SWEA.농작물수확하기;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 농작물 수확하기
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB&categoryId=AV7GLXqKAWYDFAXB&categoryType=CODE&problemTitle=%EB%86%8D%EC%9E%91%EB%AC%BC&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int tc = Integer.parseInt(br.readLine());
        int n;
        int[][] farm;
        for (int t = 1; t <= tc; t++) {
            n = Integer.parseInt(br.readLine());
            farm = new int[n][n];

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < n; j++) {
                    farm[i][j] = str.charAt(j) - 48;
                }
            }
            
            int sum = 0;
            
            
            for(int i = 0, r = 1; i < n/2; i++,r+=2) {
                int p = n/2 - i;
                for (int j = 0; j < r; j++) {
                    sum += farm[i][p+j];
                    sum += farm[n-1-i][p+j];
                }
            }

            for (int i = 0; i < n; i++) //가로 중간 부분 더해줌
                sum += farm[n/2][i];    

            bw.write("#"+t+" "+sum+"\n");
        }
        bw.flush();
        bw.close();
        

    }
}

/*
h = n/2
                    a[0][h]
            a[1][h-1] a[1][h] a[1][h+1]
    a[2][h-2] a[2][h-1] a[2][h] a[2][h+1] a[2][h+2]
                    ...
            a[n-2][h-1] a[n-2][h] a[n-2][h+1]
                    a[n-1][h]
*/