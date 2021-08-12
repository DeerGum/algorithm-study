package study.SWEA.month8_2.SWEA6808;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 규영이와 인영이의 카드게임
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0&categoryId=AWgv9va6HnkDFAW0&categoryType=CODE&problemTitle=%EA%B7%9C%EC%98%81%EC%9D%B4&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA6808 {
    static int maxNumber = 18;
    static boolean[] card;
    static int[] partner;
    static int[] player;
    static int partnerLoss, partnerWin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            card = new boolean[maxNumber+1];
            partner = new int[maxNumber/2+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < maxNumber/2+1; i++) {
                partner[i] = Integer.parseInt(st.nextToken());
                card[partner[i]] = true;
            }

            player = new int[maxNumber/2+1];
            for (int i = 1, idx = 1; i < maxNumber/2+1; idx++) {
                if (!card[idx]) {
                    player[i++] = idx;
                }
            }

            partnerLoss = 0;
            partnerWin = 0;

            perm(1, new boolean[maxNumber/2+1], new int[maxNumber/2+1]);
            bw.write("#"+t+" "+partnerWin+" "+partnerLoss+"\n");
        }

        bw.flush();
    }

    public static void perm(int cnt, boolean[] v, int[] num) {
        if (cnt == maxNumber/2+1) {
            count(num);
            return;
        }

        for (int i = 1; i < maxNumber/2+1; i++) {
            if (v[i]) 
                continue;
            
            v[i] = true;
            num[cnt] = player[i];
            perm(cnt+1, v, num);
            v[i] = false;
        }


    }

    public static void count(int[] num) {
        int partnerPoint = 0;
        int playerPoint = 0;
        for (int i = 1; i < maxNumber/2+1; i++) {
            if (partner[i] < num[i]) {
                playerPoint += partner[i] + num[i];
            } else if (partner[i] > num[i]) {
                partnerPoint += partner[i] + num[i];
            }
        }
        if (partnerPoint < playerPoint) {
            partnerLoss++;
        } else if (partnerPoint > playerPoint) {
            partnerWin++;
        }
    }
}

/*
1
1 3 5 7 9 11 13 15 17

*/