package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1600 {
    static int[][] A;
    static int K, Y, X;
    static int[] horseY = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] horstX = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int bfs() {
        int[][][] d = new int[Y][X][K+1];
        for(int i=0; i < Y; i++)
            for(int j=0; j < X; j++)
                for(int k=0; k <= K; k++)
                    d[i][j][k] = -1;

        d[0][0][K] = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, K));

        while(!q.isEmpty()) {
            Node n = q.poll();
            int y = n.y;
            int x = n.x;
            int k = n.k;

            if(k > 0) {
                for (int i = 0; i < 8; i++) {
                    int ny = y + horseY[i];
                    int nx = x + horstX[i];
                    if (ny < 0 || ny >= Y || nx < 0 || nx >= X)
                        continue;
                    if (A[ny][nx] == 1) {
                        continue;
                    }
                    if(d[ny][nx][k-1] == -1) {
                        d[ny][nx][k-1] = d[y][x][k] + 1;
                        q.add(new Node(ny, nx, k-1));
                    }
                    else if(d[ny][nx][k-1] > d[y][x][k] + 1) {
                        d[ny][nx][k-1] = d[y][x][k] + 1;
                        q.add(new Node(ny, nx, k-1));
                    }
                }
            }
            for(int i=0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || ny >= Y || nx < 0 || nx >= X)
                    continue;
                if(A[ny][nx] == 1)
                    continue;

                if(d[ny][nx][k] == -1) {
                    d[ny][nx][k] = d[y][x][k] + 1;
                    q.add(new Node(ny, nx, k));
                }
                else if(d[ny][nx][k] > d[y][x][k] + 1) {
                    d[ny][nx][k] = d[y][x][k] + 1;
                    q.add(new Node(ny, nx, k));
                }
            }
        }
        int ans = -1;

        for(int k=0; k <= K; k++) {
            if(d[Y-1][X-1][k] == -1)
                continue;
            if(ans == -1)
                ans = d[Y-1][X-1][k];
            else if(d[Y-1][X-1][k] < ans)
                ans = d[Y-1][X-1][k];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        X = sc.nextInt();
        Y = sc.nextInt();
        A = new int[Y][X];

        for(int i=0; i < Y; i++ ) {
            for(int j=0; j < X; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        System.out.println(bfs());
    }

    private static class Node {
        int y; int x; int k;

        public Node(int y, int x, int k) {
            this.y = y;
            this.x = x;
            this.k = k;
        }
    }
}
