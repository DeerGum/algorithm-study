package study.SWEA.month8_1.SWEA1210;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : Ladder1
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh&categoryId=AV14ABYKADACFAYh&categoryType=CODE&problemTitle=ladder&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&
 */

public class SWEA1210 {
    public static int[][] ladder;
    public static boolean[][] visited;
    public static int[][] dir = {{0,-1},{0,1},{1,0}};   //왼쪽 오른쪽 아래
    public static int win;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int t = 1; t <= 10; t++) {
            int tc = Integer.parseInt(br.readLine());
            ladder = new int[100][100];
            win = -1;

            for (int i = 0; i < ladder.length; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < ladder[i].length; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < ladder[0].length; i++) {
                if (ladder[0][i] == 1) {
                    visited = new boolean[100][100];
                    search(0, i, i);
                }
            }

            bw.write("#"+tc+" "+win+"\n");
        }
        bw.flush();
    }

    public static void search(int r, int c, int startPos) {
        if (ladder[r][c] == 2) {
            win = startPos;
            return;
        }
        visited[r][c] = true;

        for (int i = 0; i < dir.length; i++) {
            int R = r + dir[i][0];
            int C = c + dir[i][1];

            if (R < 0 || R >= 100 || C < 0 || C >= 100 || ladder[R][C] == 0 || visited[R][C]) 
                continue;

            search(R, C, startPos);
            break;  //한방향으로 이동했으면 반복문 종료
        }
    }
}