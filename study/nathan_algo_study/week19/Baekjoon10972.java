package study.nathan_algo_study.week19;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 다음 순열
 * 링크 : https://www.acmicpc.net/problem/10972
 */

public class Baekjoon10972 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[] p = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            p[i] = Integer.parseInt(st.nextToken());


        if (np(p)) {
            for (int i = 0; i < N; i++)
                System.out.print(p[i]+" ");
        } else
            System.out.println("-1");

    }

    public static boolean np(int[] p) {
        int top = N - 1;

        //p[top-1] <p[top]을 충족하는 제일 마지막 인덱스 찾기
        while (top > 0 && p[top - 1] >= p[top])
            top--;

        //top이 0번 인덱스이면 마지막 순열이므로 종료
        if (top == 0)
            return false;

        int swapIdx = N - 1;

        //교환할 인덱스 찾기 -> 마지막인덱스부터 역순으로 순회하면서 p[top-1] < p[swapIdx] 만족하는 값
        while (p[top - 1] >= p[swapIdx])
            swapIdx--;

        //스왑
        swap(p, top - 1, swapIdx);

        //top 뒷부분 뒤집기
        int next = N - 1;
        while (top < next)
            swap(p, top++, next--);

        return true;
    }

    public static void swap(int[] p, int i, int j) {
        int temp = p[i];
        p[i] = p[j];
        p[j] = temp;
    }
}

/*

1 2 3

4 5 6

1 2 3 4 5 6
*/
