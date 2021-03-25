package jongmanbook.Chap08.retry;

import java.util.Scanner;

public class JumpGameRetry {
    static int[][] board;
    static int[][] cache;
    static final int FULL_SIZE = 200;
    static int N;

    //오른쪽이나 아래 칸으로만 움직일 수 있음
    // -1 == 아직 검사안함 0 == 도달 불가 1 == 도달 가능
    static int solve(int y, int x) {
        if(y >= N || x >= N) // 기저사례 범위를 초과한 경우
            return 0;
        if(y == (N-1) && x == (N-1)) // 기저사례 목적지에 도착한 경우
            return 1;
        if(cache[y][x] != -1) // 기저사례 cache 값이 이미 사용된 경우
            return cache[y][x];

        // cache[y][x]가 0이면 아직 검사 안했다는 뜻
        // 점프 하는 단계
        int jump = board[y][x];

        return cache[y][x] = (solve(y + jump, x) | solve(y, x + jump));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();

        while(C-- > 0) {
            N = sc.nextInt();

            // board arr 입력
            board = new int[N][N];
            for(int i=0; i < N; i++) {
                for (int j = 0; j < N; j++)
                    board[i][j] = sc.nextInt();
            }
            // cache 초기화 -1으로;
            cache = new int[FULL_SIZE][FULL_SIZE];
            for(int i=0; i < FULL_SIZE; i++){
               for(int j=0; j < FULL_SIZE; j++)
                    cache[i][j] = -1;
            }

            if(solve(0, 0) == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}

/*      2
        7
        2 5 1 6 1 4 1
        6 1 1 2 2 9 3
        7 2 3 2 1 3 1
        1 1 3 1 7 1 2
        4 1 2 3 4 1 2
        3 3 1 2 3 4 1
        1 5 2 9 4 7 0
        7
        2 5 1 6 1 4 1
        6 1 1 2 2 9 3
        7 2 3 2 1 3 1
        1 1 3 1 7 1 2
        4 1 2 3 4 1 3
        3 3 1 2 3 4 1
        1 5 2 9 4 7 0 */
