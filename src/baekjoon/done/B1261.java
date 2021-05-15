package baekjoon.done;

import java.util.*;

class YX1 implements Comparable<YX1>{
    int y;
    int x;
    int cnt;

    public YX1(int y, int x, int cnt) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(YX1 o) {
        return this.cnt - o.cnt;
    }
}

public class B1261 {
    static int N, M;
    static int[][] direct = { {0, 1}, {0, -1}, {1, 0}, {-1, 0}};



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();
        int[][] maze = new int[M][N];
        boolean[][] isChecked = new boolean[M][N];

        sc.nextLine();
        for(int i =0; i < M; i++) {
            String temp = sc.nextLine();
            for(int j=0; j < N; j++)
                maze[i][j] = Character.getNumericValue(temp.charAt(j));

        }

        PriorityQueue<YX1> pq = new PriorityQueue<>();
        pq.add(new YX1(0,0, 0));
        while(!pq.isEmpty()) {
            YX1 yx = pq.poll();
            int y = yx.y;
            int x=  yx.x;
            int cnt = yx.cnt;
            if(y == M-1 && x == N-1) {
                System.out.println(cnt);
                break;
            }
            if(isChecked[y][x] == true)
                continue;

            isChecked[y][x] = true;
            for(int i=0; i<4; i++) {
                int ny = y + direct[i][0];
                int nx = x + direct[i][1];
                if(0 <= ny && ny < M && 0 <= nx && nx < N) {
                    if(!isChecked[ny][nx]) {
                        if(maze[ny][nx] == 0)
                            pq.add(new YX1(ny, nx, cnt));
                        else
                            pq.add(new YX1(ny, nx, cnt+1));
                    }
                }
            }

        }
    }
}
