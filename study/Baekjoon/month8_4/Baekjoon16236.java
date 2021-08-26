package study.Baekjoon.month8_4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 아기 상어
 * 링크 : https://www.acmicpc.net/problem/16236
 */

public class Baekjoon16236 {
    static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}}; // 상 좌 하 우
    static int[] sharkPos;  //상어 좌표
    static int[][] map;
    static int currSize; // 아기상어 현재 크기
    static int sizeUp;  //다음 크기까지 남은 먹이의 갯수
    static int N;
    static int move;    //이동한 거리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        sharkPos = new int[2];
        currSize = 2;
        sizeUp = 2;
        move = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkPos[0] = i;
                    sharkPos[1] = j;
                    map[i][j] = 0;
                }
            }
        }

        while(bfs(sharkPos[0], sharkPos[1], new boolean[N][N]));    //먹이가 더 안나올 때까지 반복
        
        bw.write(move+"\n");
        bw.close();
    }

    public static boolean bfs(int r, int c, boolean[][] v) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c, 0});    // 행, 열, 움직인 거리
        v[r][c] = true;

        int minMove = -1;//먹이까지 움직인 거리
        int minR = -1;  //먹이의 행
        int minC = -1;  //먹이의 열
        while (!q.isEmpty()) {
        int[] t = q.poll();
            
            if (map[t[0]][t[1]] > 0 && map[t[0]][t[1]] < currSize) {    //먹이를 발견하면
                if (minMove == -1) {    //먹이를 처음 발견
                    minMove = t[2];
                    minR = t[0];
                    minC = t[1];
                } else if (minMove == t[2]) {    //가장 짧은 먹이
                    if (t[0] < minR || (t[0] == minR && t[1] < minC)) { //더 위쪽에 있거나 더 왼쪽에 있음
                        minR = t[0];
                        minC = t[1];
                    }
                } else //거리가 더 큰 먹이가 나옴, 탐색 불필요
                    break;                
            }

            for (int i = 0; i < dir.length; i++) {
                int dr = t[0] + dir[i][0];
                int dc = t[1] + dir[i][1];

                if (dr < 0 || dr >= N || dc < 0 || dc >= N || v[dr][dc] || map[dr][dc] > currSize) 
                    continue;
                
                q.offer(new int[]{dr, dc, t[2]+1});
                v[dr][dc] = true;
            }
        }

        if (minMove == -1) //먹이를 못찾음
            return false;
        
        if (--sizeUp == 0) {    //사이즈 업까지 필요한 먹이를 다 먹으면
            currSize++; //사이즈업
            sizeUp = currSize;
        }

        map[minR][minC] = 0;    //물고기 제거
        sharkPos[0] = minR; //상어 좌표 변경
        sharkPos[1] = minC; 
        move += minMove;
        return true;
        
    }
}

/*


*/
