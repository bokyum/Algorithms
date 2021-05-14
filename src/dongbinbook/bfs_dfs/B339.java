package dongbinbook.bfs_dfs;

import java.util.*;

class Node1{
    int v;
    int c;

    public Node1(int v, int c) {
        this.v = v;
        this.c = c;
    }
}
public class B339 {
    static int N, M, K, X;
    static ArrayList<Node1>[] city;
    static int[] check;
    static void solve(int index) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(index);
        int count = 0;
        check[index] = ++count;

        while(!q.isEmpty()) {
            int temp = q.poll();
            for(int i=0; i < city[temp].size(); i++) {
                if(city[temp].get(i).c == 1) {
                    city[temp].get(i).c--;
                    q.offer(city[temp].get(i).v);
                    if(check[city[temp].get(i).v] == 0)
                        check[city[temp].get(i).v] = check[temp] + 1;
                }
            }

        }
        boolean noExist = true;
        for(int i=1; i < check.length; i++)
            if(check[i]-1 == K) {
                System.out.println(i);
                noExist = false;
            }

        if(noExist)
            System.out.println(-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();
        K = sc.nextInt(); X = sc.nextInt();
        city = new ArrayList[N+1];
        check = new int[N+1];
        for(int i=1; i <= N;  i++)
            city[i] = new ArrayList<>();
        for(int i=0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            city[start].add(new Node1(end, 1));
        }
        solve(X);




    }
}
