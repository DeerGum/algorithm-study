package study.Baekjoon.month10_1;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 문제이름 : 회전 초밥
 * 링크 : https://www.acmicpc.net/problem/2531
 */

public class Baekjoon2531 {
    static int N, d, k, c;
    static int[] sushi;
    static int max;
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 접시 개수
        d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        sushi = new int[N];
        for (int i = 0; i < N; i++)
            sushi[i] = Integer.parseInt(br.readLine());

        map = new HashMap<>();
        max = 0;

        for (int i = 0; i < k; i++) {
            int cnt = 1;
            if (map.containsKey(sushi[i])) {
                cnt = map.get(sushi[i]);
                cnt++;
            }
            map.put(sushi[i], cnt);
        }

        if (k == N) {
            max = map.size();
        } else {
            search();
        }

        bw.write(max + "\n");
        bw.close();

    }
    
    public static void search() {
        for (int firstIdx = 0, nextIdx = k; firstIdx < N; firstIdx++, nextIdx = (nextIdx + 1) % N) {
            int first = sushi[firstIdx];
            int cnt = map.get(first);
            // 첫번째 인덱스 해쉬맵에서 카운트 - 1
            if (cnt < 2)
                map.remove(first);
            else
                map.put(first, cnt - 1);

            // 다음 인덱스 해쉬맵에 추가
            int next = sushi[nextIdx];
            cnt = 1;
            if (map.containsKey(next)) {    //이미 해쉬맵에 있으면
                cnt = map.get(next);
                cnt++;
            }
            map.put(next, cnt);
            
            int size = map.size();
            if (!map.containsKey(c)) // 쿠폰번호가 해쉬맵에 없으면
                size++; //사이즈 업
            max = Math.max(max, size);
        }
    }
}

/*
9 7 30 2 7 9 25 7

7
9 7 30 2 7 9 25

7 30 2 7 9 25 7

1 2 3 4 5 6 7 8

1 2 3 4 5 6 7
2 3 4 5 6 7 8
3 4 5 6 7 8 1
4 5 6 7 8 1 2


*/
