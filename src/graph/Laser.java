package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Laser {
    static int H, W;
    static int[] razer = new int[4];
    static char[][] A;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int bfs() {


        PriorityQueue<Node> q = new PriorityQueue<>();
        int[][] check = new int[H][W];

        for(int i=0; i < H; i++) {
            for(int j=0; j < W; j++)
                check[i][j] = -1;
        }

        q.add(new Node(razer[0], razer[1], 0));
        check[razer[0]][razer[1]] = 0;

        while(!q.isEmpty()) {
            Node n = q.poll();
            int y = n.y;
            int x = n.x;


            for(int i=0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                while(0 <= ny && ny < H && 0 <= nx && nx < W) {
                    if((check[ny][nx] == -1 || check[ny][nx] == check[y][x] + 1)
                            && A[ny][nx] != '*') {
                        check[ny][nx] = check[y][x] + 1;
                        q.add(new Node(ny, nx, check[ny][nx]));
                        ny += dy[i];
                        nx += dx[i];
                    }
                    else {
                        break;
                    }
                }
            }
        }


        return check[razer[2]][razer[3]] - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        A = new char[H][W];
        int idx = 0;
        for(int i=0; i < H; i++) {
            String s = br.readLine();
            for(int j=0; j < W; j++) {
                char c = s.charAt(j);
                if(c == 'C') {
                    razer[idx++] = i;
                    razer[idx++] = j;
                }
                A[i][j] = c;
            }
        }

        System.out.println(bfs());

    }

    private static class Node implements Comparable<Node>{
        int y;
        int x;
        int w;


        public Node(int y, int x, int w) {
            this.y = y;
            this.x = x;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
    }
}
/*
7 8
C......
******.
.....*.
.***.*.
.*C..*.
.*...*.
.*****.
.......
*/