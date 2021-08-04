package study.Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 스위치 켜고 끄기
 * 링크 : https://www.acmicpc.net/problem/1244
 * 알고리즘 분류
 * - 구현
 */

public class Baekjoon1244 {
	static int n;
	static int[] switchs;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
		switchs = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < switchs.length; i++)
			switchs[i] = Integer.parseInt(st.nextToken());

		int student = Integer.parseInt(br.readLine());	//학생수
		for (int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());	//성별
			int num = Integer.parseInt(st.nextToken());		//스위치번호
			if (gender == 1) 
				male(num);
			else
				female(num);
		}

		for (int i = 1; i < switchs.length; i++) {
			bw.write(switchs[i]+" ");
			if( i % 20 == 0)
				bw.newLine();
		}
			
		bw.flush();
		
	}

	public static void male(int num) {
		for (int i = num; i < switchs.length; i+=num) {
			switchs[i] = (switchs[i]+1)%2;
		}
	}

	public static void female(int num) {
		int prev = num - 1;
		int next = num + 1;
		switchs[num] = (switchs[num]+1)%2;
		while (true) {
			if (prev < 1 || next > n || switchs[prev] != switchs[next]) //배열범위를 넘어가거나 양쪽이 다르면 멈춤
				break;
			
			switchs[prev] = (switchs[prev]+1)%2;
			switchs[next] = (switchs[next]+1)%2;

			prev--;
			next++;
		}
	}
}