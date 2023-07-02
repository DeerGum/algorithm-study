package study.nathan_algo_study.week60;

import java.io.*;
import java.util.*;

/**
 * 문제이름 : 접두사
 * 링크 : https://www.acmicpc.net/problem/1141
 */

public class Baekjoon1141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        List<String> input = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++)
            input.add(br.readLine());

        input.sort(Comparator.comparingInt(String::length).reversed());


    }
}

class Tree {
    public char value;
    public Tree next;

    public Tree() {
        this.value = 0;
        this.next = null;
    }

}

/*

*/
