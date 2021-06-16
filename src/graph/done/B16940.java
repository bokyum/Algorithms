package graph.done;

import java.io.*;
import java.util.*;

public class B16940 {
    static int N;
    static ArrayList<Integer>[] A;
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

        int[] order = new int[N];
        for(int i=0; i < N; i++) {
            order[i] = sc.nextInt()-1;
        }
        int[] parent = new int[N];
        boolean[] check = new boolean[N];
        check[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        int m = 1; // 현재 검사하는 인덱스를 위한
        for(int i=0; i < N; i++) {
            if(q.isEmpty()) {
                System.out.println(0);
                System.exit(0);
            }

            int now = q.poll();

            if(now != order[i]) {
                System.out.println(0);
                System.exit(0);
            }

            int cnt = 0; // 현재 몇개의 노드가 인접해 있는지
            for(int x: A[now]) {
                if(!check[x]) {
                    check[x] = true;
                    parent[x] = now;
                    cnt += 1;
                }
            }

            for(int j = 0; j < cnt; j++) {
                if(m+j >= N || parent[order[m+j]] != now) {
                    System.out.println(0);
                    System.exit(0);
                }
                q.add(order[m+j]);
                check[order[m+j]] = true;

            }
            m += cnt;

        }

        System.out.println(1);
    }
}
