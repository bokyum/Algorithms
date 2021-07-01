package graph.done;

import java.io.*;
import java.util.*;

public class B4991 {
    static int N, M;
    static int Y, X;
    static char[][] A;
    static int ans;
    static ArrayList<Integer> dirt;
    static boolean[] check;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][][] d;


    static void dfs(int oy, int ox, int dirtNum, int crt) {
        if(dirtNum == 0) {
            if(ans == -1 || ans > crt)
                ans = crt;
            return;
        }
        for(int i=0; i < check.length; i++) {
            if(!check[i]) {
                check[i] = true;
                int sum = d[i+1][oy][ox];
//                System.out.println(oy + " " + ox);
//                System.out.println(dirt.get(i*2) + " " + dirt.get(i*2+1) );
//                System.out.println("sum = " + sum);
                dfs(dirt.get(i*2), dirt.get(i*2+1), dirtNum-1, crt + sum);
                check[i] = false;

            }
        }
    }

    static int[][] bfs(int y, int x) {

        int[][] d = new int[N][M];

        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++) {
                d[i][j] = -1;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        d[y][x] = 0;
        q.add(y); q.add(x);

        while(!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = nowY + dy[i];
                int nx = nowX + dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M)
                    continue;
                if (d[ny][nx] != -1)
                    continue;
                if (A[ny][nx] == 'x')
                    continue;

                d[ny][nx] = d[nowY][nowX] + 1;
                q.add(ny);
                q.add(nx);

            }
        }
        return d;

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if(N ==0 && M == 0)
                break;
            A = new char[N][M];

            int dirtNum = 0;
            dirt = new ArrayList<>();
            for(int i=0; i < N; i++) {
                String s = br.readLine();
                for(int j=0; j < M; j++) {
                    A[i][j] = s.charAt(j);
                    if(A[i][j] == '*'){
                        dirt.add(i);
                        dirt.add(j);
                        dirtNum++;
                    }
                    if(A[i][j] == 'o') {
                        Y = i;
                        X = j;
                        A[i][j] = '.';
                    }
                }
            }
            d = new int[dirtNum+1][N][M];
            boolean ok = false;
            for(int i=0; i < dirtNum; i++) {
                d[i+1] = bfs(dirt.get(i*2), dirt.get(i*2+1));
                if(d[i+1][Y][X] == -1)
                    ok = true;
            }
            ans = -1;
            check = new boolean[dirtNum];
            if(ok)
                System.out.println(ans);
            else {
                dfs(Y, X, dirtNum, 0);
                System.out.println(ans);
            }
        }

    }
}
