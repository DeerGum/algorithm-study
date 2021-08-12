package study.Baekjoon;

import java.io.*;

/**
 * 문제이름 : 백설 공주와 일곱 난쟁이
 * 링크 : https://www.acmicpc.net/problem/3040
 */

public class Baekjoon3040 {
    static int[] dwarf;
    static int N, R;
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = 9;
        R = 2;  //2명의 난쟁이만 뽑음
        dwarf = new int[N];
        sum = 0;    
        for (int t = 0; t < N; t++) {
            dwarf[t] = Integer.parseInt(br.readLine());
            sum += dwarf[t]; //아홉 난쟁이의 합 저장
        }

        combi(0, 0, new boolean[N], new int[R]);

    }

    public static void combi(int start, int cnt, boolean[] v, int[] p) {
        if (cnt == R) {
            if ( (sum - (p[0] + p[1])) == 100 ) {   // 뽑은 2명의 난쟁이를 빼고 100이 완성되면
                for (int i = 0; i < N; i++) {
                    if (!v[i]) 
                        System.out.println(dwarf[i]);
                }
            }
            return;
        }

        for (int i = start; i < N; i++) {
            if (v[i]) 
                continue;
            
            v[i] = true;
            p[cnt] = dwarf[i];
            combi(i+1, cnt+1, v, p);
            v[i] = false;
        }
    }
}

/*

*/
