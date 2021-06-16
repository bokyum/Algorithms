package graph.done;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16948 {
    static final int[] dy = {-2, -2, 0, 0, 2, 2};
    static final int[] dx = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();


        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r1, c1, 0});
        boolean[][] check = new boolean[N][N];
        check[r1][c1] = true;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];
            int w = now[2];
            if(y == r2 && x == c2) {
                System.out.println(w);
                return;
            }

            for(int i=0; i < 6; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(0 <= ny && ny < N && 0 <= nx && nx < N) {
                    if(!check[ny][nx]) {
                        q.add(new int[]{ny, nx, w+1});
                        check[ny][nx] = true;
                    }
                }
            }
        }
        System.out.println(-1);




    }
}
