package graph;

import java.util.*;

public class BFSOrder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer>[] A = new ArrayList[N];

        for(int i=0; i < N; i++)
            A[i] = new ArrayList<>();

        for(int i=0; i < N-1; i++) {
            int v1 = sc.nextInt() - 1;
            int v2 = sc.nextInt() - 1;
            A[v1].add(v2);
            A[v2].add(v1);
        }


        int[] correct = new int[N];
        for(int i=0; i < N; i++)
            correct[i] = sc.nextInt() - 1;


        Queue<Integer> q = new LinkedList<>();
        int[] parent = new int[N];
        boolean[] check = new boolean[N];
        q.add(0);
        check[0] = true;

        int m = 1;
        for(int i=0; i < N; i++) {
            if(q.isEmpty()) {
                System.out.println(0);
                System.exit(0);
            }

            int now = q.poll();

            if(now != correct[i]) {
                System.out.println(0);
                System.exit(0);
            }

            int cnt = 0;
            
            for(int x: A[now]) {
                if(!check[x]) {
                    parent[x] = now;
                    cnt++;
                }
            }

            for(int j=0; j < cnt; j++) {
                if(m+j >= N || parent[correct[m+j]] != now) {
                    System.out.println(0);
                    System.exit(0);
                }
                q.add(correct[m+j]);
                check[correct[m+j]] = true;
            }
            m += cnt;
        }

        System.out.println(1);


    }
}
