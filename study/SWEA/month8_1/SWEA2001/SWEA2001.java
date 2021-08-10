package study.SWEA.month8_1.SWEA2001;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 파리퇴치
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PzOCKAigDFAUq&categoryId=AV5PzOCKAigDFAUq&categoryType=CODE&problemTitle=%ED%8C%8C%EB%A6%AC&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA2001 {
    static int[][] fly;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int tc = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            fly = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    fly[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = maxKillCount();
            bw.write("#"+t+" "+max+"\n");
        }
        bw.flush();
        bw.close();

    }

    public static int maxKillCount() {
        int[][] stick;
        int max = 0;
        for (int i = 0; i <= n-m; i++) {
            for (int j = 0; j <= n-m; j++) {
                stick = new int[m][m];
                for (int k = 0; k < m; k++) {
                    for (int l = 0; l < m; l++) {
                        stick[k][l] = fly[i+k][j+l];       
                    }
                }

                int sum = sumArray(stick);
                max = Math.max(sum, max);
            }
        }

        return max;
    }

    public static int sumArray(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }
}

/*


*/