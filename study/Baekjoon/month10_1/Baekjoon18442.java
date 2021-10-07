package study.Baekjoon.month10_1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 우체국
 * 링크 : https://www.acmicpc.net/problem/18442
 */

public class Baekjoon18442 {

    static int V, P;
    static long L;
    static long[] towns;
    static long minDist;
    static long[] minP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        L = Long.parseLong(st.nextToken());

        towns = new long[V];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < V; i++)
            towns[i] = Long.parseLong(st.nextToken());

        minDist = Long.MAX_VALUE; //최소 거리의 합
        minP = new long[P]; //최소 거리가 나오는 경찰서 위치
        combi(0, 0, new long[P]);

        bw.write(minDist + "\n");
        for (int i = 0; i < minP.length; i++)
            bw.write(minP[i] + " ");
        bw.newLine();
        bw.close();

    }

    public static void combi(int cnt, int start, long[] p) {
        if (cnt == P) {
            long distSum = 0;
            for (int i = 0; i < V; i++) {
                long min = Long.MAX_VALUE;
                for (int j = 0; j < P; j++) {
                    long len = (long) Math.abs(towns[i] - p[j]); //마을과 경찰서까지의 거리 절대값
                    long dist = Math.min(len, L - len); //마을과 경찰서까지의 거리
                    min = Math.min(dist, min); //거리가 최소이면 갱신

                }
                distSum += min; //거리의 합
            }

            if (distSum < minDist) { //지금 계산한 각 마을의 경찰서까지의 거리 합이 최소 거리합보다 작으면 갱신
                minDist = distSum;
                minP = p.clone();
            }

            return;
        }

        for (int i = start; i < V; i++) {
            p[cnt] = towns[i];
            combi(cnt + 1, i + 1, p);
        }
    }
}
    

/*


*/
