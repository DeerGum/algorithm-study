package study.Baekjoon.etc;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 영식이와 친구들
 * 링크 : https://www.acmicpc.net/problem/1592
 */

public class Baekjoon1592 {
    static int N, M, L;
    static int[] arr;
    static int idx;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        idx = 0;
        count = 0;
        arr = new int[N];
        play();
        bw.write(count + "");
        bw.close();
    }
    
    public static void play() {
        arr[idx]++;

        while (arr[idx] != M) {
            if (isArrayValueOdd(idx)) {
                idx = (idx + L) % N;
            } else {
                int sub = idx - L;
                idx = (sub < 0) ? (N + sub) : sub;
            }
            arr[idx]++;
            count++;
        }


    }
    
    public static boolean isArrayValueOdd(int idx) {
        if (arr[idx] % 2 == 1)
            return true;
        else
            return false;
    }
}

/*


*/
