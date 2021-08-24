package study.Baekjoon.etc.SWEA1234;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 비밀번호
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14_DEKAJcCFAYD&categoryId=AV14_DEKAJcCFAYD&categoryType=CODE&problemTitle=%EB%B9%84%EB%B0%80%EB%B2%88%ED%98%B8&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA1234 {
    static int len;
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = 10;
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            len = Integer.parseInt(st.nextToken());
            str = st.nextToken();
            bw.write("#"+t+" "+getPassword()+"\n");
        }
        bw.close();
    }

    public static String getPassword() {
        StringBuilder sb = new StringBuilder(str);
        char c = sb.charAt(0);
        for (int i = 1; i < sb.length(); i++) {
            if (c == sb.charAt(i)) {
                sb.delete(i-1, i+1);
                i-=2;
                if (i < 0) 
                    i++;
            } 
            c = sb.charAt(i);
        }
        return sb.toString();
    }
}

/*
10 1123323456

10 1238099084
16 4100112380990844
26 12380990844100112380990844
42 123809908444100112380990844100112380990844
55 1238099084441001123809908441001321238099084432180990844
60 123809908444100145351123809908441001321238099084432180990844
71 12380990844410013218099084441001123809908441001321238099084432180990844
99 123809908444100180990844410013211238099084410013212380990844123809908441238099084410013232180990844
82 1238099084441001410011238099084412380990844100132123809908441238099084432180990844
58 0899809812380990844100132123809908441238099084432180990844

*/