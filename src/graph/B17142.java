package graph;

import java.util.*;
import java.io.*;

public class B17142 {
    static int N, M;
    static int[][] A;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int bfs(ArrayList<Node> now) {

        Queue<Node> q = new LinkedList<>();

        int[][] d = new int[N][N];
        for(int i=0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                d[i][j] = -1;
            }
        }

        for(Node n: now) {
            q.add(n);
            d[n.y][n.x] = 0;
        }


        while(!q.isEmpty()) {
            Node n = q.poll();
            int y = n.y;
            int x = n.x;
            for(int i=0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || ny >= N || nx < 0 || nx >= N)
                    continue;
                if(d[ny][nx] != -1 || A[ny][nx] == 1)
                    continue;

                d[ny][nx] = d[y][x] + 1;
                q.add(new Node(ny, nx));



            }
        }

        int ans = 0;
        for(int i=0; i < N; i++) {
            for(int j=0; j < N; j++) {
                if(A[i][j] == 1)
                    continue;
                if(d[i][j] == -1)
                    return -1;
                if(A[i][j] == 0 && ans < d[i][j])
                    ans = d[i][j];
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        ArrayList<Node> virus = new ArrayList<>();

        for(int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if(A[i][j] == 2) {
                    virus.add(new Node(i, j));
                }
            }
        }

        int virusNum = virus.size();

        int ans = -1;
        for(int i=0; i < (1 << virusNum); i++) {
            ArrayList<Node> now = new ArrayList<>();
            for(int j=0; j < virusNum; j+=1) {
                if((i & (1 << j)) == (1 << j)) {
                    now.add(virus.get(j));
                }
            }
            if(now.size() == M) {
                int temp = bfs(now);
                if(ans == -1 || (temp != -1 && ans > temp))
                    ans = temp;
            }
        }


        System.out.println(ans);

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
