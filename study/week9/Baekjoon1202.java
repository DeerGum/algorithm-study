package study.week9;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 보석 도둑
 * 링크 : https://www.acmicpc.net/problem/1202
 * 알고리즘 분류
 * - 자료구조
 * - 그리디
 * - 우선순위큐
 * - 정렬
 */

public class Baekjoon1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Jewelry[] jewelries = new Jewelry[n];
        int[] backpacks = new int[k];
        for (int i = 0; i < jewelries.length; i++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewelries[i] = new Jewelry(w, v);
        }
        Arrays.sort(jewelries);

        for (int i = 0; i < backpacks.length; i++) 
            backpacks[i] = Integer.parseInt(br.readLine());
        Arrays.sort(backpacks);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long result = 0;
        int j = 0;
        for (int i = 0; i < backpacks.length; i++) {
            while(j < n && jewelries[j].weight <= backpacks[i]) {
                pq.add(-jewelries[j].value);
                j++;
            }
            if(!pq.isEmpty()) 
                result += Math.abs(pq.poll());
        }

        bw.write(result+"\n");
        bw.flush();
    }
}

class Jewelry implements Comparable<Jewelry>{

    int weight;
    int value;

    public Jewelry(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(Jewelry o) {
        return this.weight - o.weight;
    }    
}
