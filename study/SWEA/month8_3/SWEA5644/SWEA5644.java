package study.SWEA.month8_3.SWEA5644;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 무선 충전
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRDL1aeugDFAUo&categoryId=AWXRDL1aeugDFAUo&categoryType=CODE&problemTitle=%EB%AC%B4%EC%84%A0&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA5644 {
    static int M, A;
    static int[] p1, p2;
    static BC[] bc;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            p1 = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) 
                p1[i] = Integer.parseInt(st.nextToken());
            
            p2 = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) 
                p2[i] = Integer.parseInt(st.nextToken());

            bc = new BC[A];
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                bc[i] = new BC(x, y, c, p);
            }

            

        }
    }
}

class BC {
    int x;  //행
    int y;  //열
    int c;  //충전범위
    int p;  //처리량
    public BC(int x, int y, int c, int p) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.p = p;
    }
}

/*


*/