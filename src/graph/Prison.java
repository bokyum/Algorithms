package graph;

import java.util.*;
import java.io.*;
public class Prison {
    static int H, W;
    static String[] A;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int[][] bfs(int y, int x) {

        int[][] D = new int[H][W];

        for(int i=0; i < H; i++) {
            for(int j=0; j < W; j++) {
                D[i][j] = -1;
            }
        }

        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(y,x));
        D[y][x] = 0;

        while(!q.isEmpty()) {
            Node n = q.poll();
            int nowY = n.y;
            int nowX = n.x;
            for(int i=0; i < 4; i++) {
                int ny = nowY + dy[i];
                int nx = nowX + dx[i];
                if(ny < 0 || ny >= H || nx < 0 || nx >= W)
                    continue;
                if(D[ny][nx] != -1)
                    continue;
                char c = A[ny].charAt(nx);
                if(c == '*')
                    continue;
                if(c == '#') {
                    D[ny][nx] = D[nowY][nowX] + 1;
                    q.addLast(new Node(ny, nx));
                }
                else {
                    D[ny][nx] = D[nowY][nowX];
                    q.addFirst(new Node(ny, nx));
                }
            }
        }

        return D;
    }



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            A = new String[H + 2];

            for (int i = 1; i <= H; i++) {
                A[i] = '.' + br.readLine() + '.';
            }
            H += 2;
            W += 2;
            A[0] = "";
            A[H-1] = "";
            for (int i = 0; i < W; i++) {
                A[0] += '.';
                A[H-1] += '.';
            }


            int[][] d0 = bfs(0, 0);
            int y1, x1, y2, x2;
            y1 = x1 = y2 = x2 = -1;
            for(int i=0; i < H; i++) {
                for(int j=0; j < W; j++) {
                    if(A[i].charAt(j) == '$') {
                        if(y1 == -1) {
                            y1 = i;
                            x1 = j;
                        }
                        else {
                            y2 = i;
                            x2 = j;
                        }
                    }
                }
            }

            int[][] d1 = bfs(y1, x1);
            int[][] d2 = bfs(y2, x2);
            int ans = H * W;
            for(int i=0; i < H; i++) {
                for(int j=0; j < W; j++) {
                    char c = A[i].charAt(j);
                    if(c == '*') continue;
                    if(d0[i][j] == -1 || d1[i][j] == -1 || d2[i][j] == -1)
                        continue;
                    int cur = d0[i][j] + d1[i][j] + d2[i][j];
                    if(c == '#') cur -=2;
                    if(ans > cur) ans = cur;
                }
            }
            System.out.println(ans);
        }

    }

    private static class Node{
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
