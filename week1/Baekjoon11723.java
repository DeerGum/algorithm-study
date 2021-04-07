package week1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 집합
 * 링크 : https://www.acmicpc.net/problem/11723
 * 알고리즘 분류
 * - 비트마스킹
 */

public class Baekjoon11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int set = 0;
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int num;
        String cmd;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();
            switch(cmd) {
                case"add":
                    num = Integer.parseInt(st.nextToken());
                    set |= 1 << (num-1);
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    set &= ~(1 << (num-1));
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    bw.write(((set & 1 << num-1) > 0) ? "1\n" : "0\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    set ^= 1 << (num-1);
                    break;
                case "all":
                    set = (1<<21)-1;
                    break;
                case "empty":
                    set = 0;
                    break;
            }
        }
        bw.flush();
    }
}