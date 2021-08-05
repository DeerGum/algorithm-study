package study.Baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 문제이름 : 탑
 * 링크 : https://www.acmicpc.net/problem/2493
 */

public class Baekjoon2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] tower = new int[n+1];
        for (int i = 1; i < n+1; i++) 
            tower[i] = Integer.parseInt(st.nextToken());
        Stack<Integer> s = new Stack<>();
        int[] result = new int[n+1];

        s.push(1);
        int idx = 2;
        while (idx < result.length) {
            if (s.isEmpty()) {  //스택이 비어있으면 수신할 수 없음
                result[idx] = 0;
                s.push(idx++);
            } else if (tower[idx] <= tower[s.peek()]) {  //스택의 맨 위의 값보다 작거나 같으면
                result[idx] = s.peek();
                s.push(idx++);
            } else {    //스택의 맨 위값보다 크면
                s.pop();
            }
        }

        for (int i = 1; i < result.length; i++) 
            bw.write(result[i]+" ");
        bw.newLine();
        bw.flush();
        bw.close();

    }
}
 


/*


  0
  0 
  0   0
0 0   0
0 0 0 0
0 0 0 0 0
3 6 2 4 1
1 2 3 4 5  
<----

6 9 5 7 4
1 2 3 4 5
0 0 2 2 4

9 7 
2 4

9 5 7 3 2 6 10
1 2 3 4 5 6 7
0 1 1 3 4 3 0


*/
