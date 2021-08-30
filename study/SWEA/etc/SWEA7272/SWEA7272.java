package study.SWEA.etc.SWEA7272;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 안경이 없어!
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWl0ZQ8qn7UDFAXz&categoryId=AWl0ZQ8qn7UDFAXz&categoryType=CODE&problemTitle=%EC%95%88%EA%B2%BD&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA7272 {
    static char[] one = { 'A', 'D', 'O', 'P', 'Q', 'R' };
    static char two = 'B';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            if (isEqual(str1, str2))
                bw.write("#" + t + " " + "SAME\n");
            else
                bw.write("#" + t + " " + "DIFF\n");
        }
        bw.close();

    }
    
    static boolean isEqual(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if ((check(c1) != check(c2))) {
                return false;
            }
        }
        return true;
    }
    
    static int check(char c) {
        for (int i = 0; i < one.length; i++) {
            if (c == one[i])
                return 1;
        }

        if (c == two) 
            return 2;
        else
            return 0;
    }

}

/*


*/