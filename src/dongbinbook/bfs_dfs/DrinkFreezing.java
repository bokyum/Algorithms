package dongbinbook.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DrinkFreezing {
    static int N, M;
    static String[] drinkArr;
    static final int[][] direct = {
            {-1, 0}, // 상
            {1, 0}, // 하
            {0, -1}, // 왼
            {0, 1}, // 오
    };
    static int[][] cache;
    static int solve(int y, int x) {
        if(drinkArr[y].charAt(x) == '1' || cache[y][x] == -1)
            return 0;
        //stack.add(drinkArr[y][x]);
        cache[y][x] = -1;
        for(int[] arr: direct) {
            if(y + arr[0] >= 0 && y + arr[0] < N && x + arr[1] >= 0 && x + arr[1] < M)
                solve(y+arr[0], x+arr[1]);
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = sc.nextInt();
        M = sc.nextInt();
        drinkArr = new String[N];
        cache = new int[N][M];
        for(int i=0; i < N; i++)
            drinkArr[i] = br.readLine();

        int ret = 0;
        for(int i=0; i < N; i++)
            for(int j=0; j < M; j++) {
                ret += solve(i, j);
            }
        System.out.println(ret);
    }
}
