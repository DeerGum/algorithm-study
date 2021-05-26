import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 게으른 백곰
 * 링크 : https://www.acmicpc.net/problem/10025
 * 알고리즘 분류
 * - 슬라이싱 윈도우
 */
public class Baekjoon10025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[1000001];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            
            arr[x] = g;
        }
        int window = 0;
        for (int i = 0; i < k+1 && i < arr.length; i++)  
            window += arr[i];
        
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int low = i - k -1;
            int high = i + k + 1;
            if(low >= 0)
                window -= arr[low];
            if(high < arr.length)
                window += arr[high];

            if(max < window)
                max = window;
        }
        bw.write(max+"\n");
        bw.flush();
    }
}