package study.SWEA.month9_4.SWEA5604;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 구간 합
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXGGNB6cnEDFAUo&categoryId=AWXGGNB6cnEDFAUo&categoryType=CODE&problemTitle=5604&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA5604 {
    static long A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            A = Long.parseLong(st.nextToken());
            B = Long.parseLong(st.nextToken());

            
        }

    }
}

/*
38 61

40 ~ 49 = 4 x 10 + (1+9) x 10

3000 ~ 3999 = 3 x 1000 + 0 ~ 9
100 ~ 199 = 1 x 100 + 45 x 10 + 45 x 10
x10 ~ x99 = 1 x 10 + 2 x 10 + 3 x 10 + ... + 9 x 10
          = (1+2+3+...+9) x 10
          = 45 x 10

33 133
040 130

*/