package study.SWEA.month8_1.SWEA1289;

import java.io.*;

/**
 * 문제이름 : 원재의 메모리 복구하기
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV19AcoKI9sCFAZN&categoryId=AV19AcoKI9sCFAZN&categoryType=CODE&problemTitle=%EC%9B%90%EC%9E%AC&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&
 */

public class SWEA1289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        int count;
        for (int t = 1; t <= tc; t++) {
            String memory = br.readLine();
            count = 0;
            char prev = '0';
            for (int i = 0; i < memory.length(); i++) {
                char bit = memory.charAt(i);
                if (bit != prev) {
                    prev = bit;
                    count++;
                }
            }
            bw.write("#"+t+" "+count+"\n");
        }
        bw.flush();
    }
}

/*
100101

000000
111111
100000
100111
100100
100101



*/