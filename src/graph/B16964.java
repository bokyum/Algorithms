package graph;

import java.util.*;


public class B16964 {
    static int N;
    static ArrayList<Integer>[] A;
    static ArrayList<Integer> ans = new ArrayList<>();
    static boolean[] check;


    static void dfs(int x) {
        if(check[x])
            return;

        check[x] = true;
        ans.add(x);

        for(int y: A[x]) {
            if(!check[y]) {
                dfs(y);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new ArrayList[N];

        for(int i=0; i < N; i++)
            A[i] = new ArrayList<>();

        for(int i=0; i < N-1; i++) {
            int v1 = sc.nextInt()-1;
            int v2 = sc.nextInt()-1;
            A[v1].add(v2);
            A[v2].add(v1);
        }
        int[] original = new int[N];
        int[] idxArr = new int[N];
        for(int i=0; i < N; i++) {
            original[i] = sc.nextInt()-1;
            idxArr[original[i]] = i;
        }

        for(int i=0; i < N; i++) {
            Collections.sort(A[i], (u,v) -> {
                if(idxArr[u] < idxArr[v])
                    return -1;
                else if(idxArr[u] == idxArr[v])
                    return 0;
                else
                    return 1;
            });
        }

        check = new boolean[N];
        dfs(0);

        boolean ok = true;
        for(int i=0; i < N; i++) {
            if(original[i] != ans.get(i))
                ok = false;
        }

        if(ok)
            System.out.println(1);
        else
            System.out.println(0);
    }
}
