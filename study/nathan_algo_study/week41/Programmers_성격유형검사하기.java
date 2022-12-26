package study.nathan_algo_study.week41;

import java.util.HashMap;
import java.util.Map;

/**
 * 문제이름 : 
 * 링크 : https://school.programmers.co.kr/learn/courses
 */

public class Programmers_성격유형검사하기 {
    static int[] point = {0, 3, 2, 1, 0, 1, 2, 3};
    static Map<Character, Integer> index;
    static int[][] s;
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        index = new HashMap<>();
        index.put('R', 0);
        index.put('T', 1);
        index.put('C', 0);
        index.put('F', 1);
        index.put('J', 0);
        index.put('M', 1);
        index.put('A', 0);
        index.put('N', 1);
        s = new int[4][2];


        return answer;
    }
}

/*

*/
