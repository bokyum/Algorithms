package graph.done;

import java.util.*;

class YX1 {
    int y;
    int x;

    public YX1(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class B2667 {
    static int N;
    static final int[] dy = new int[] {0, 0, 1, -1};
    static final int[] dx = new int[] {-1, 1, 0, 0};

    static int bfs(int[][] arr, int y, int x) {
        Queue<YX1> q = new LinkedList<>();
        q.add(new YX1(y, x));
        arr[y][x] = 0;
        int cnt = 1;

        while(!q.isEmpty()) {
            YX1 yx = q.poll();
            int cy = yx.y;
            int cx = yx.x;
            for(int i=0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(0 <= ny && ny < N && 0<= nx && nx < N && arr[ny][nx] == 1) {
                    q.add(new YX1(ny, nx));
                    cnt++;
                    arr[ny][nx] = 0;
                }

            }
        }

        return cnt;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] arr = new int[N][N];
        sc.nextLine();


        for(int i=0; i<N; i++) {
            String temp = sc.nextLine();
            for(int j=0; j < N; j++) {
                arr[i][j] = Integer.parseInt(temp.substring(j, j+1));
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i < N; i++) {
            for(int j=0; j < N; j++) {
                if(arr[i][j] == 1)
                    result.add(bfs(arr, i, j));
            }
        }

        System.out.println(result.size());
        Collections.sort(result);
        for(int r: result)
            System.out.println(r);
    }
}
