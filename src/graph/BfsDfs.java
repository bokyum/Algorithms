package graph;

import java.io.*;
import java.util.*;

public class BfsDfs {
    static int N, M, startNode;
    static LinkedList<Integer>[] graph;
    static boolean[] cache;

    public static void dfs() {
        cache = new boolean[N+1];
        dfs(startNode);
        System.out.println();
    }
    private static void dfs(int index) {
        System.out.print(index + " ");
        cache[index] = true;

        for(int i=0; i < graph[index].size(); i++) {
            int n = graph[index].get(i);
            if(!cache[n])
                dfs(n);
        }
    }
    public static void bfs() {
        cache = new boolean[N+1];
        bfs(startNode);
        System.out.println();
    }

    private static void bfs(int index) {
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        cache[index] = true;
        System.out.print(index + " ");
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int i=0; i < graph[now].size(); i++) {
                int to = graph[now].get(i);
                if(cache[to])
                    continue;
                else {
                    q.add(to);
                    System.out.print(to + " ");
                    cache[to] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(st.nextToken());

        graph = new LinkedList[N+1];
        for(int i=1; i <= N; i++)
            graph[i] = new LinkedList<>();

        for(int i=0; i < M; i++ ) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        for(int i=1; i <= N; i++)
            Collections.sort(graph[i]);

        dfs();
        bfs();





    }


}
