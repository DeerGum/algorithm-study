package study.week9;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제이름 : 암호 만들기
 * 링크 : https://www.acmicpc.net/problem/1759
 * 알고리즘 분류
 * - 백트래킹
 * - 브루트포스
 * - 조합론
 * - 문자열
 */

public class Baekjoon1759 {
    public static int l;
    public static int c;
    public static char[] pwd;
    public static boolean[] isVisited;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        pwd = new char[c];
        for (int i = 0; i < c; i++) 
            pwd[i] = st.nextToken().charAt(0);
        Arrays.sort(pwd);

        isVisited = new boolean[c];
        sb = new StringBuilder();

        password(0, 0);

        bw.write(sb.toString());
        bw.flush();


    }

    public static void password(int n, int lastIdx) {   //비밀번호 조합
        if(n == l) {
            if(!isValid())
                return;

            for (int i = 0; i < isVisited.length; i++) {
                if(isVisited[i])
                    sb.append(pwd[i]);
            }
            sb.append("\n");
            return;
        }

        for (int i = lastIdx; i < isVisited.length; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                password(n+1, i);
                isVisited[i] = false;
            }
        }
    }

    public static boolean isValid() {   //자음 2개, 모음 1개 이상인지 검사
        int consonant = 0, vowel = 0;
        for (int i = 0; i < isVisited.length; i++) {
            if(isVisited[i]) {
                switch(pwd[i]) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        vowel++;
                        break;
                    default:
                        consonant++;
                }
            }
        }

        return (consonant > 1 && vowel > 0);
    }
}