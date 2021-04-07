package week1;

import java.io.*;

/**
 * 문제이름 : 막대기
 * 링크 : https://www.acmicpc.net/problem/1094
 * 알고리즘 분류
 * - 수학
 * - 비트마스킹
 */

public class Baekjoon1094{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(br.readLine());

        int result = 64;    //막대의 총 길이
        int shortest = 64;  //가장 짧은 막대 길이
        int count = 1;      //막대의 갯수

        while(result > x) {
            shortest >>= 1;
            if(result-shortest >= x)
                result -= shortest;
            else
                count++;
        }
        bw.write(count+"\n");
        bw.flush();
    }
}