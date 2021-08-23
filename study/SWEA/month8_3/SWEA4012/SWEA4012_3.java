package study.SWEA.month8_3.SWEA4012;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 요리사
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH
 * nextPerm으로 해결
 */

public class SWEA4012_3 {
    static int[][] table;
    static int N, R;
    static int result;
    static int[] select;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            N = Integer.parseInt(br.readLine());
            table = new int[N+1][N+1];
            for (int i = 1; i < N+1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < N+1; j++) 
                    table[i][j] = Integer.parseInt(st.nextToken());
            }
            R = N/2;
            result = Integer.MAX_VALUE;
            for (int i = R; i < N; i++) 
                select[i] = 1;  //절반은 1
            
            do {
                int sum1 = 0;
                int sum2 = 0;
                // 넥스트를 이용한 컴비네이션
                for (int i = 0; i < N; i++) {
                    for (int j = i+1; j < N; j++) {
                        if (select[i] != select[j]) 
                            continue;
                        if (select[i] == 1) 
                            sum1 += table[i][j] + table[j][i];
                        else
                            sum2 += table[i][j] + table[j][i];
                    }
                }
                result = Math.min(result, Math.abs(sum1-sum2));
            } while (np(N-1));

            bw.write("#"+t+" "+result+"\n");
        }
        bw.flush();
    }

    public static boolean np(int size) {
        int i = size;
        //맨 뒤의 i 찾음
        while (i > 0 && select[i-1] >= select[i]) 
            i--;
        // i가 0이면 마지막 순열
        if (i == 0) 
            return false;
        //i-1 위치값과 교환할 값 찾음
        int j = size;
        while (select[i-1] >= select[j]) 
            j--;
        // 위치 스왑
        swap(select, i, j);
        //i위치부터 맨뒤까지 오름차순 정렬
        int k = size;
        while (i < k) 
            swap(select, i++, k--);

        return true;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/*
a b c

ab ac bc 

d e f

4
4
0 5 3 8
4 0 4 1
2 5 0 3
7 2 3 0
4
0 7 1 1
7 0 6 2
1 1 0 2
10 1 9 0
6
0 37 26 52 77 20
32 0 15 26 75 16
54 33 0 79 37 90
92 10 66 0 92 3
64 7 89 89 0 21
80 49 94 68 5 0
6
0 73 30 81 27 94
98 0 91 9 97 24
51 100 0 35 41 98
26 26 96 0 26 90
73 37 39 57 0 16
90 88 97 9 95 0

*/