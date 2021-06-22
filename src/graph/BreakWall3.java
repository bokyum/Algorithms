package graph;

import java.util.*;
import java.io.*;

public class BreakWall3 {
    static int N, M, K;
    static int[][] A;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};


    static int bfs() {
        int[][][][] d = new int[N][M][K+1][2];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 0)); // light == 0 == 낮  1 == 밤
        d[0][0][0][0] = 1;

        while(!q.isEmpty()) {
            Node n = q.poll();
            int y = n.y;
            int x = n.x;
            int z = n.z;
            int l = n.light;
            if(y == N-1 && x == M-1)
                break;
            //System.out.println(d[y][x][z][l]);

            for(int i=0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(0 <= ny && ny < N && 0 <= nx && nx < M) {
                    // 벽이 없으면 낮이던 밤이던 이동 가능
                    if(A[ny][nx] == 0 && d[ny][nx][z][(l+1)%2] == 0) {
                        d[ny][nx][z][(l+1)%2] = d[y][x][z][l] + 1;
                        q.add(new Node(ny, nx, z, (l+1) % 2));
                    }
                    // 낮인데 벽이 있으면 부시기 가능
                    if(l == 0 && A[ny][nx] == 1 && z+1 <= K && d[ny][nx][z+1][(l+1)%2] == 0) {
                        d[ny][nx][z+1][(l+1)%2] = d[y][x][z][l] + 1;
                        q.add(new Node(ny, nx, z+1, (l+1) % 2));
                    }
                    // 밤인데 벽이 있으면 이동할 수 없고 하루 기다리는건 가능
                    if(l == 1 && A[ny][nx] == 1  && d[y][x][z][(l+1) % 2] == 0) {
                        d[y][x][z][(l+1)%2] = d[y][x][z][l] + 1;
                        q.add(new Node(y, x, z, (l+1)%2));
                    }
                }

            }

        }

        int ans = -1;

        for(int i=0; i <= K; i++) {
            for(int j=0; j < 2; j++) {
                if(d[N-1][M-1][i][j] != 0) {
                    if(ans == -1 || d[N-1][M-1][i][j] < ans) {
                        ans = d[N-1][M-1][i][j];
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N][M];

        for(int i=0; i < N; i++) {
            String s = br.readLine();
            for(int j=0; j < M; j++) {
                A[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    private static class Node {
        int y, x, z, light;

        public Node(int y, int x, int z, int light) {
            this.y = y;
            this.x = x;
            this.z = z;
            this.light = light;
        }
    }
}
