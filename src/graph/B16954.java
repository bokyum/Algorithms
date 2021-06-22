package graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class B16954 {
    static final int N = 8;
    static int[] dy = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] move = new char[N][N];
        for(int i=0; i < N; i++) {
            String s = br.readLine();
            for(int j=0; j < N; j++) {
                move[i][j] = s.charAt(j);

            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N-1, 0, 0));
        boolean[][][] check = new boolean[N][N][N+1];

        while(!q.isEmpty()) {
            Node n = q.poll();
            int y = n.y;
            int x = n.x;
            int w = n.w;

            if((y == 0 && x == N-1)) {
                System.out.println(1);
                System.exit(0);
            }

            for(int i=0; i < 9; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                int nw = Math.min(w+1, 8);
                if(0 <= ny && ny < N && 0 <= nx && nx < N) {
                    if(ny - w >= 0 && move[ny-w][nx] == '#') continue;
                    if(ny - nw >= 0 && move[ny-nw][nx] == '#') continue;
                    if(!check[ny][nx][nw]) {
                        check[ny][nx][nw] = true;
                        q.add(new Node(ny, nx, nw));
                    }

                }
            }

        }

        System.out.println(0);

    }

    private static class Node{
        int y; int x; int w;

        public Node(int y, int x, int w) {
            this.y = y;
            this.x = x;
            this.w = w;
        }
    }
}
