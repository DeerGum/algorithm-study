package study.newStudy.week3;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 문제이름 : 숨바꼭질3
 * 링크 : https://www.acmicpc.net/problem/13549
 */

public class Baekjoon13549 {
    static final int MAX = 100001;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        bw.write(zeroOneBFS()+"\n");
        bw.close();
    }
    
    public static int zeroOneBFS() {
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[MAX];
        dq.addLast(new int[] { N, 0 });

        while (!dq.isEmpty()) {
            int[] curr = dq.removeFirst();
            int pos = curr[0];
            int t = curr[1];

            if (pos == K) {
                return t;
            }

            int warp = pos * 2;
            int next = pos + 1;
            int prev = pos - 1;

            if (warp < MAX && !visited[warp]) {
                visited[warp] = true;
                dq.addFirst(new int[] { warp, t });
            }

            if (prev >= 0 && !visited[prev]) {
                visited[prev] = true;
                dq.addLast(new int[] { prev, t + 1 });
            }

            if (next < MAX && !visited[next]) {
                visited[next] = true;
                dq.addLast(new int[] { next, t + 1 });
            }
        }
        return 0;
    }
}

/*


*/
