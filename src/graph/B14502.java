package graph;

import java.util.*;
import java.io.*;
public class B14502 {
    static int N, M;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};


    static int[][] copyArr(int[][] A) {
        int[][] temp = new int[N][M];

        for(int i=0; i < N; ++i) {
            for(int j=0; j < M; ++j)
                temp[i][j] = A[i][j];
        }
        return temp;
    }

    static int countZero(int[][] A) {
        int sum = 0;
        for(int i=0; i < N; ++i) {
            for(int j=0; j < M; ++j) {
                if(A[i][j] == 0)
                    ++sum;
            }
        }
        return sum;
    }
    static void bfs(int[][] A) {

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i < N; i++) {
            for(int j=0; j < M; j++) {
                if(A[i][j] == 2){
                    q.add(i); q.add(j);
                }
            }
        }

        while(!q.isEmpty()) {
            int y = q.poll();
            int x = q.poll();
            for(int i=0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(0 <= ny && ny < N && 0 <= nx && nx < M) {
                    if(A[ny][nx] == 0) {
                        A[ny][nx] = 2;
                        q.add(ny); q.add(nx);
                    }
                }
            }
        }
    }

    static int solve(int[][] A, int cnt) {
        if(cnt == 3) {
            bfs(A);
            return countZero(A);
        }

        int ans = 0;
        for(int i=0; i < N; ++i) {
            for(int j=0; j < M; ++j) {
                if(A[i][j] == 0) {
                    int[][] copy = copyArr(A);
                    copy[i][j] = 1;
                    int temp = solve(copy, cnt+1);
                    if(temp > ans)
                        ans = temp;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        for(int i=0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < M; ++j) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solve(A, 0));
    }
}
