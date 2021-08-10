package study.SWEA.month8_1.SWEA3499;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 퍼펙트셔플
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWGsRbk6AQIDFAVW&categoryId=AWGsRbk6AQIDFAVW&categoryType=CODE&problemTitle=%ED%8D%BC%ED%8E%99%ED%8A%B8&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA3499 {
    static int n;
    static Queue<String> q1, q2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            q1 = new LinkedList<>();
            q2 = new LinkedList<>();

            int q1Len = (n%2 == 0)?n/2:n/2+1;
            int q2Len = n/2;
            if (n%2 == 0) 
                q1Len = n/2;
             else 
                q1Len = n/2+1;
            
            for (int i = 0; i < q1Len; i++) 
                q1.offer(st.nextToken());
            
            for (int i = 0; i < q2Len; i++) 
                q2.offer(st.nextToken());
            
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            while (true) {
                if (first) {
                    if (q1.isEmpty())
                        break;
                    sb.append(q1.poll()+" ");
                }
                else {
                    if (q2.isEmpty())
                        break;
                    sb.append(q2.poll()+" ");
                }
                first = !first;
            }

            while(!q1.isEmpty())
                sb.append(q1.poll()+" ");

            while(!q2.isEmpty())
                sb.append(q2.poll()+" ");

            bw.write("#"+t+" "+sb.toString()+"\n");
        }
        bw.flush();
        bw.close();

    }
}

/*




*/