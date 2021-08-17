package study.Baekjoon.month8_2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제이름 : 치킨 배달
 * 링크 : https://www.acmicpc.net/problem/15686
 */

public class Baekjoon15686 {
    static int N, M;
    static ArrayList<int[]> house;
    static ArrayList<int[]> chicken;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 1) 
                    house.add(new int[]{i,j});
                if (input == 2) {
                    chicken.add(new int[]{i,j});
                }
            }
        }

        min = Integer.MAX_VALUE;
        combi(0, 0, new int[M]);

        bw.write(min+"\n");
        bw.close();

    }

    public static void combi(int start, int cnt, int[] combiChicken) {
        if (cnt == M) {
            distance(combiChicken);
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            combiChicken[cnt] = i;
            combi(i+1, cnt+1, combiChicken);
        }
    }

    public static void distance(int[] combiChicken) {
        int result = 0;
        for (int i = 0; i < house.size(); i++) {
            int[] h = house.get(i);
            int distance = Integer.MAX_VALUE;
            for (int j = 0; j < combiChicken.length; j++) {
                int[] c = chicken.get(combiChicken[j]);
                distance = Math.min((int)Math.abs(h[0] - c[0]) + (int)Math.abs(h[1] - c[1]), distance);
            }
            result += distance;
        }
        min = Math.min(result, min);
    }

}

/*


*/
