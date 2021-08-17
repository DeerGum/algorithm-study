package study.Baekjoon.month8_1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : N과 M (1)
 * 링크 : https://www.acmicpc.net/problem/15649
 * 알고리즘 분류
 * - 구현
 */

public class Baekjoon15649 {
	
	static int[] nums;
	static boolean[] visited;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[M];
        visited = new boolean[N+1];
		
		sequence(0);
	}

	public static void sequence(int n) {
		if (n == M) {
			for (int i = 0; i < nums.length; i++) 
				System.out.print(nums[i]+" ");
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (visited[i]) 
				continue;
			
			visited[i] = true;
			nums[n] = i;
			sequence(n+1);

			visited[i] = false;
			
		}
	}

	
}