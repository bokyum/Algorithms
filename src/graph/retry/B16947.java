package graph.retry;

import java.util.*;

public class B16947 {
    static int N;
    static ArrayList<Integer>[] A;
    static int[] check;

    // -2 사이클 찾고, 포함되지 않음, -1 사이클 못찾음, 0~n-1 사이클 찾
    static int dfs(int now, int before) {
        if(check[now] == 1) {
            return now;
        }

        check[now] = 1;
        for(int i: A[now]) {
            if(i == before)
                continue;
            int rt = dfs(i, now);
            if(rt == -2)
                return -2;
            if(rt >= 0) {
                check[now] = 2;
                if(now == rt)
                    return -2;
                else
                    return rt;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new ArrayList[N];

        for(int i=0; i < N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i=0; i < N; i++) {
            int v1 = sc.nextInt() - 1;
            int v2 = sc.nextInt() - 1;
            A[v1].add(v2);
            A[v2].add(v1);
        }

        check = new int[N];
        dfs(0, -1);

        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[N];
        for(int i=0; i < N; i++) {
            if(check[i] == 2) {
                dist[i] = 0;
                q.add(i);
            }
            else {
                dist[i] = -1;
            }
        }

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int n: A[now]) {
                if(dist[n] == -1) {
                    q.add(n);
                    dist[n] = dist[now] + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i < N; i++) {
            sb.append(dist[i] + " ");
        }

        System.out.println(sb.toString());
    }
}
