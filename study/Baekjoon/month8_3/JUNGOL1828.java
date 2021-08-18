package study.Baekjoon.month8_3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제이름 : 냉장고
 * 링크 : http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1101&sca=99&sfl=wr_subject&stx=%EB%83%89%EC%9E%A5%EA%B3%A0
 */

public class JUNGOL1828 {
    static int N;
    static int[][] temperature;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        temperature = new int[N][2];    //온도 저장 배열
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            temperature[i][0] = Integer.parseInt(st.nextToken());
            temperature[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(temperature, (a,b) -> { //람다식으로 Comparator 재정의 후 최고온도 기준으로 정렬
            if (a[1] == b[1]) 
                return a[0] - a[0];
            return a[1] - b[1];
        });

        int max = temperature[0][1];    //제일 작은 최고 온도 저장
        int count = 1;  //냉장고 갯수
        for (int i = 1; i < N; i++) {
            if (max < temperature[i][0]) {  //최고 온도가 이후에 나오는 화학물질의 최저온도보다 작으면
                count++;    //냉장고 갯수 증가
                max = temperature[i][1];    //최고 온도 갱신
            }
        }

        bw.write(count+"\n");
        bw.close();
    }

}
