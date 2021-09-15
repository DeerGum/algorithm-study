package study.Baekjoon.month9_2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 2xn 타일링
 * 링크 : https://www.acmicpc.net/problem/11726
 */

public class Baekjoon11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        bw.write(pivo(n) + "");
        bw.close();
    }
    
    public static int pivo(int n) {
        int[] pivo = new int[n+1];
        if (n == 1) 
            return 1;
        
        pivo[0] = 1;
        pivo[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            pivo[i] = (pivo[i - 1] + pivo[i - 2])%10007;
        }
        
        return pivo[n];
    }
}

/*


*/
