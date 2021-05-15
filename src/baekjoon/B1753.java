package baekjoon;

import java.io.*;
import java.util.*;

public class B1753 {
    static int n,m,start;
    static final int INF = 999_999_999;
    static ArrayList<Node> graph[];
    static int[] dest;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());

        dest = new int[n+1];
        graph = new ArrayList[n+1];

        for(int i=0; i <= n; i++) {
            graph[i] = new ArrayList<Node>();
            dest[i] = INF;
        }




        for(int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            Node n = new Node(e,value);


            graph[v].add(n);



        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
        pq.offer(new Node(start, 0));
        dest[start] = 0;


        while(!pq.isEmpty()) { // 큐가 비어있지 않다면
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node node = pq.poll();
            int dist = node.distance; // 현재 노드까지의 비용
            int now = node.index; // 현재 노드

            if (dest[now] < dist) continue;

            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (int i = 0; i < graph[now].size(); i++) {
                int tempDist = graph[now].get(i).distance;
                int tempIndex = graph[now].get(i).index;
                int cost = dest[now] + tempDist;
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < dest[tempIndex]) {
                    dest[tempIndex] = cost;
                    pq.offer(new Node(tempIndex, cost));
                }
            }

        }

        for(int i=1; i <= n; i++){
            if(dest[i] == INF) {
                bw.write("INF");
            }
            else
                bw.write(dest[i] + "");
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
