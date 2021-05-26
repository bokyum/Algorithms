package graph;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class B1707 {
    static int V, E;
    static ArrayList<Integer>[] graph;
    static int[] check;


    static boolean dfs(int index, int crtValue) {
        check[index] = crtValue;

        for(int i=0; i < graph[index].size(); i++) {
            int crtIdx = graph[index].get(i);
            if(check[crtIdx] == 0) {
                if( !dfs(crtIdx, crtValue * -1))
                    return false;

            }
            else if(check[index] == check[crtIdx]) {
                    return false;
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
            boolean ok = true;
            for(int i=1; i <= V; i++) {
                if(check[i] == 0) {
                    if(!dfs(i, 1)) {
                        ok = false;
                        break;
                    }
                }
            }

            if(ok)
                System.out.println("YES");
            else
                System.out.println("NO");




        }

    }
}
