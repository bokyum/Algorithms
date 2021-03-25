package implementation;

import java.util.Scanner;

public class GameBoard03 {
// 1. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 갈 곳을 정한다.
    // 2. 캐릭터의 바로 왼쪽 방향에 아직 가보지 않은 칸이 존재한다면, 왼쪽 방향으로 회전한 다음 왼쪽으로 한 칸을 전진한다.
    //      왼쪽 방향에 가보지 않은 칸이 없다면, 왼쪽 방향으로 회전만 수행하고 1단계로 돌아간다.
    // 3. 만약 네 방향 모두 이미 가본 칸이거나 바다로 되어 있는 칸인 경우에는, 바라보는 방향을 유지한 채로 한 칸 뒤로 가고 1단계로 돌아간다.
    //   단, 이때 뒤쪽 방향이 바다인 칸이라 뒤로 갈 수 없는 경우에는 움직임을 멈춘다.
    static int[][] direct = {
            {-1, 0}, //북쪽
            {0, 1}, //동쪽
            {1, 0}, //남쪽
            {0, -1} //서
    };
    static int N, M, y, x, look;
    static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();
        board = new int[N][M];
        y = sc.nextInt(); // y축 위치
        x = sc.nextInt(); // x축 위치
        look = sc.nextInt();

        int ret = 0;

        for(int i=0; i < N; i++)
            for(int j=0; j < M; j++)
                board[i][j] = sc.nextInt();

        if(board[y][x] == 0) { // 현재 있는 칸이 육지라면
            ret++;
            board[y][x] = -1;
        } else {
            System.out.println(0); // 육지가 아니라면 있을 수 없음
            return;
        }

        int count = 0;

        while(true) {

            look++; // 0, 1, 2, 3 북, 동, 남, 서, 방향 정하기


            if (look > 3) look = 0; // 만약 4이상에 숫자가 된다면 0으로 되돌아옴
            int moveY = y + direct[look][0]; // y축 이동할 수 있는 방향
            int moveX = x + direct[look][1]; // x축 이동할 수 있는 방향

            if (count > 4) {
                if (0 <= moveY && moveY < N && 0 <= moveX && moveX < M && board[moveY][moveX] == -1) {
                    //ret++; // 바라보는 방향 유지한 채로 한 칸 뒤로 가고 1단계로 돌아감
                    look += 2; // 일단 뒤로
                    if (look>= 4)
                        look -= 4;
                    y = y + direct[look][0];
                    x = x + direct[look][1];
                    board[y][x] = -1;
                    look += 2;
                    if (look >= 4)
                        look -= 4;
                    count = 0; // 이동 했다면 count는 다시 0으로
                } else {
                    break;
                }
            } else { // 만약 갈 수 있고 육지라면 이동
                if (0 <= moveY && moveY < N && 0 <= moveX && moveX < M && board[moveY][moveX] == 0) {
                    ret++;
                    y = moveY; x = moveX;
                    board[y][x] = -1;
                    count = 0; // 이동 했다면 count는 다시 0으로
                } else {
                    count++;
                }
            }
        }

        System.out.println(ret);
    }
}
