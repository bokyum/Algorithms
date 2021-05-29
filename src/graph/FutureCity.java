package graph;

import java.util.Arrays;
import java.util.Scanner;

public class FutureCity {

    static int N, M; // N -> 노드 개수, M --> 간선의 개수
    static int X, K; // 1번 -> K번 -> X번 도착해야함 Floyd_Warshall 사용
    static final int INF = (int)1e9;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();

        arr = new int[N+1][N+1];

        for(int i=0; i<N+1; i++) { // 초기 INF로 초기화
            Arrays.fill(arr[i], INF);
        }

        for(int i=0; i<M; i++) { // 입력된 노드 간선 입력
            int node1 = sc.nextInt();
            int node2 = sc.nextInt(); // 모든 노드의 거리는 1
            arr[node1][node2] = 1; arr[node2][node1] = 1;
        }

        X = sc.nextInt(); K = sc.nextInt();

        for(int i=0; i<N+1; i++) // 자기 자신의 거리는 항상 0
            for(int j=0; j<N+1; j++)
                if(i == j)
                    arr[i][j] = 0;

        for(int k=1; k<N+1; k++)
            for(int i=1; i<N+1; i++)
                for(int j=1; j<N+1; j++)
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);

        if(arr[1][K] == INF || arr[K][X] == INF)
            System.out.println(-1);
        else
            System.out.println(arr[1][K] + arr[K][X]);


    }
}
