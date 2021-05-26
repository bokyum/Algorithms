package graph;

import java.util.*;
import java.io.*;

public class B1707WithBfs {
    static int V, E;
    static ArrayList<Integer>[] graph;
    static int[] check;

    static boolean bfs(int index) {
        Queue<Integer> q = new LinkedList<Integer>();
        check[index] = 1;
        q.add(index);

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int i=0; i < graph[now].size(); i++) {
                int compV = graph[now].get(i);

                if(check[compV] == 0) {
                    check[compV] = check[now] * -1;
                    q.add(compV);
                }
                else if(check[now] == check[compV]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new ArrayList[V+1];

            for(int i=1; i <= V; i++)
                graph[i] = new ArrayList<>();

            for(int i=0; i<E; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                graph[v1].add(v2);
                graph[v2].add(v1);
            }

            check = new int[V+1];
            boolean cant = false;
            for (int i=1; i <=V; i++) {
                if (check[i] == 0) {
                    if(!bfs(i)) {
                        cant = true;
                        break;
                    }
                }
            }

            if(cant)
                System.out.println("NO");
            else
                System.out.println("YES");


        }

    }
}
