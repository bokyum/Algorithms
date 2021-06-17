package graph;

import java.io.*;
import java.util.*;


public class B2206 {
    static int N, M;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];

        for(int i=0; i < N; i++) {
            String s = br.readLine();
            for(int j=0; j < M; j++) {
                A[i][j] = s.charAt(j) - '0';

            }
        }

        Queue<Node> q = new LinkedList<>();
        int[][][] d = new int[N][M][2];
        d[0][0][0] = 1;
        q.add(new Node(0, 0, 0));

        while(!q.isEmpty()) {
            Node n = q.poll();
            int y = n.y;
            int x = n.x;
            int z = n.z;
            if(y == N-1 && x == M-1) {
                break;
            }

            for(int i=0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(0 <= ny && ny < N && 0 <= nx && nx < M) {
                    // 다음 칸이 0일때 부스던지 안부스던지 이동 가능
                    // 한번 부스고 1이면 이동할 수 없음
                    // 한번도 안부스고 1이면 부스고 이동 가능
                    if(d[ny][nx][z] == 0 && A[ny][nx] == 0) {
                        q.add(new Node(ny, nx, z));
                        d[ny][nx][z] = d[y][x][z] + 1;
                    }
                    if(z == 0 && d[ny][nx][1] == 0 &&A[ny][nx] == 1) {
                        q.add(new Node(ny, nx, z+1));
                        d[ny][nx][1] = d[y][x][0] + 1;
                    }
                }
            }

        }

        if (d[N - 1][M - 1][0] != 0 && d[N-1][M-1][1] != 0) {
            System.out.println(Math.min(d[N - 1][M - 1][0], d[N-1][M-1][1]));
        }
        else if(d[N - 1][M - 1][0] != 0)
            System.out.println(d[N - 1][M - 1][0]);
        else if(d[N - 1][M - 1][1] != 0)
            System.out.println(d[N - 1][M - 1][1]);
        else
            System.out.println(-1);

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
