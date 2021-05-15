package baekjoon.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class YX {
    int y;
    int x;

    public YX(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class B1012 {
    static int[][] arr;
    static int[][] direct = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    static int N, M, K;
    static int bfs(int y, int x) {
        Queue<YX> q = new LinkedList<>();
        if(arr[y][x] == 0)
            return 0;
        q.add(new YX(y, x));

        while(!q.isEmpty()) {
            YX n = q.poll();
            int tempY = n.y;
            int tempX = n.x;
            for(int i=0; i < 4; i++) {
                int dy = tempY + direct[i][0];
                int dx = tempX + direct[i][1];
                if(dy < N && dy >= 0 && dx < M && dx >=0){
                    if(arr[dy][dx] == 1) {
                        arr[dy][dx] = 0;
                        q.add(new YX(dy, dx));
                    }
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N][M];
            for(int i=0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int tempY = Integer.parseInt(st.nextToken());
                int tempX = Integer.parseInt(st.nextToken());
                arr[tempY][tempX] = 1;
            }
            int answer = 0;
            for(int i=0; i < N; i++) {
                for(int j=0; j < M; j++) {
                    answer += bfs(i, j);
                }
            }
            System.out.println(answer);
        }


        br.close();
    }
}
