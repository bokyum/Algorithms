package graph.done;

import java.util.*;
import java.io.*;

public class B16929 {
    static int N, M;
    static char[][] A;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};
    static boolean[][] check;
    static boolean dfs(int y, int x, int beforeY, int beforeX, char c) { // 3방향으로만 이동
        if(check[y][x])
            return true;
        check[y][x] = true;

        boolean ans = false;
        for(int i=0; i < 4; i++) {

            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny == beforeY && nx == beforeX)
                continue;
            if(0 <= ny && ny < N && 0 <= nx && nx < M && A[ny][nx] == c) {
                if(dfs(ny, nx, y, x, c)) {
                    ans = true;
                    break;
                }

            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = new char[N][M];
        sc.nextLine();
        for(int i=0; i < N; i++) {
            String temp = sc.nextLine();
            for(int j=0; j < M; j++)
                A[i][j] = temp.charAt(j);
        }

        boolean ans = false;
        Loop:
        for(int i=0; i < N; i++) {
            for(int j=0; j < M; j++) {
                check = new boolean[N][M];
                if(dfs(i, j, -1, -1, A[i][j])) {
                    ans = true;
                    break Loop;
                }
            }
        }
        if(ans)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

}
