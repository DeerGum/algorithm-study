package study.SWEA.month8_2.SWEA1233;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 사칙연산 유효성 검사
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141176AIwCFAYD&categoryId=AV141176AIwCFAYD&categoryType=CODE&problemTitle=1233&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA1233 {
    static Tree[] tree;
    static int n;
    static boolean isValid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = 10;
        for (int t = 1; t <= tc; t++) {
            n = Integer.parseInt(br.readLine());
            tree = new Tree[n+1];
            isValid = true;
            for (int i = 1; i <= n; i++) {
                tree[i] = new Tree();

                st = new StringTokenizer(br.readLine());
                st.nextToken();
                tree[i].data = st.nextToken().charAt(0);
                if (st.hasMoreTokens()) 
                    tree[i].leftChild = Integer.parseInt(st.nextToken());
                
                if (st.hasMoreTokens()) 
                    tree[i].rightChild = Integer.parseInt(st.nextToken());
                
            }
                
            check(1);

            bw.write("#"+t+" "+(isValid?1:0)+"\n");
        }
        bw.flush();
    }

    public static void check(int n) {
        Tree node = tree[n];
        //숫자 노드에 자식노드가 있으면 
        if (Character.isDigit(node.data)) {
            if (node.leftChild != 0 || node.rightChild != 0) {
                isValid = false;
            }
        } else { //연산자 노드의 자식노드가 2개미만이면
            if (node.leftChild == 0 || node.rightChild == 0) {
                isValid = false;
            }
        }

        if (node.leftChild != 0) 
            check(node.leftChild);
        
        if (node.rightChild != 0) 
            check(node.rightChild);
    }
}

class Tree {
    char data;
    int leftChild;
    int rightChild;
    public Tree() {
        data = 0;
        leftChild = 0;
        rightChild = 0;
    }
}

/*
109
1 + 2 3
2 + 4 5
3 - 6 7
4 + 8 9
5 - 10 11
6 * 12 13
7 / 14 15
8 / 16 17
9 + 18 19
10 + 20 21
11 - 22 23
12 * 24 25
13 * 26 27
14 - 28 29
15 + 30 31
16 * 32 33
17 + 34 35
18 / 36 37
19 + 38 39
20 - 40 41
21 / 42 43
22 - 44 45
23 + 46 47
24 - 48 49
25 * 50 51
26 - 52 53
27 - 54 55
28 / 56 57
29 / 58 59
30 * 60 61
31 - 62 63
32 * 64 65
33 / 66 67
34 * 68 69
35 / 70 71
36 * 72 73
37 + 74 75
38 - 76 77
39 * 78 79
40 + 80 81
41 - 82 83
42 * 84 85
43 - 86 87
44 * 88 89
45 + 90 91
46 * 92 93
47 - 94 95
48 * 96 97
49 + 98 99
50 + 100 101
51 / 102 103
52 / 104 105
53 + 106 107
54 * 108 109
55 3
56 8
57 5
58 8
59 4
60 7
61 4
62 9
63 2
64 9
65 8
66 1
67 2
68 3
69 3
70 7
71 7
72 8
73 9
74 2
75 5
76 3
77 3
78 3
79 6
80 4
81 8
82 7
83 4
84 1
85 6
86 6
87 6
88 5
89 8
90 8
91 6
92 9
93 5
94 1
95 6
96 8
97 7
98 9
99 6
100 9
101 5
102 1
103 3
104 2
105 1
106 7
107 9
108 6
109 6

*/