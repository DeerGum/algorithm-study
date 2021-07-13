package study.week11;

import java.io.*;

/**
 * 문제이름 : 문자열폭발
 * 링크 : https://www.acmicpc.net/problem/9935
 * 알고리즘 분류
 * - 문자열
 * - 스택
 * - 자료구조
 */

public class Baekjoon9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String bombStr = br.readLine();
        int strLen = str.length();
        int bomLen = bombStr.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strLen; i++) {
            char c = str.charAt(i);
            sb.append(c);
            if(sb.length() >= bomLen) {
                boolean isSame = true;
                for(int idx = 0; idx < bomLen; idx++) {
                    char c1 = sb.charAt(sb.length() - bomLen + idx);
                    char c2 = bombStr.charAt(idx);
                    if(c1 != c2) {
                        isSame = false;
                        break;
                    }
                }
                if(isSame) 
                    sb.delete(sb.length() - bombStr.length(), sb.length());
            }
        }

        if(sb.length() == 0) 
            bw.write("FRULA\n");
        else 
            bw.write(sb.toString()+"\n");
        bw.flush();
    }

    
}
