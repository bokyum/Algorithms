package jongmanbook.Chap08;

import java.util.Scanner;

public class TrianglePath {
    static int N;
    static int[][] triangleArr;
    static int[][] cache;

    static int solve(int y,int x) {
        if(y == N-1) // 마지막 line에 도달
            return triangleArr[y][x];
        if(cache[y][x] != -1)
            return cache[y][x];
        return cache[y][x] = Math.max(solve(y+1, x), solve(y+1, x+1))
                + triangleArr[y][x];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();

        while(C-- > 0) {
            N = sc.nextInt();
            triangleArr = new int[N][N];
            cache = new int[N][N];
            for(int i=0; i < N; i++) {
                for(int j=0; j < i+1; j++) {
                    triangleArr[i][j] = sc.nextInt();
                    cache[i][j] = -1;
                }
            }

            System.out.println(solve(0, 0));
        }
    }
}
