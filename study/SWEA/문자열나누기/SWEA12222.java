package study.SWEA.문자열나누기;

import java.io.*;


/**
 * 문제이름 : 문자열 나누기
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXpz5_AavskDFATi&categoryId=AXpz5_AavskDFATi&categoryType=CODE
 * 실패...
 */

public class SWEA12222 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            int answer = 0;
            char c1, c2, c3;
            int j = 0;
            while (j < str.length()) {
                c1 = str.charAt(j);
                if(j+1 == str.length()) {   //c1이 마지막 문자일 경우
                    answer++;
                    break;
                } else {    //두번째 문자가 있을 경우
                    c2 = str.charAt(j+1);
                    if(j+2 < str.length()) {    // 세번째 문자 있을 경우
                        c3 = str.charAt(j+2);
                        if(c1 != c2) {  //두 문자가 다르면
                            if(c2 == c3) {  //두번째 세번째 문자가 같으면
                                answer += 2;    //두개의 리스트로 나눔
                                j += 2; //{c1+c2}, {c3}
                            } else {
                                answer += 2;    //두개의 리스트로 나눔
                                j++;    //{c1}, {c2}
                            }    
                        }
                        else {  //두 문자가 같으면
                            answer += 2;    //두개의 리스트로 나눔
                            j += 2;
                        }
                    } else {    //두번째 문자가 문자열의 마지막일 때
                        if(c1 != c2) {  //두 문자가 다르면
                            answer += 2;
                            j += 2;
                        }
                        else {  // 두 문자가 같으면
                            answer++;
                            j++;
                        }
                        break;
                    }
                }
                j++;
            }
            bw.write("#"+(i+1)+" "+answer+"\n");
        }
        bw.flush();
    }
}
