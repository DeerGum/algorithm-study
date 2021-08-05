package study.SWEA.SWEA1218;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 문제이름 : 괄호 짝짓기
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD&categoryId=AV14eWb6AAkCFAYD&categoryType=CODE&problemTitle=%EA%B4%84%ED%98%B8&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA1218 {
    static char[][] b = { {'(',')'}, {'{','}'}, {'[',']'}, {'<','>'} };
    static Stack<Character> bracket;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = 10;

        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            bracket = new Stack();
            
            bw.write("#"+t+" "+(check(str)?1:0)+"\n");
        }
        bw.flush();

    }

    public static boolean check(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < b[j].length; k++) {
                    if (c == b[j][k]) {
                        if (k == 0) {   //열린 괄호
                            bracket.push(c); // 삽입
                        }
                        else {  //닫힌 괄호 k = 1
                            if (bracket.isEmpty()) { //스택이 비어있으면
                                return false;
                            } else {
                                if(bracket.peek() == b[j][0]) { //스택 맨 위가 c와 짝이 맞으면
                                    bracket.pop();
                                } else {    //짝이 안맞으면
                                    return false;
                                }
                            }
                        }
                        
                    }
                }
            }

        }

        if (!bracket.isEmpty()) //스택에 괄호가 남아있으면 
            return false;
        
        return true;
    }
}

/*


*/