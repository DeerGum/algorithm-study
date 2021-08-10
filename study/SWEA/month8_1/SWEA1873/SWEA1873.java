package study.SWEA.month8_1.SWEA1873;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 상호의 배틀필드
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LyE7KD2ADFAXc&categoryId=AV5LyE7KD2ADFAXc&categoryType=CODE&problemTitle=%EB%B0%B0%ED%8B%80%ED%95%84%EB%93%9C&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA1873 {
    static char[][] map;
    static char[] tank = {'^','v','<','>'};             //상하좌우
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};   //상하좌우
    static int h;
    static int w;
    static int tankX;
    static int tankY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            tankX = -1;
            tankY = -1;

            boolean pos = true;
            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = str.charAt(j);
                    if (pos) {
                        for (char c : tank) {   //탱크 좌표 저장
                            if (map[i][j] == c) {
                                tankX = i;
                                tankY = j;
                                pos = false;
                                break;
                            }
                        }    
                    }
                }
            }

            int n = Integer.parseInt(br.readLine());    //명령 개수 입력
            String command = br.readLine(); //명령어 입력
            command(n, command);    //명령 실행

            bw.write("#"+t+" ");
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    bw.write(map[i][j]);
                }
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();

    }

    public static void command(int n, String command) {
        for (int i = 0; i < n; i++) {
            char cmd = command.charAt(i);
            switch (cmd) {
                case 'U':
                    move(0, tankX, tankY);
                    break;
                case 'D':
                    move(1, tankX, tankY);
                    break;
                case 'L':
                    move(2, tankX, tankY);
                    break;
                case 'R':
                    move(3, tankX, tankY);
                    break;
                case 'S':
                    shoot(tankX, tankY);
                    break;
            }
        }
    }

    public static void move(int d, int x, int y) {  //d : 방향 (0-상 1-하 2-좌 3-우)
        map[x][y] = tank[d];
        int X = x + dir[d][0];
        int Y = y + dir[d][1];

        if (mapCheck(X, Y) || map[X][Y] != '.') //범위를 벗어나거나 평지가 아니면 종료
            return;
        
        map[X][Y] = tank[d];    //평지로 이동
        map[x][y] = '.';    //기존에 있던 자리 평지로 바꿈
        tankX = X;
        tankY = Y;
    }

    public static void shoot(int x, int y) {
        int d = 0;
        for (int i = 0; i < tank.length; i++) 
            if (map[x][y] == tank[i]) //탱크 방향 확인
                d = i;
        
        int shootX = x;
        int shootY = y;
        while(true) {
            shootX += dir[d][0];
            shootY += dir[d][1];
            if (mapCheck(shootX, shootY)) //포탄이 맵 벗어나면 종료
                break;
            
            if (map[shootX][shootY] == '*') { // 벽돌벽 만나면 부수고 종료
                map[shootX][shootY] = '.';
                break;
            } else if (map[shootX][shootY] == '#') {  //강철벽 만나면 종료
                break;
            }
        }   
    }

    public static boolean mapCheck(int x, int y) {
        return x < 0 || x >= h || y < 0 || y >= w;
    }
}

/*

문자 의미
.	평지(전차가 들어갈 수 있다.)
*	벽돌로 만들어진 벽
#	강철로 만들어진 벽
-	물(전차는 들어갈 수 없다.)
^	위쪽을 바라보는 전차(아래는 평지이다.)
v	아래쪽을 바라보는 전차(아래는 평지이다.)
<	왼쪽을 바라보는 전차(아래는 평지이다.)
>	오른쪽을 바라보는 전차(아래는 평지이다.)

문자 동작
U - 전차의 방향을 위로 변경 (+한칸 위가 평지면 이동)
D - 전차의 방향을 아래로 변경 (+한칸 아래가 평지면 이동)
L - 전차의 방향을 왼쪽으로 변경 (+한칸 왼쪽이 평지면 이동)
R - 전차의 방향을 오른쪽으로 변경 (+한칸 오른쪽이 평지면 이동)
S - 전차가 현재 바라보고 있는 방향으로 포탄 발사


의사코드

맵을 2차원 배열에 저장한다
    맵을 저장하면서 탱크의 좌표를 기억해둔다

명령어 갯수와 명령어를 저장한다

명령어 갯수만큼 명령어를 읽어서 실행한다

*/