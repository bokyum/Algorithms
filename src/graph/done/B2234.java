package graph.done;

import java.util.*;
import java.io.*;

public class B2234 {
    static int N, M, crt;
    static int max = -1;
    static int[][] A;
    static int[][] d;
    static int[][] pos;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};

    static void bfs(int y, int x) {
        // 1 1 1 1  남 동 북 서

        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> rst = new LinkedList<>();
        q.add(y);q.add(x);
        rst.add(y);rst.add(x);
        d[y][x] = 1;
        int count = 1;
        while(!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();

            for(int i=0; i < 4; i++) {
                if ((A[nowY][nowX] & (1 << i)) == 0) {
                    int ny = nowY + dy[i];
                    int nx = nowX + dx[i];
                    if(0 <= ny && ny < N && 0 <= nx && nx < M) {
                        if(d[ny][nx] == 0) {
                            d[ny][nx] = d[nowY][nowX] + 1;
                            q.add(ny); q.add(nx);
                            rst.add(ny); rst.add(nx);
                            count++;
                        }
                    }
                }
            }
        }

        while(!rst.isEmpty()) {
            int ny = rst.poll();
            int nx = rst.poll();
            d[ny][nx] = count;
            pos[ny][nx] = crt;
        }
        if(max == -1 || max < count)
            max = count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        d = new int[N][M];
        pos = new int[N][M];
        for(int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                d[i][j] = 0;
            }
        }
        crt = 0;
        for(int i=0; i < N; i++) {
            for(int j=0; j < M; j++) {
                if(d[i][j] == 0) {
                    bfs(i, j);
                    crt++;
                }
            }
        }

        int[][] B = new int[N][M];
        for(int i=0; i < N; i++) {
            for(int j=0; j < M; j++) {
                int maxValue = 0;
                for(int k=0; k < 4; k++) {
                    if((A[i][j] & (1 << k)) == (1 << k)) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(0 <= ny && ny < N && 0 <= nx && nx < M) {
                            if(pos[i][j] != pos[ny][nx]) {
                                if(d[ny][nx] > maxValue)
                                    maxValue = d[ny][nx];
                            }
                        }
                    }
                }
                B[i][j] = d[i][j] + maxValue;
            }
        }

        System.out.println(crt);
        System.out.println(max);

        int ans = 0;
        for(int i=0; i < N; i++) {
            for(int j=0; j < M; j++) {
                if(ans < B[i][j])
                    ans = B[i][j];
            }
        }
        System.out.println(ans);

    }
}
