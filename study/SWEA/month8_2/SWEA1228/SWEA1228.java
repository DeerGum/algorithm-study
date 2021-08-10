package study.SWEA.month8_2.SWEA1228;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 문제이름 : 암호문1
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14w-rKAHACFAYD&categoryId=AV14w-rKAHACFAYD&categoryType=CODE&problemTitle=%EC%95%94%ED%98%B8%EB%AC%B8&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA1228 {
    static Stack<Integer> s;
    static ArrayList<Integer> secret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = 10;
        for (int t = 1; t <= tc; t++) {
            int secretlen = Integer.parseInt(br.readLine());
            secret = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < secretlen; i++) 
                secret.add(Integer.parseInt(st.nextToken()));
            
            int cmdLen = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < cmdLen; i++) {
                String cmd = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                s = new Stack<>();
                for (int j = 0; j < y; j++) 
                    s.push(Integer.parseInt(st.nextToken()));
                
                insert(x);
            }
            bw.write("#"+t+" ");
            for (int i =0; i < 10; i++) 
                bw.write(secret.get(i)+" ");
            bw.newLine();
        }
        bw.close();
    }

    public static void insert(int x) {
        while (!s.isEmpty()) 
            secret.add(x, s.pop());
        
    }
}

/*


*/