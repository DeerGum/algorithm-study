package study.week5;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 문제이름 : 서로소
 * 링크 : https://www.acmicpc.net/problem/9359
 * 알고리즘 분류
 * - 포함배제의원리
 * - 정수론
 * - 수학
 */

public class Baekjoon9359 {
    public static ArrayList<Long> prime;
    public static ArrayList<Long> divi;
    public static HashSet<Long> m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long a,b,n;
        prime = new ArrayList<>();
        getPrime(100000);  //N은 최대 10억이므로 두번째로 큰 소인수는 sqrt(N)보다 작다. 그래서 10만으로 해결가능
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());
            n = Long.parseLong(st.nextToken());
            
            divi = new ArrayList<>();
            m = new HashSet<>();
            boolean flag = true;
            while(n > 1) {
                flag = true;
                for (long l : prime) {
                    if(n%l == 0) {
                        n /= l;
                        flag = false;
                        m.add(l);
                        break;
                    }
                }
                if(flag) 
                    break;
            }
            if(n != 1) 
                m.add(n);
            for (long key : m) 
                divi.add(key);
            
            long ans = 0;
            long bit = 1 << divi.size();
            long count, sum;
            for (int j = 1; j < bit; j++) {
                count = 0;
                sum = 1;
                for (int k = 0; k < divi.size(); k++) {
                    if( (j & (1 << k)) == 0 )
                        continue;
                    count++;
                    sum *= divi.get(k);
                }
                long aa = (a+sum-1)/sum;
                long bb = b/sum;
                if(aa > bb) 
                    continue;
                    if((count&1) == 1)
                        ans += bb-aa+1;
                    else
                        ans -= bb-aa+1;
            }
            
            bw.write("Case #"+(i+1)+": "+(b-a+1-ans)+"\n");
        }
        bw.flush();
    }

    public static void getPrime(int n) {
        boolean[] isVisited = new boolean[n+1];

        for (int i = 2; i <= n; i++) {
            if(!isVisited[i]) {
                prime.add((long)i);
                for (int j = i+i; j <= n; j+=i) 
                    isVisited[j] = true;
            }
        }
    }
}