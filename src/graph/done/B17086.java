package graph.done;

import java.io.*;
import java.util.*;

public class B17086 {
    static int n, m;
    static int[][] A;
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    static int bfs(int y, int x) {

        int[][] d = new int[n][m];
        for(int i=0; i < n; i++)
            for(int j=0; j < m; j++)
                d[i][j] = -1;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));
        d[y][x] = 0;

        while(!q.isEmpty()) {
            Node now = q.poll();
            int nowY = now.y;
            int nowX = now.x;

            for (int i = 0; i < 8; i++) {
                int ny = nowY + dy[i];
                int nx = nowX + dx[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m)
                    continue;
                if (d[ny][nx] == -1) {
                    if(A[ny][nx] == 1) {
                        return d[nowY][nowX] + 1;
                    }else {
                        q.add(new Node(ny, nx));
                        d[ny][nx] = d[nowY][nowX] + 1;
                    }
                }
            }

        }
        return 0;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n][m];

        for(int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < m; j++)
                 A[i][j] = Integer.parseInt(st.nextToken());
        }


        int ans = 0;
        for(int i=0; i < n; i++) {
            for(int j=0; j < m; j++) {
                if(A[i][j] == 0) {
                    int d = bfs(i, j);
                    if(d > ans)
                        ans = d;
                }
            }
        }

        System.out.println(ans);
    }

    private static class Node {
        int y;
        int x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
