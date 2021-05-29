package implement.retry;

import java.util.*;

public class B14503 {
    static int N, M;
    static int y,x,d; // d == 0 북 1 == 동 2==남 3==서
    static int[][] arr;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        y = sc.nextInt();
        x = sc.nextInt();
        d = sc.nextInt();

        arr = new int[N][M];
        for(int i=0; i < N; i++) {
            for(int j=0; j < M; j++)
                arr[i][j] = sc.nextInt();
        }


        int ans = 0;

        while(true) {
            if (arr[y][x] == 0) {
                arr[y][x] = -1;
                ans++;
            }

            if(arr[y+1][x] != 0 && arr[y-1][x] != 0 && arr[y][x+1] != 0 && arr[y][x-1] != 0) {
                if(arr[y-dy[d]][x-dx[d]] == 1)
                    break;
                else {
                    y -= dy[d];
                    x -= dx[d];
                }
            }
            else {
                d = (d + 3) % 4;
                if(arr[y + dy[d]][x + dx[d]] == 0) {
                    y += dy[d];
                    x += dx[d];
                }

            }
        }

        System.out.println(ans);
    }
}
