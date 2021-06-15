package graph.done;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16947 {

    static int N;
    static ArrayList<Integer>[] A;
    static boolean[] check;
    static boolean[] circle;

    static boolean dfs(int now, int before, int start) {
        if(now == start && check[now])
            return true;

        if(check[now])
            return false;

        check[now] = true;

        for(int n: A[now]) {
            if(n!= before) {
                if(dfs(n, now, start)) {
                    circle[n] = true;
                    return true;
                }

            }
        }
        return false;
    }

    public static int bfs(int now) {
        Queue<Integer> q = new LinkedList<>();
        q.add(now);
        q.add(0);

        while(!q.isEmpty()) {
            int crtV = q.poll();
            int weight = q.poll();
            if(circle[crtV])
                return weight;
            check[crtV] = true;

            for(int V: A[crtV]) {
                if(!check[V]) {
                    q.add(V);
                    q.add(weight+1);
                }
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new ArrayList[N+1];
        for(int i=1; i <= N; i++)
            A[i] = new ArrayList<>();

        for(int i=0; i < N; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            A[v1].add(v2);
            A[v2].add(v1);
        }
        circle = new boolean[N+1];
        for(int i=1; i <= N; i++) {
            check = new boolean[N+1];
            if(dfs(i, -1, i))
                break;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i <= N; i++) {
            check = new boolean[N+1];
            int ans = bfs(i);
            sb.append(ans + " ");
        }
        System.out.println(sb.toString());
    }
}
