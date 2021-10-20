package study.SWEA.etc.PreTest1.Pro2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2 {
    static int N;
    static int[] pops;
    static int maxSum;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            N = Integer.parseInt(br.readLine());

            pops = new int[N];
            maxSum = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int pop = Integer.parseInt(st.nextToken());
                pops[i] = pop;
            }

            combi1(0, 0, new int[2], new int[N]);
            bw.write("#" + t + " " + maxSum + "\n");
        }
        bw.close();
    }

    public static void combi1(int start, int cnt, int[] p1, int[] v) { // 첫번째 노선
        if (cnt == 2) {
            combi2(0, 0, p1, new int[2], v);
            return;
        }

        for (int i = start; i < pops.length; i++) {
            if (v[i] > 0)
                continue;

            p1[cnt] = i;
            v[(N + i - 1) % N]++;
            v[i]++;
            v[(i + 1) % N]++;

            combi1(i + 1, cnt + 1, p1, v);

            v[(N + i - 1) % N]--;
            v[i]--;
            v[(i + 1) % N]--;
        }

    }

    public static void combi2(int start, int cnt, int[] p1, int[] p2, int[] v) { // 두번째 노선
        if (cnt == 2) {
            if (isCheck(p1, p2))
                maxSum = Math.max(maxSum, cal(p1, p2));
            return;
        }

        for (int i = start; i < pops.length; i++) {
            if (v[i] > 0)
                continue;

            p2[cnt] = i;
            v[(N + i - 1) % N]++;
            v[i]++;
            v[(i + 1) % N]++;

            combi2(i + 1, cnt + 1, p1, p2, v);

            v[(N + i - 1) % N]--;
            v[i]--;
            v[(i + 1) % N]--;
        }

    }

    public static boolean isCheck(int[] p1, int[] p2) { // 교차되는지 안되는지
        if ((p1[0] < p2[0] && p1[1] > p2[1]) || (p1[0] > p2[0] && p1[1] < p2[1])) {
            return true;
        } else {
            return false;
        }
    }

    public static int cal(int[] p1, int[] p2) {
        int a = pops[p1[0]] + pops[p1[1]];
        int b = pops[p2[0]] + pops[p2[1]];
        return (a * a) + (b * b);
    }
}

/*
 0 1 2 3 4 5 6 7 8 9 80 90 65 55 90 60 40 35 30 25
 
 1 4 0 2 5 3 6 7 8 9 90 90 80 65 60 55 40 35 30 25
 
 두 제곱할 수의 차이가 크면 커진다 안되는경우 1. 교차될때 2. 두 직통 노선의 역이 인접할 때 3. 노선을 연결하는 두 역이 인접할 때
 
 2 4 0 6
 
 0 4 6 9
 
 허용 1 7 3 5 , 0 6 2 4
 
 불가 0 4 2 7
 
 20C2
 
 20 x 19 / 2 190
 
 8 0 1 2 3 4 5 6 7 30 25 70 55 95 75 90 20
 
 
 
 */