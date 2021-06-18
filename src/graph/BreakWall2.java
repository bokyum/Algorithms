package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreakWall2 {
    static int N, M, K;
    static int[][] A;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int bfs() {
        int[][][] d = new int[N][M][K+1];
        d[0][0][0] = 1;
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(0, 0, 0));


        while(!q.isEmpty()) {
            Node n = q.poll();
            int y = n.y;
            int x=  n.x;
            int z = n.z;
            if(y == N-1 && x == M-1) {
                break;
            }

            for(int i=0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                // 벽이 아닐때 그냥 이동 가능 // 현재 벽이던지 아니던지
                // 벽이고 k가 남았을 때 부시고 이동 가능
                // 벽이고 k가 안남았을 때 이동 불가능
                if(0 <= ny && ny < N && nx >= 0 && nx < M) {
                    if (A[ny][nx] == 0 && d[ny][nx][z] == 0) {
                        d[ny][nx][z] = d[y][x][z] + 1;
                        q.add(new Node(ny, nx, z));
                    }
                    if (z + 1 <= K && d[ny][nx][z + 1] == 0) {
                        d[ny][nx][z + 1] = d[y][x][z] + 1;
                        q.add(new Node(ny, nx, z + 1));
                    }
                }


            }
        }
        int ans = -1;

        for(int i=0; i <= K; i++) {
            if(d[N-1][M-1][i] != 0) {
                if(ans == -1 || d[N-1][M-1][i]< ans)
                    ans = d[N-1][M-1][i];
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N][M];

        for(int i=0; i < N; ++i) {
            String s = br.readLine();
            for(int j=0; j < M; ++j) {
                A[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    private static class Node {
        int y; int x; int z;

        public Node(int y, int x, int z) {
            this.y = y;
            this.x = x;
            this.z = z;
        }
    }
}
