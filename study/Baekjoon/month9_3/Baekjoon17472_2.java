package study.Baekjoon.month9_3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon17472_2 {

    static class Node implements Comparable<Node> {
        int s;
        int e;
        int w;

        public Node(int s, int e, int w) {
            super();
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static int[] dr = { -1, 1, 0, 0 };// 상하좌우
    static int[] dc = { 0, 0, -1, 1 };

    static int N, M;
    static int [][] map;
    static int [][] krus;

    static int max;

    static int[] p;
    static int[] R;

    static int V;

    static PriorityQueue<Node> pq;

    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        N = scann.nextInt();
        M = scann.nextInt();
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scann.nextInt();
            }
        }

        //ff로 섬들을 구한다.
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    cnt++;
                    bfs(i, j, cnt + 1);
                }
            }
        }

        //kruskal을 위한 정보준비
        V = cnt;
        krus = new int[V][V];
        for (int i = 0; i < V; i++) {
            Arrays.fill(krus[i], Integer.MAX_VALUE);
        }

        //Bfs를 이용하여 각 그룹별(섬들) 최소거리를 구한다. 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int g = 2; g < 2 + V; g++) {
                    if (map[i][j] == g) {
                        go(i, j, g);
                    }
                }
            }
        }

        //pq에 넣기
        pq = new PriorityQueue<>();
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (krus[i][j] != Integer.MAX_VALUE) {
                    pq.offer(new Node(i, j, krus[i][j]));
                }
            }
        }

        // 거리 구하기 -> kruskal
        //초기화
        makeSet();
        int cnt2 = 0;
        int sum = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            //두 v1,v2 연결 안되어 있으면 
            if (!isConnect(node.s, node.e)) {
                cnt2++;
                //연결
                union(node.s, node.e);
                sum += node.w;
            }
        }

        // 나를 제외한 모든 정점 v-1개 다 연결했으면
        if (cnt2 == V - 1) {
            System.out.println(sum);
        } else {
            System.out.println(-1);
        }
    }
    
    private static void go(int r, int c, int k) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int g = k + 1; g < 2 + V; g++) {
                    if (map[i][j] == g) {
                        int res = distance(r, c, i, j);
                        krus[k - 2][g - 2] = Math.min(res, krus[k - 2][g - 2]);
                        krus[g - 2][k - 2] = krus[k - 2][g - 2];
                    }
                }
            }
        }

    }
    
    static int distance(int r1, int c1, int r2, int c2) {
        int tmin = Integer.MAX_VALUE;
        //4방을 구한다. 
        for (int d = 0; d < 4; d++) {
            int dis = distance(r1, c1, r2, c2, d);
            if (dis < 2) { // 거리가 2 미만 제거
                dis = Integer.MAX_VALUE;
            }
            tmin = Math.min(dis, tmin);
        }
        return tmin;
    }
    
    // d방향 한방향으로만 거리를 구한다. 목표지점에 도달하기 0만 거쳐간다.
    static int distance(int r1, int c1, int r2, int c2, int d) {
        Queue<int[]> que = new LinkedList<int[]>();
        que.offer(new int[] { r1, c1, 0 });
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int cnt = cur[2];
            int nr = cur[0] + dr[d];
            int nc = cur[1] + dc[d];
            if (!check(nr, nc))
                continue;
            if (nr == r2 && nc == c2) {
                return cnt;
            }
            if (map[nr][nc] == 0) {
                que.offer(new int[] { nr, nc, cnt + 1 });
            }
        }
        return Integer.MAX_VALUE;
    }
    
    static void makeSet() {
        // makeSet 초기화
        p = new int[V];
        for (int i = 0; i < V; i++) {
            p[i] = i;
        }
        // rank 초기화
        R = new int[V];
        for (int i = 0; i < V; i++) {
            R[i] = 1;
        }
    }
    
    //ff ->  group을 구한다.
    static void bfs(int r, int c, int g) {
        int[][] visited = new int[N][M];
        Queue<int[]> que = new LinkedList<int[]>();
        que.offer(new int[] { r, c });
        map[r][c] = g;
        visited[r][c] = 1;
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int cr = cur[0];
            int cc = cur[1];
            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                if (!check(nr, nc))
                    continue;
                if (visited[nr][nc] == 0 && map[nr][nc] == 1) {
                    que.offer(new int[] { nr, nc });
                    map[nr][nc] = g;
                    visited[nr][nc] = 1;
                }
            }
        }
    }
    
    static boolean check(int r, int c) {
    return r>=0 && r<N && c>=0 && c<M;
    }
    static boolean isConnect(int x, int y) {
    return find(x)==find(y);
    }

    private static int find(int x) {
        if (x == p[x]) {
            return p[x];
        } else
            return p[x] = find(p[x]);
    }
    

    private static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) {
            return;
        }

        if (R[px] >= R[py]) {
            p[py] = px;
            R[px] += R[py];
        } else {
            p[px] = py;
            R[py] += R[px];
        }
    }
    
}
