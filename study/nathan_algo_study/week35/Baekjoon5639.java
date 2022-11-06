package study.nathan_algo_study.week35;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 이진 검색 트리
 * 링크 : https://www.acmicpc.net/problem/5639
 */

public class Baekjoon5639 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


    }

    public static void postOrder() {

    }
}

class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class Tree {
    Node head;
    int size;

    public Tree() {
        this.head = null;
        this.size = 0;
    }

    public void push(Node node) {
        if (head == null)
            head = node;
        else {
            Node curr = head;

        }
    }
}

/*

*/
