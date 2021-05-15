package baekjoon.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1916 {
    static int N, M;
    static final int INF = 999_999_999;

    static int stringToInt(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stringToInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = stringToInt(st.nextToken());
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        int[] dest = new int[N+1];
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<Node>());
            dest[i] = INF;
        }
        for(int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = stringToInt(st.nextToken());
            int to = stringToInt(st.nextToken());
            int value = stringToInt(st.nextToken());

            graph.get(from).add(new Node(to, value));
        }
        st = new StringTokenizer(br.readLine());
        int start = stringToInt(st.nextToken());
        int destination = stringToInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dest[start] = 0;

        while(!pq.isEmpty()) {
            Node n = pq.poll();
            int now = n.index;
            int dist = n.distance;

            if(dest[now] < dist)
                continue;
            for(int i=0; i < graph.get(now).size(); i++) {
                int compIndex = graph.get(now).get(i).index;
                int compDist = graph.get(now).get(i).distance;
                int cost = dest[now] + compDist;
                if(cost < dest[compIndex]){
                    dest[compIndex] = cost;
                    pq.add(new Node(compIndex, cost));
                }
            }
        }
        System.out.println(dest[destination]);

    }
}
