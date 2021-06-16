package graph.done;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16928 {
    static int N, M;
    static boolean[] board;
    static int[] sadariAndSnake;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new boolean[100];
        sadariAndSnake = new int[100];
        for(int i=0; i < N; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            sadariAndSnake[x] = y;
        }

        for(int i=0; i < M; i++){
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            sadariAndSnake[u] = v;
        }
        // 1은 사다리 있는 곳 2는 뱀 있는 곳


        Queue<Node> q = new LinkedList<>();

        q.add(new Node(0, 0));

        int ans = 100;
        while(!q.isEmpty()) {
            Node now = q.poll();
            int idx = now.now;
            int weight = now.weight;
            board[idx] = true;

            if(idx == 99) {
                ans = weight;
                break;
            }
            for(int i=6; i > 0; i--) {
                if(idx + i >= 100 || board[idx+i])
                    continue;
                int nowIdx = idx + i;
                if(sadariAndSnake[idx+i] != 0)
                    nowIdx = sadariAndSnake[idx+i];
                q.add(new Node(nowIdx, weight+1));
            }
        }

        System.out.println(ans);

    }

    private static class Node {
        int now;
        int weight;

        public Node(int now, int weight) {
            this.now = now;
            this.weight = weight;
        }
    }
}
