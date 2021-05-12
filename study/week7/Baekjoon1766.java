import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] nextProblem = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) 
            nextProblem[i] = new ArrayList<>();
        int[] prevProblem = new int[n+1];
        boolean[] isSolved = new boolean[n+1];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nextProblem[a].add(b);
            prevProblem[b] = a;
        }

        for (int i = 1; i < n+1; i++) { 
        //이전에 풀어야 하는 문제가 없는 문제를 우선순위 큐에 삽입
            if(prevProblem[i] == 0) {
                pq.add(i);
                isSolved[i] = true;
            }
        }
        
        while(!pq.isEmpty()) {
            int currItem = pq.poll();
            for (int i = 0; i < nextProblem[currItem].size(); i++) {
                int nextItem = nextProblem[currItem].get(i);
                if(nextItem != 0 && !isSolved[nextItem])  {
                    pq.add(nextItem);
                    isSolved[nextItem] = true;
                }
            }
            bw.write(currItem+" ");
        }
        bw.newLine();
        bw.flush();
    }
}
/*
8 3
5 2
7 4
4 3

1 5 2 6 7 4 3 8

5 3
3 1
3 2
5 3

next
0 1 2 3 4 5
0 0 0 1 0 3
      2

prev
0 1 2 3 4 5
0 3 3 5 0 0

4 5
4

5
4 5

3
4 5 3

1 2
4 5 3 1

2
4 5 3 1 2


5 2
3 1
4 1

next
0 1 2 3 4 5
0 0 0 1 0 3
      2

prev
0 1 2 3 4 5
0 3 3 5 0 0

v

*/