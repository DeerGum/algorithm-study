package study.Baekjoon.etc;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 크로스워드 만들기
 * 링크 : https://www.acmicpc.net/problem/2804
 */

public class Baekjoon2804 {
    static char[][] words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s1 = st.nextToken();
        String s2 = st.nextToken();
        words = new char[s2.length()][s1.length()];

        cross(s1, s2);

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length; j++) {
                bw.write(words[i][j]+"");
            }
            bw.newLine();
        }
        bw.close();
    }

    public static void cross(String s1, String s2) {
        int s1Idx = -1;
        int s2Idx = -1;
        check:
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            for (int j = 0; j < s2.length(); j++) {
                char c2 = s2.charAt(j);
                if (c1 == c2) {
                    s1Idx = i;
                    s2Idx = j;
                    break check;
                }
            }
        }

        for (int i = 0; i < words.length; i++) 
            for (int j = 0; j < words[i].length; j++) 
                words[i][j] = '.';

        for (int i = 0; i < words[0].length; i++) 
            words[s2Idx][i] = s1.charAt(i);
        
        for (int i = 0; i < words.length; i++) 
            words[i][s1Idx] = s2.charAt(i);

    }
}

/*


*/
