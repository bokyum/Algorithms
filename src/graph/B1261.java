package graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class B1261 {
    static final int[] dy = {0, 0, 1, -1};
    static final int[] dx = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();
        int[][] miro = new int[N][M];
        int[][] d = new int[N][M];

        for(int i=0; i < N; i++) {
            String data = sc.nextLine();
            for(int j=0; j < M; j++) {
                miro[i][j] = data.charAt(j) - '0';
                d[i][j] = -1;
            }
        }
        Queue<Integer> q0 = new LinkedList<>();
        Queue<Integer> q1 = new LinkedList<>();
        q0.add(0); // y
        q0.add(0); // x
        d[0][0] = 0;

        while(!q0.isEmpty()) {
            int y = q0.remove();
            int x = q0.remove();


            for(int i=0; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(0 <= ny && ny < N && 0 <= nx && nx < M && d[ny][nx] == -1 ) {
                    if(miro[ny][nx] == 0) {
                        d[ny][nx] = d[y][x];
                        q0.add(ny);
                        q0.add(nx);
                    }
                    else {
                        d[ny][nx] = d[y][x]+1;
                        q1.add(ny);
                        q1.add(nx);
                    }

                }
            }
            if(q0.isEmpty()) {
                q0 = q1;
                q1 = new LinkedList<>();

            }
        }
        System.out.println(d[N-1][M-1]);
    }
}
