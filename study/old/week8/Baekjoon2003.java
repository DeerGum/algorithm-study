package study.old.week8;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 수들의 합2
 * 링크 : https://www.acmicpc.net/problem/2003
 * 알고리즘 분류
 * - 투포인터
 */
public class Baekjoon2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) 
            arr[i] = Integer.parseInt(st.nextToken());
        
        int slow = 0; 
        int fast = 0;
        int temp = 0;
        int count = 0;

        while(true) {
            if(temp >= m)
                temp -= arr[slow++];
            else if(fast == n)
                break;
            else
                temp += arr[fast++];

            if(temp == m)
                count++;
        }
        bw.write(count+"\n");
        bw.flush();
    }
}
