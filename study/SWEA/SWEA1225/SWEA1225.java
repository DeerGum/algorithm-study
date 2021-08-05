package study.SWEA.SWEA1225;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 암호생성기
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD&categoryId=AV14uWl6AF0CFAYD&categoryType=CODE&problemTitle=%EC%95%94%ED%98%B8&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA1225 {
    static Queue<Integer> nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = 10;
        for (int t = 1; t <= tc; t++) {
            br.readLine();
            nums = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 8; i++) 
                nums.offer(Integer.parseInt(st.nextToken()));
            
            encryption();

            bw.write("#"+t+" ");
            while (!nums.isEmpty()) {
                bw.write(nums.poll()+" ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static void encryption() {
        int n = 1;
        while (true) {
            int temp = nums.poll();
            if (temp - n <= 0) {
                nums.offer(0);
                break;
            } else
                nums.offer(temp-n);
            n = n%5 + 1;
        }
    }
}

/*


*/