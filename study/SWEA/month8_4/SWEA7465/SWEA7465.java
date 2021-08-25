package study.SWEA.month8_4.SWEA7465;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 문제이름 : 창용 마을 무리의 개수
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWngfZVa9XwDFAQU&categoryId=AWngfZVa9XwDFAQU&categoryType=CODE&problemTitle=7465&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA7465 {
    static int N, M;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            parents = new int[N+1];
            for (int i = 1; i < N+1; i++) 
                parents[i] = i;
            
            for (int i = 0 ; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                union(from, to);    //그룹으로 만듬
            }

            for (int i = 1; i < N+1; i++) 
                find(i);
            
            HashSet<Integer> result = new HashSet<>();

            for (int i = 1; i < N+1; i++) 
                result.add(parents[i]);
            
            bw.write("#"+t+" "+result.size()+"\n");
        }
        bw.close();

    }

    public static int find(int a) { //대표자 찾아서 반환
        if (a == parents[a]) 
            return a;
        else
            return parents[a] = find(parents[a]);
    }

    public static void union(int a, int b) {    // b를 a를 대표자로 한 그룹으로 묶음
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) 
            return;
        
        parents[bRoot] = aRoot;
    }
}



/*


*/