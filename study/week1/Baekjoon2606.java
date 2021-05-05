package study.week1;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 문제이름 : 바이러스
 * 링크 : https://www.acmicpc.net/problem/2606
 * 알고리즘 분류
 * - 그래프 이론
 * - 그래프 탐색
 * - 깊이 우선 탐색
 */
public class Baekjoon2606 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int comNum = Integer.parseInt(br.readLine());
        int netNum = Integer.parseInt(br.readLine());

        LinkedList<Integer>[] computer = new LinkedList[comNum];
        boolean[] isVisited = new boolean[comNum];
        for (int i = 0; i < computer.length; i++) 
            computer[i] = new LinkedList<>();

        int index, target;
        for (int i = 0; i < netNum; i++) {
            st = new StringTokenizer(br.readLine());
            index = Integer.parseInt(st.nextToken())-1;
            target = Integer.parseInt(st.nextToken())-1;

            computer[index].add(target);
            computer[target].add(index);
        }

        Stack<Integer> s = new Stack();
        s.push(0);
        isVisited[0] = true;
        int popItem, temp, count = 0;
        Iterator it;
        while(!s.isEmpty()) {
            popItem = s.pop();
            it = computer[popItem].iterator();
            while(it.hasNext()) {
                temp = (int)it.next();
                if(!isVisited[temp]) {
                    s.push(temp);
                    isVisited[temp] = true;
                    count++;
                }
            }
        }
        
        bw.write(count+"\n");
        bw.flush();
    }
}
