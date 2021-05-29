package graph.done;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Curriculum {
    static int N;
    // 모든 노드에 대한 진입차수는 0으로 초기화
    public static int[] indegree = new int[501];
    // 각 노드에 연결된 간선 정보를 담기 위한 연결 리스트 초기화
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    // 각 강의 시간을 0으로 초기화
    public static int[] times = new int[501];

    static void topologiesSort() {
        int[] result = new int[501]; // 알고리즘 수행 결과를 담을 배열
        for (int i = 1; i <= N; i++) {
            result[i] = times[i];
        }

        Queue<Integer> q = new LinkedList<>(); // 큐 라이브러리 사용

        // 처음 시작할 때는 진입차수가 0인 노드를 큐에 삽입
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                result[graph.get(now).get(i)] = Math.max(result[graph.get(now).get(i)], result[now] + times[graph.get(now).get(i)]);
                indegree[graph.get(now).get(i)] -= 1;
                // 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
                if (indegree[graph.get(now).get(i)] == 0) {
                    q.offer(graph.get(now).get(i));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 방향 그래프의 모든 간선 정보를 입력받기
        for (int i = 1; i <= N; i++) {
            // 첫 번째 수는 시간 정보를 담고 있음
            int x = sc.nextInt();
            times[i] = x;
            // 해당 강의를 듣기 위해 먼저 들어야 하는 강의들의 번호 입력
            while (true) {
                x = sc.nextInt();
                if (x == -1) break;
                indegree[i] += 1;
                graph.get(x).add(i);
            }
        }

        topologiesSort();
    }
}
