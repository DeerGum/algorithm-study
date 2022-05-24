package study.nathan_algo_study.week13;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 돌던지기
 * 링크 : https://www.acmicpc.net/problem/3025
 */

public class Baekjoon3025 {
    static char[][] map;
    static int R, C, N;
    static int[][] dir = {{1,0},{1,-1},{1,1}};	//아래, 대각선 왼쪽 아래, 대각선 오른쪽 아래
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());	//행크기 입력
        C = Integer.parseInt(st.nextToken());	//열크기 입력

        map = new char[R][C];

        for (int i = 0; i < R; i++)
            map[i] = br.readLine().toCharArray();	//map 초기값 입력

        N = Integer.parseInt(br.readLine());	//화산탄  갯수 입력
        for (int i = 0; i < N; i++) {
            int c = Integer.parseInt(br.readLine()) - 1;	//화산탄 입력
            simulation(0, c);	//시뮬레이션
        }

        for (int i = 0; i < map.length; i++) {	//맵 출력
            bw.write(map[i]);
            bw.newLine();
        }
        bw.close();

    }
    /**
     * 시뮬레이션 후 map에 저장 (재귀적 호출을 이용한 dfs 방식)
     * @param r 행
     * @param c 열
     */
    public static void simulation(int r,int c) {
        //종료조건 - 아래 장애물이 있거나 마지막 행일 경우
        if(r == R-1 || (r < R-1 && map[r+1][c] == 'X')) {
            map[r][c] = 'O';
            return;
        }

        for (int i = 0; i < dir.length; i++) {
            int dr = r + dir[i][0];
            int dc = c + dir[i][1];

            if (dr >= R || dc < 0 || dc >= C) //배열의 범위를 안벗어나는지
                continue;

            switch (i) {
                case 0:	//아래
                    if (map[dr][dc] == '.') {	//갈 수 있으면
                        simulation(dr, dc);
                    } else {	//갈 수 없으면 넘어감
                        continue;
                    }
                    break;
                case 1:	//왼쪽 아래 대각선
                    if (map[r][c-1] == '.' && map[dr][dc] == '.') {	//왼쪽이 비어있으면
                        simulation(dr, dc);
                    }
                    else {	// 비어있지 않으면 넘어감
                        continue;
                    }
                    break;
                case 2:	//오른쪽 아래 대각선
                    if (map[r][c+1] == '.' && map[dr][dc] == '.') {	//오른쪽이 비어있으면
                        simulation(dr, dc);
                    }
                    else {	//종료조건 - 더이상 갈 곳이 없기 때문에 멈춤
                        map[r][c] = 'O';
                        return;
                    }
                    break;
            }
            break; //스위치문이 하나라도 실행되었으면 for문 종료
        }
    }
}

/*

*/
