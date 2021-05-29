package graph.done;

import java.util.*;
import java.io.*;

public class B11724 {
    static int N;
    static LinkedList<Integer>[] graph;
    static boolean[] cache;

    static void bfs(int index) {
        Queue<Integer> q = new LinkedList<>();
        cache[index] = true;
        q.add(index);

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int i=0; i < graph[now].size(); i++) {
                int to = graph[now].get(i);
                if(cache[to])
                    continue;
                else {
                    q.add(to);
                    cache[to] = true;
                }
            }
        }


    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new LinkedList[N+1];
        for(int i=1; i <= N; i++) {
            graph[i] = new LinkedList<>();

        }

        for(int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }


        cache = new boolean[N+1];

        int ans = 0;
        for(int i=1; i<=N; i++) {
            if(!cache[i]) {
                bfs(i);
                ans++;
            }

        }
        System.out.println(ans);
    }
}
