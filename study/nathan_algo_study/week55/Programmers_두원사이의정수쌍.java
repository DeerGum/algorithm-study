package study.nathan_algo_study.week55;

/**
 * 문제이름 : 두 원 사이의 정수쌍
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/181187
 */

public class Programmers_두원사이의정수쌍 {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (int i = 1; i <= r2; i++) {
            int smallCircle = (int) Math.ceil(Math.sqrt((long) r1 * r1 - (long) i * i));
            int bigCircle = (int) Math.floor(Math.sqrt((long) r2 * r2 - (long) i * i));

            answer += bigCircle - smallCircle + 1;  //한 사분면의 점의 개수를 계산
        }

        return answer * 4;
    }
}

/*
r^2 = x^2 + y^2

25 = 4 + y^2
21 = y^2

25 = 9 + y^2
16 = y^2

*/
