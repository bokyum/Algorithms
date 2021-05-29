package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node2 implements Comparable<Node2> {
    private int index;
    private int distance;

    public Node2(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(Node2 other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class Telegram {
    static final int INF = (int)1e9;
    static int N, M, C;

    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node2>> graph = new ArrayList<ArrayList<Node2>>();
    // 최단 거리 테이블 만들기
    public static int[] d = new int[100001];

    static void diskstra(int start) {
        PriorityQueue<Node2> pq = new PriorityQueue<>();
        //시작 노드로 가기 위한 최단 경로는 0으로 설정
        pq.offer(new Node2(start, 0));
        d[start] = 0;
        while(!pq.isEmpty()) {
            Node2 node = pq.poll(); // 가장 최단 경로 짧은 노드
            int dist = node.getDistance();
            int now = node.getIndex();
            // 현재 노드가 처리 된적 있다면 pass
            if(d[now] < dist) continue;

            // 현재 노드와 인접한 노드들 확인
            for(int i=0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧을 경우
                if(cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node2(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt(); C = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Node2>());
        }


        for(int i=0; i < M; i++){
            int x = sc.nextInt(); int y = sc.nextInt(); int z = sc.nextInt();
            graph.get(x).add(new Node2(y, z));
        }

        Arrays.fill(d, INF);

        diskstra(C);

        // 도달할 수 있는 노드의 개수
        int count = 0;
        // 도달할 수 있는 노드 중에서, 가장 멀리 있는 노드와의 최단 거리
        int maxDistance = 0;
        for (int i = 1; i <= N; i++) {
            // 도달할 수 있는 노드인 경우
            if (d[i] != INF) {
                count += 1;
                maxDistance = Math.max(maxDistance, d[i]);
            }
        }

        // 시작 노드는 제외해야 하므로 count - 1을 출력
        System.out.println((count - 1) + " " + maxDistance);

    }
}
