
import java.io.*;

/**
 * 문제이름 : 잃어버린 괄호
 * 링크 : https://www.acmicpc.net/problem/1541
 * 알고리즘 분류
 * - 수학
 * - 문자열
 * - 그리디 알고리즘
 * - 파싱
 */

public class Baekjoon1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String read = br.readLine();
        StringBuilder sb = new StringBuilder();
        boolean prevMinus = false;
        boolean prevDigit = true;
        int temp,result = 0;
        for (int i = 0; i < read.length(); i++) {
            char c = read.charAt(i);
            if(Character.isDigit(c)) {
                sb.append(c);
            }
            else {  //연산자
                if(prevDigit) { //이전값이 숫자이면
                    temp = Integer.parseInt(sb.toString());
                    result += temp;
                    sb = new StringBuilder();
                }
                if(c == '+') {
                    if(prevMinus)
                        sb.append('-');
                }
                else {  // '-'
                    prevMinus = true;
                    sb.append('-');
                }
            }
        }
        temp = Integer.parseInt(sb.toString());
        result += temp;
        bw.write(result+"\n");
        bw.flush();
    }
}