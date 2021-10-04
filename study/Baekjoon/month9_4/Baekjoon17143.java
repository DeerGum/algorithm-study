package study.Baekjoon.month9_4;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제이름 : 낚시왕
 * 링크 : https://www.acmicpc.net/problem/17143
 */

public class Baekjoon17143 {
    static Shark[][] map;
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
    static int R, C, M;
    static ArrayList<Shark> sharks;
    static int sizeSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Shark[R][C];
        sharks = new ArrayList<>();
        sizeSum = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int speed = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int size = Integer.parseInt(st.nextToken());

            Shark shark = new Shark(i + 1, r, c, speed, d, size); 
            sharks.add(shark);
            map[r][c] = shark;
        }

        for (int i = 0; i < C; i++) {
            if (sharks.size() == 0) 
                break;
            fishing(i);
            moveShark();
        }

        bw.write(sizeSum + "\n");
        bw.close();
    }
    
    public static void fishing(int c) {
        for (int i = 0; i < R; i++) {
            if (map[i][c] != null) {
                sizeSum += map[i][c].size;
                sharks.remove(map[i][c]);
                break;
            }
        }
    }
    
    public static void moveShark() {
        Shark[][] newMap = new Shark[R][C];

        for (int i = sharks.size() - 1; i >= 0; i--) {
            Shark shark = sharks.get(i);
            int mod;
            if (shark.d < 2)
                mod = (R - 1) * 2;
            else
                mod = (C - 1) * 2;

            int move = shark.speed % mod;

            int dr = shark.r;
            int dc = shark.c;
            int d = shark.d;
            while (move > 0) {
                dr += dir[d][0];
                dc += dir[d][1];

                if (dr < 0 || dr >= R || dc < 0 || dc >= C) {
                    dr -= dir[d][0];
                    dc -= dir[d][1];
                    d = (d < 2) ? (d + 1) % 2 : (d + 1) % 2 + 2;
                    continue;
                }

                move--;
            }

            shark.r = dr;
            shark.c = dc;
            shark.d = d;
            sharks.set(i, shark);
            
            if (newMap[dr][dc] != null) {   // 지도에 이미 상어가 있으면
                if (newMap[dr][dc].size < shark.size) { //크기 비교해서 기존 상어가 더 작으면
                    sharks.remove(newMap[dr][dc]);  //기존 상어 리스트에서 삭제하고 
                    newMap[dr][dc] = shark; //지도에도 변경
                } else 
                    sharks.remove(shark);   // 현재 상어가 더 작으면 리스트에서 삭제
            } else
                newMap[dr][dc] = shark;
            
        }

        map = newMap;
    }
    
}

class Shark{
    int num;
    int r;
    int c;
    int speed;
    int d;
    int size;

    public Shark(int num, int r, int c, int speed, int d, int size) {
        this.num = num;
        this.r = r;
        this.c = c;
        this.speed = speed;
        this.d = d;
        this.size = size;
    }
    
}

/*

상 하 우 좌
0  1  2  3

6 7 7
3 2 2 3 9
3 3 1 3 3
3 5 1 4 7
3 6 2 4 6
2 4 1 2 8
1 4 2 2 4
4 4 1 1 5


*/
