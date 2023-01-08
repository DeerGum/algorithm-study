package study.nathan_algo_study.week44;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 다중 일차 함수
 * 링크 : https://www.acmicpc.net/problem/26258
 */

public class Baekjoon26258 {
    static int N, Q;
    static int[][] pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        pos = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
        }
        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            double x = Double.parseDouble(br.readLine());
            bw.write(f(x)+"\n");
        }
        bw.close();
    }

    public static int f(double x) {
        int X = (int)Math.floor(x);
        int idx = binarySearch(X, 0, N);
        int gradient = pos[idx][1] - pos[idx+1][1];
        if (gradient > 0)
            return -1;
        else if (gradient == 0)
            return 0;
        else
            return 1;

    }

    public static int binarySearch(int x, int start, int end) {
        int low = start;
        int high = end;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (x == pos[mid][0])
                return mid;
            else if (x < pos[mid][0])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }
}

/*
1000000000
*/
