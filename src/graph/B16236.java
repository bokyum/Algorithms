package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16236 {
    static int N;
    static int[][] A;
    static int[] shark = new int[3];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int bfs(int y, int x) {

        Queue<Node> q = new LinkedList<>();
        boolean[][] check = new boolean[N][N];
        q.add(new Node(y, x, 0));
        check[y][x] = true;
        PriorityQueue<Node> pq = new PriorityQueue<>();

        while(!q.isEmpty()) {
            Node n = q.poll();
            int cy = n.y;
            int cx = n.x;
            int cw = n.w;
            if(A[cy][cx] > 0 && A[cy][cx] < shark[2]) {
                pq.add(new Node(cy, cx, cw));
                continue;
            }

            for(int i=0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(0 <= ny && ny < N && 0 <= nx && nx < N) {
                    if(!check[ny][nx] && A[ny][nx] <= shark[2]) {
                        check[ny][nx] = true;
                        q.add(new Node(ny, nx, cw + 1));
                    }
                }
            }

        }
        if(pq.isEmpty())
            return 0;
        else {
            Node n = pq.poll();
            shark[0] = n.y; shark[1] = n.x;
            A[n.y][n.x] = 0;
            return n.w;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N][N];

        for(int i=0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 9) {
                    shark[0] = i; shark[1] = j; shark[2] = 2;
                }
                else
                    A[i][j] = temp;
            }

        }

        int moving = 0;
        int cnt = 0;
        while(true) {
            int temp = bfs(shark[0], shark[1]);
            if(temp == 0)
                break;
            else{
                moving += temp;
                cnt++;
                if(cnt == shark[2]) {
                    shark[2]++;
                    cnt = 0;
                }
            }
        }

        System.out.println(moving);


    }

    private static class Node implements Comparable<Node>{
        int y; int x; int w;

        public Node(int y, int x, int w) {
            this.y = y;
            this.x = x;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            if(w < o.w) {
                return -1;
            }
            else if(w == o.w) {
                if(y < o.y) {
                    return -1;
                }
                else if(y == o.y) {
                    return x - o.x;
                }
                else
                    return 1;
            }
            else
                return 1;
        }
    }
}
