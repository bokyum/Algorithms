package graph.retry;

import java.io.*;
import java.util.*;

public class B16929r {
    static int N, M;
    static char[][] A;
    static boolean[][] check;
    static int[][] dist;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean dfs(int y, int x, int crt, char color) {
        if(check[y][x]) {
            return crt - dist[y][x] >= 4;
        }
        check[y][x] = true;
        dist[y][x] = crt;
        for(int i=0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(0 <= ny && ny < N && 0 <= nx && nx < M) {

                if(A[ny][nx] == color && dfs(ny, nx, crt+1, color))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new char[N][M];
        check = new boolean[N][M];

        for(int i=0; i < N; i++) {
            String s = br.readLine();
            for(int j=0; j < M; j++) {
                A[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i < N; i++) {
            for(int j=0; j < M; j++) {
                if(check[i][j])
                    continue;
                dist = new int[N][M];
                if(dfs(i, j, 0, A[i][j])){
                    System.out.println("Yes");
                    System.exit(0);
                }
            }
        }
        System.out.println("No");
    }
}
