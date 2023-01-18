import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Test2 {
	static int[] pointer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		// 1. 포인터 배열 선언 (idx: 포인터 번호 / val: 객체 번호)
		pointer = new int[M];
		for (int i = 0; i < M; i++) {
			pointer[i] = Integer.parseInt(br.readLine());
		}

		// 2. 명령어 토큰 분리
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int x, y;
			switch (cmd) {
				case "assign" :
					x = Integer.parseInt(st.nextToken()) - 1;
					y = Integer.parseInt(st.nextToken()) - 1;
					assign(x, y);
					break;
				case "swap" :
					x = Integer.parseInt(st.nextToken()) - 1;
					y = Integer.parseInt(st.nextToken()) - 1;
					swap(x, y);
					break;
				case "reset" :
					x = Integer.parseInt(st.nextToken()) - 1;
					reset(x);
					break;
			}
		}

		// 3. 배열 오름차순 정렬 후 객체 개수 카운트
		Arrays.sort(pointer);
		int count = 0;
		for (int i = 0; i < pointer.length; i++) {
			if (pointer[i] == 0) continue;
			else if (pointer[i-1] == pointer[i]) continue;
			sb.append(pointer[i] + "\n");
			count++;
		}

		// 4. 출력
		bw.write(count + "\n");
		bw.write(sb.toString());

		br.close();
		bw.close();
	}

	private static void assign (int x, int y) {
		pointer[x] = pointer[y];
	}
	private static void swap (int x, int y) {
		int temp = pointer[x];
		pointer[x] = pointer[y];
		pointer[y] = temp;
	}
	private static void reset (int x) {
		pointer[x] = 0;
	}

}

/*
1,000 size = 4 mod3 = 1
0 123

10,000 size = 5 mod3 = 2
01 234

100,000 size = 6 mod3 = 0
012 345

1,000,000 size = 7 mod3 = 1
0 123 456

*/