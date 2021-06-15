package graph;

import java.util.*;

public class DFSOrder {

    static int N;
    static ArrayList<Integer>[] A;
    static ArrayList<Integer> dfs_order = new ArrayList<>();
    static boolean[] check;
    static void dfs(int x) {
        if(check[x])
            return;
        dfs_order.add(x);
        check[x] = true;
        for(int i: A[x])
            dfs(i);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new ArrayList[N];

        for(int i=0; i<N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i=0; i < N-1; i++) {
            int v1 = sc.nextInt()-1;
            int v2 = sc.nextInt()-1;
            A[v1].add(v2);
            A[v2].add(v1);
        }
        int[] b = new int[N];
        int[] order = new int[N];
        check = new boolean[N];
        for(int i=0; i < N; i++) {
            b[i] = sc.nextInt()-1;
            order[b[i]] = i;
        }

        for(int i=0; i < N; i++) {
            Collections.sort(A[i], (u, v) -> {
                if(order[u] < order[v])
                    return -1;
                else if(order[u] == order[v])
                    return 0;
                else
                    return 1;
            });
        }

        dfs(0);
        boolean ok = true;
        for(int i=0; i < N; i++) {
            if(dfs_order.get(i) != b[i])
                ok = false;
        }


        if(ok)
            System.out.println(1);
        else
            System.out.println(0);
    }
}
