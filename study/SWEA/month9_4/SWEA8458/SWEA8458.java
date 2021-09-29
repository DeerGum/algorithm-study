package study.SWEA.month9_4.SWEA8458;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 원점으로 집합
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWzaq5KKk_ADFAVU&categoryId=AWzaq5KKk_ADFAVU&categoryType=CODE&problemTitle=%EC%9B%90%EC%A0%90&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA8458 {
    static final int P = 150000;    //최대 입력 범위에 대응할 수 있는 움직임 수
    static int N;
    static long[][] point;
    static long maxDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            N = Integer.parseInt(br.readLine());
            point = new long[N][2];
            maxDist = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                point[i][0] = Integer.parseInt(st.nextToken());
                point[i][1] = Integer.parseInt(st.nextToken());

                maxDist = Math.max(maxDist, dist(point[i][0], point[i][1]));    //좌표의 최대 길이 반환
            }

            if (isPossible()) { //모두 원점으로 이동 가능하면
                bw.write("#" + t + " " + move() + "\n");
            } else
                bw.write("#" + t + " " + (-1) + "\n");

        }
        bw.close();

    }
    
    public static long move() { //최소 몇번 움직이는지 확인
        long cnt = 0;
        long dist = 0;
        while (dist < maxDist || Math.abs(maxDist - dist) % 2 != 0) {
            //지금까지 움직인 거리(dist)가 최대 거리보다 크거나 같고 둘의 차이가 짝수이면
            dist += ++cnt;
        }
        
        return cnt;
    }
    
    public static boolean isPossible() {    //모든 좌표의 길이가 홀수인지 짝수인지 판별
        long p1 = dist(point[0][0], point[0][1]) % 2;

        for (int i = 1; i < N; i++) {
            long p2 = dist(point[i][0], point[i][1]) % 2;
            if (p1 != p2)
                return false;
        }

        return true;
    }
    
    public static long dist(long x, long y) {   //좌표의 길이 반환
        return Math.abs(x) + Math.abs(y);
    }
}

/*
3
2
0 0
0 0
2
-6 0
3 3
2
-5 0
2 1

1
2
-5 0
2 1

1
2
-6 0
3 3

*/