package graph;

import java.io.*;
import java.util.*;
public class BreakWall4 {

    static int N, M;
    static int[][] A;
    static int[][] check;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int cnt;
    static void bfs(int[][] zero, int y, int x) {

        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        q.add(x);
        zero[y][x] = 1;
        check[y][x] = cnt;
        Queue<Integer> changed = new LinkedList<>();
        changed.add(y);
        changed.add(x);
        int max = zero[y][x];
        while(!q.isEmpty()) {
            int nowY = q.poll();
            int nowX = q.poll();

            for(int i=0; i < 4; i++) {
                int ny = nowY + dy[i];
                int nx = nowX + dx[i];
                if(0 <= ny && ny < N && 0 <= nx && nx < M) {
                    if(A[ny][nx] == 0 && check[ny][nx] == 0&& zero[ny][nx] == 0) {
                        q.add(ny); q.add(nx);
                        changed.add(ny); changed.add(nx);
                        check[ny][nx] = cnt;
                        zero[ny][nx] = zero[nowY][nowX] + 1;
                        ++max;
                    }
                }
            }
        }

        while(!changed.isEmpty()) {
            int ny = changed.poll();
            int nx = changed.poll();
            zero[ny][nx] = max;
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        int[][] zero = new int[N][M];
        for(int i=0; i < N; ++i){
            String s = br.readLine();
            for( int j= 0; j < M; j++){
                A[i][j] = s.charAt(j) - '0';
            }
        }

        cnt = 0;
        check = new int[N][M];
        for(int i=0; i < N; i++) {
            for(int j=0; j < M; j++) {
                if(A[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(0 <= ny && ny < N && 0 <= nx && nx < M) {
                            if(A[ny][nx] == 0 && check[ny][nx] == 0) {
                                cnt++;
                                bfs(zero, ny, nx);
                            }
                        }
                    }
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(0 <= ny && ny < N && 0 <= nx && nx < M) {
                            if(set.add(check[ny][nx]))
                                A[i][j] += zero[ny][nx];

                        }
                    }


                }
            }
        }


        for(int i=0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j < M; j++) {
                sb.append(A[i][j]%10);
            }
            sb.append('\n');
            System.out.print(sb.toString());
        }
    }
}
