package study.SWEA.month8_1.SWEA1954;

import java.io.*;


/**
 * 문제이름 : 달팽이 숫자
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq&categoryId=AV5PobmqAPoDFAUq&categoryType=CODE&problemTitle=%EB%8B%AC%ED%8C%BD%EC%9D%B4&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA1954 {
    public static int[][] snail;
    public static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};    //우 하 좌 상
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            snail = new int[n][n];

            drawSnail(n);

            bw.write("#"+(t+1)+"\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) 
                    bw.write(snail[i][j]+" ");
                bw.newLine();
            }
            bw.flush();
        }
        

    }

    public static void drawSnail(int n) {
        int r = 0;
        int c = -1;
        int d = 0;  // 0:오른쪽 1:아래 2:왼쪽 3:위 

        for (int i = 1; i <= n*n; i++) {
            r += dir[d][0];
            c += dir[d][1];
            
            snail[r][c] = i;
            
            int R = r + dir[d][0];  //다음 칸 확인
            int C = c + dir[d][1];  //다음 칸 확인

            
            if(R < 0 || R >= n || C < 0 || C >= n || snail[R][C] != 0)
            //다음 칸이 범위를 벗어나거나 이미 채워진 칸이면
                d = (d+1)%4;    //방향전환
            
        }

    }
}