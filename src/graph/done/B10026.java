package graph.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B10026 {
    static int N;
    static boolean[][] C;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static void bfs(char[][] A, int y, int x) {

        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        q.add(x);
        int c = A[y][x];
        C[y][x] = true;
        while(!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();

            for(int i=0; i < 4; i++) {
                int ny = nowY + dy[i];
                int nx = nowX + dx[i];
                if(0 <= ny && ny < N && 0 <= nx && nx < N) {
                    if(!C[ny][nx] && A[ny][nx] == c) {
                        q.add(ny);
                        q.add(nx);
                        C[ny][nx] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] A = new char[N][N];
        char[][] B = new char[N][N];

        for(int i=0; i < N; i++) {
            String s = br.readLine();
            for(int j=0; j < N; j++) {
                char c = s.charAt(j);
                A[i][j] = c;
                B[i][j] = c;
                if(B[i][j] == 'R')
                    B[i][j] = 'G';
            }
        }
        int ansA = 0;
        C = new boolean[N][N];
        for(int i=0; i < N; i++) {
            for(int j=0; j < N; j++) {
                if(!C[i][j]) {
                    bfs(A, i, j);
                    ansA++;
                }
            }
        }

        int ansB = 0;
        C = new boolean[N][N];
        for(int i=0; i < N; i++) {
            for(int j=0; j < N; j++) {
                if(!C[i][j]) {
                    bfs(B, i, j);
                    ansB++;
                }
            }
        }

        System.out.println(ansA + " " + ansB);
    }
}
