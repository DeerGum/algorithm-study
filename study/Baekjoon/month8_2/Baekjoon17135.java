package study.Baekjoon.month8_2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 캐슬디펜스
 * 링크 : https://www.acmicpc.net/problem/17135
 */

public class Baekjoon17135 {
    static int[][] map;
    static int[][] temp;
    static int N, M, D;
    static int A = 3;   //궁수 수
    static int killCount;
    static int maxKillCount;
    static int[][] dir = {{0,-1},{-1,0},{0,1}}; // 좌 상 우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        map = new int[N+1][M];
        temp = new int[N+1][M];
        maxKillCount = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) 
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        combi();
        bw.write(maxKillCount+"\n");
        bw.close();
        
    }

    public static void combi() {    //궁수 수만큼 조합
        for (int i = 0; i < M; i++) {
            for (int j = i+1; j < M; j++) {
                for (int k = j+1; k < M; k++) {
                    simulation(new int[]{i,j,k});
                }
            }
        }

    }

    public static void simulation(int[] archer) {
        arrInit(temp);  //배열 초기화
        killCount = 0;
        for (int i = N; i >= 1; i--) {  //궁수가 한줄씩 올라가면서 적을 쏨
            shoot(i, archer[0]);
            shoot(i, archer[1]);
            shoot(i, archer[2]);
            clearDeath(i, temp);    //시체 정리

        }
        maxKillCount = Math.max(killCount, maxKillCount);
    }

    public static void shoot(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r-1,c,1});  //{행, 열, 거리} - 궁수의 바로 위 좌표부터 탐색

        while (!q.isEmpty()) {
            int[] t = q.poll();

            if (t[2] > D || temp[t[0]][t[1]] == -1) //거리가 넘어가거나 죽인 적을 발견하면
                return;

            if (temp[t[0]][t[1]] == 1) {    //적을 발견하면
                killCount++;
                temp[t[0]][t[1]] = -1;  //시체표시
                return;
            }
            
            for (int i = 0; i < dir.length; i++) {
                int R = t[0] + dir[i][0];
                int C = t[1] + dir[i][1];

                if (R < 0 || C < 0 || C >= M ) //범위를 벗어나면
                    continue;
                
                q.offer(new int[]{R,C,t[2]+1});
            }

        }
    }

    public static void clearDeath(int r, int[][] arr) { //한턴이 끝나면 시체(-1)를 0으로 바꿈
        for (int i = 0; i <= r; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == -1) 
                    arr[i][j] = 0;
            }
        }
    }

    public static void arrInit(int[][] arr) {
        for (int i = 0; i < map.length; i++) 
            System.arraycopy(map[i], 0, arr[i], 0, map[i].length);
    }
}

/*
5 5 1
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0

*/
