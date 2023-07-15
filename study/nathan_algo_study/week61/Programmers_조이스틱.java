package study.nathan_algo_study.week61;

/**
 * 문제이름 : 조이스틱
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42860
 */

public class Programmers_조이스틱 {
    public int solution(String name) {
        int[] cost = new int[name.length()];
        for (int i = 0; i < cost.length; i++)
            cost[i] = moveCharMinCnt('A', name.charAt(i));

        int answer = 0;
        int idx = 0;
        for (int i = 0; i < name.length(); i++) {
            answer += moveCharMinCnt('A', name.charAt(i));
            if (i != name.length() - 1)
                answer++;   //옆으로 한칸 이동
        }

        return answer;
    }

    private int moveCharMinCnt(char origin, char target) {
        int cnt1 = Math.abs(origin - target + 26);
        int cnt2 = Math.abs(target - origin);
        System.out.println(String.format("%d , %d", cnt1, cnt2));
        return Math.min(cnt1, cnt2);
    }

    private int calculateCost(int dir, int currIdx, int[] arr) {

        return 0;
    }
}

/*
A 1
Y 25

24
26

26 - 24 = 2
24 - 26 = -2 + 26 = 24

9 0 1

왼쪽 코스트 2
오른쪽 코스트 3

XX0000XX
11000111

01000111 왼:6 오:
^
*/
