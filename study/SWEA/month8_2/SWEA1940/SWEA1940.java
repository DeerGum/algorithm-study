package study.SWEA.month8_2.SWEA1940;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 가랏! RC카!
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PjMgaALgDFAUq&categoryId=AV5PjMgaALgDFAUq&categoryType=CODE&problemTitle=%EA%B0%80%EB%9E%8F%21&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA1940 {
    static int n;
    static int curSpeed;
    static int distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        int cmd, dSpeed;
        for (int t = 1; t <= tc; t++) {
            n = Integer.parseInt(br.readLine());
            curSpeed = 0;
            distance = 0;
            
            for (int i = 0; i< n; i++) {
                st = new StringTokenizer(br.readLine());
                cmd = Integer.parseInt(st.nextToken());
                if (cmd != 0)
                    dSpeed = Integer.parseInt(st.nextToken());
                else
                    dSpeed = 0;
                move(cmd, dSpeed);
            }
            

            bw.write("#"+t+" "+distance+"\n");
        }
        bw.close();

    }

    public static void move(int cmd, int dSpeed) {
        if (cmd == 1) {
            curSpeed += dSpeed;
        } else if(cmd == 2) {
            if (dSpeed > curSpeed)
                curSpeed = 0;
            else
                curSpeed -= dSpeed;
        } 
        distance += curSpeed;
    }
}

/*
3
2
1 2
2 1
3
1 1
0
1 1
5
1 2
1 2
2 1
0
0
*/