package study.Baekjoon.month8_3;

import java.io.*;

/**
 * 문제이름 : 설탕배달
 * 링크 : https://www.acmicpc.net/problem/2839
 */

public class Baekjoon2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        while (n % 5 != 0) {
            n -= 3;
            count++;
        }

        if (n < 0) {
            count = -1;
        } else {
            count += n / 5;
        }

        bw.write(count+"\n");
        bw.flush();
        
    }
}

/*


*/
