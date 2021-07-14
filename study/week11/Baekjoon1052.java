package study.week11;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 물병
 * 링크 : https://www.acmicpc.net/problem/1052
 * 알고리즘 분류
 * - 그리디알고리즘
 * - 비트마스킹
 * - 구현
 */

public class Baekjoon1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int newBottles = 0;

		  while(Integer.bitCount(n) > k) {
			  n++;
			  newBottles++;
		  }
        
        bw.write(newBottles+"\n");
    }
}
