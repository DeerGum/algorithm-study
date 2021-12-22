package study.SWEA.winter_session_1.SWEA2383;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 점심 식사시간
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5-BEE6AK0DFAVl&categoryId=AV5-BEE6AK0DFAVl&categoryType=CODE&problemTitle=%EC%A0%90%EC%8B%AC&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA2383 {
    static int N;
    static int P;
    static int[][] map;
    static ArrayList<int[]> people;
    static int[][] stairs;
    static int minTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            people = new ArrayList<>();
            stairs = new int[2][3];
            boolean firstStairs = true;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int item = Integer.parseInt(st.nextToken());
                    map[i][j] = item;
                    if (item == 1) {
                        people.add(new int[] { i, j });
                    } else if (item > 1) {
                        if (firstStairs) {
                            stairs[0] = new int[] { i, j, item };
                            firstStairs = false;
                        } else {
                            stairs[1] = new int[] { i, j, item };
                        }
                    }
                }
            }
            P = people.size();
            minTime = Integer.MAX_VALUE;
            combi(0, new boolean[P]);

            bw.write("#" + t + " " + minTime + "\n");
        }
        bw.close();
    }
    
    public static void combi(int cnt, boolean[] p) {
        if (cnt == P) {
            downStairs(p);
            return;
        }

        p[cnt] = true;
        combi(cnt + 1, p);
        p[cnt] = false;
        combi(cnt + 1, p);
    }
    
    public static void downStairs(boolean[] p) {
        int move = 0;
        LinkedList<Integer> go1 = new LinkedList<>();
        LinkedList<Integer> go2 = new LinkedList<>();
        for (int i = 0; i < p.length; i++) {
            if (p[i]) {
                move = Math.abs(people.get(i)[0] - stairs[0][0]) + Math.abs(people.get(i)[1] - stairs[0][1]);
                go1.add(move);
            } else {
                move = Math.abs(people.get(i)[0] - stairs[1][0]) + Math.abs(people.get(i)[1] - stairs[1][1]);
                go2.add(move);
            }

        }
        Collections.sort(go1);
        Collections.sort(go2);

        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();

        int maxTime = 0;
        int temp = 0;
        int timer = 1;
        while (!go1.isEmpty() || !go2.isEmpty() || !q1.isEmpty() || !q2.isEmpty()) {
            //계단에 도착한 즉시 계단을 이용했으면 time + 1 (0번ㅇ)
            while (!q1.isEmpty() && ((q1.peek()[0] != q1.peek()[1]) ? q1.peek()[0] : q1.peek()[0] + 1) + stairs[0][2] == timer) {
                q1.poll();
                maxTime = timer;
            }
            while (!q2.isEmpty() && ((q2.peek()[0] != q2.peek()[1]) ? q2.peek()[0] : q2.peek()[0] + 1) + stairs[1][2] == timer) {
                q2.poll();
                maxTime = timer;
            }
            
            while (q1.size() < 3 && !go1.isEmpty() && go1.get(0) <= timer) {
                temp = go1.removeFirst();
                q1.add(new int[]{timer, temp}); // 도착 시간과 
            }
            while (q2.size() < 3 && !go2.isEmpty() && go2.get(0) <= timer) {
                temp = go2.removeFirst();
                q2.add(new int[]{timer, temp});
            }

            timer++;
        }

        minTime = Math.min(minTime, maxTime);
    }
}

/*
10
5
0 1 1 0 0
0 0 1 0 3
0 1 0 1 0
0 0 0 0 0
1 0 5 0 0
5
0 0 1 1 0
0 0 1 0 2
0 0 0 1 0
0 1 0 0 0
1 0 5 0 0
6
0 0 0 1 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 1 0 0 0 0
2 0 1 0 0 0
0 0 2 0 0 0
6
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
1 0 0 0 0 0
0 0 0 2 0 4
7
0 0 0 0 0 0 0
0 0 0 0 0 0 4
0 0 0 0 1 0 0
1 0 0 1 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 2 0 0 0 0 0
7
0 0 0 0 0 0 0
7 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
2 0 0 0 0 1 0
0 0 0 0 0 0 0
8
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 2
0 0 0 0 0 0 0 0
2 0 0 0 0 0 0 0
0 0 0 0 0 1 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 1 0
0 0 0 0 1 0 0 0
8
3 0 0 0 0 0 5 0
0 0 0 0 0 0 0 0
1 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
1 0 1 1 0 0 0 0
0 0 0 0 0 0 1 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
9
0 0 0 1 0 0 0 0 0
0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 8
7 0 0 0 0 1 0 0 0
0 0 0 0 0 1 1 0 0
0 0 0 0 0 0 0 0 0
1 0 0 0 0 1 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
10
0 0 0 0 0 0 0 0 0 0
0 0 0 0 1 0 0 0 0 0
0 0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
3 0 1 0 1 0 0 0 0 2
1 1 0 0 1 0 1 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0

1
9
0 0 0 1 0 0 0 0 0
0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 8
7 0 0 0 0 1 0 0 0
0 0 0 0 0 1 1 0 0
0 0 0 0 0 0 0 0 0
1 0 0 0 0 1 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0

1번(2) 계단 1 2 3 4
2번(5) 계단 5 6

list1 = 2 2 2 3
2 2 2


list2 = 2 2

*/