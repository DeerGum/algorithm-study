package study.SWEA.백만장자프로젝트;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 백만 장자 프로젝트
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LrsUaDxcDFAXc
 */

public class SWEA1859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) 
                arr[j] = Integer.parseInt(st.nextToken());
            long profit = 0;
            int maxPrice = 0;
            for (int j = arr.length-1; j >= 0; j--) {
                if(arr[j] >= maxPrice) {
                    maxPrice = arr[j];
                }
                else {
                    profit += maxPrice - arr[j];
                }
            }
            bw.write("#"+(i+1)+" "+profit);
            bw.newLine();
        }
        bw.flush();

    }
}
