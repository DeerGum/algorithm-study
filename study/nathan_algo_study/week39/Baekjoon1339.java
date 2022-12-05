package study.nathan_algo_study.week39;

import java.io.*;
import java.util.*;

/**
 * 문제이름 : 단어 수학
 * 링크 : https://www.acmicpc.net/problem/1339
 */

public class Baekjoon1339 {
    static Character[] alphabets;
    static Map<Character, Integer> map;
    static int N;
    static int maxValue;
    static String[] words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        words = new String[N];
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            words[i] = input;
            for (int j = 0; j < input.length(); j++)
                set.add(input.charAt(j));
        }

        alphabets = set.toArray(new Character[0]);

        perm(0, words.length, new int[words.length], new boolean[words.length]);


    }

    public static void perm(int cnt, int n, int[] p, boolean[] v) {
        if (cnt == n) {
            map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(alphabets[i],p[i]);
            }

            return;
        }

        for (int i = 0; i < n; i++) {
            if (v[i])
                continue;

            p[cnt] = i;
        }

    }

    public static void findMaxSum() {


    }
}

/*

1000000000


*/
