package study.SWEA.month8_3.SWEA5644;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 무선 충전
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRDL1aeugDFAUo&categoryId=AWXRDL1aeugDFAUo&categoryType=CODE&problemTitle=%EB%AC%B4%EC%84%A0&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * 
 * 지도에 배터리 충전소 범위를 BFS로 탐색하면서 기록해놓음 (ArrayList로 받음)
 * 매 시간마다 각 사용자별로 충전유무를 확인하고 이동
 */

public class SWEA5644 {
    static int M, A;
    static int[][] move;    //이동목록
    static BC[] bc; //배터리충전소 목록
    static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};   //상 우 하 좌
    static ArrayList<Integer>[][] map;  //지도
    static int[][] u;   //사용자들의 현재 좌표
    static int result;  //최대 충전량
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            map = new ArrayList[10][10];
            for (int i = 0; i < 10; i++) 
                for (int j = 0; j < 10; j++) 
                    map[i][j] = new ArrayList<>(A);
                
            
            move = new int[2][M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) 
                move[0][i] = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) 
                move[1][i] = Integer.parseInt(st.nextToken());

            bc = new BC[A];
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                bc[i] = new BC(c, p);
                bfs(y, x, c, i+1, new boolean[10][10]); //문제의 그림이 좌표가 반대여서 탐색도 반대로 진행
            }
            
            u = new int[2][2];
            u[1][0] = 9;
            u[1][1] = 9;

            result = 0;
            for (int i = 0; i < M; i++) {
                charge();
                move(move[0][i], 0);
                move(move[1][i], 1);
            }
            charge();
            
            bw.write("#"+t+" "+result+"\n");
        }
        bw.close();
    }

    //영향을 끼치는 배터리충전소 번호를 좌표마다 저장
    public static void bfs(int x, int y, int range, int bcNum, boolean[][] v) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y,0});
        v[x][y] = true;
        while (!q.isEmpty()) {
            int[] t = q.poll();

            map[t[0]][t[1]].add(bcNum); 

            if (t[2] == range) 
                continue;

            for (int i = 0; i < dir.length; i++) {
                int dx = t[0] + dir[i][0];
                int dy = t[1] + dir[i][1];

                if (dx < 0 || dx >= 10 || dy < 0 || dy >= 10 || v[dx][dy]) 
                    continue;
                
                q.offer(new int[]{dx,dy,t[2]+1});
                v[dx][dy] = true;
            }
        }
    }

    public static void move(int d, int userNum) {
        if (d == 0) 
            return;
        u[userNum][0] += dir[d-1][0];
        u[userNum][1] += dir[d-1][1];
    }

    public static void charge() {
        int charging1 = map[u[0][0]][u[0][1]].size();
        int charging2 = map[u[1][0]][u[1][1]].size();
        
        if (charging1 > 0) {    //사용자1 좌표에 충전기가 있으면
            if (charging2 > 0) {    //사용자 모두 충전
                result += maxCharging(charging1, charging2);
            }
            else {  //사용자1 충전
                result += charging(charging1, 0);
            }
        }
        else {  
            if (charging2 > 0) { //사용자2 충전
                result += charging(charging2, 1);
            }
        }

        
    }

    public static int maxCharging(int c1, int c2) { //그 시간에 사용자 두명이 동시에 충전이 되면
        int max = 0;
        for (int i = 0; i < c1; i++) {
            for (int j = 0; j < c2; j++) {
                if (map[u[0][0]][u[0][1]].get(i) == map[u[1][0]][u[1][1]].get(j)) //같은 충전기이면
                    max = Math.max(max, bc[map[u[0][0]][u[0][1]].get(i)-1].p);
                else {  //다른 충전기이면
                    max = Math.max(max, bc[map[u[0][0]][u[0][1]].get(i)-1].p + bc[map[u[1][0]][u[1][1]].get(j)-1].p);
                }
            }
        }
        return max;
    }

    public static int charging(int c, int uNum) {   //그 시간에 사용자 한명만 충전이 되면
        int max = 0;
        for (int i = 0; i < c; i++) {
            max = Math.max(max, bc[map[u[uNum][0]][u[uNum][1]].get(i)-1].p);
        }
        return max;
    }
}

class BC {
    int c;  //충전범위
    int p;  //처리량
    public BC(int c, int p) {
        this.c = c;
        this.p = p;
    }
}

/*
1
20 3
2 2 3 2 2 2 2 3 3 4 4 3 2 2 3 3 3 2 2 3
4 4 1 4 4 1 4 4 1 1 1 4 1 4 3 3 3 3 3 3
4 4 1 100
7 10 3 40
6 3 2 70

 0  1  2  3  4  5  6  7  8  9 10 11
00 01 02 12 13 14 15 16 26 36 35 34
99 98 97 87 86 85 75 74 73 63 53 43


*/