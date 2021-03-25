package jongmanbook.Chap06.retry;

import java.io.*;
import java.util.Scanner;
/*
* 1. block이 모두 #이면 +1
* 2. coverType 0 ~ 3 을 순회하면서 가능한지 확인 만약 *이 아닌 #이 겹친다면 안댐
* 3. 남은 공간을 조회
* */
public class GameBoardRetry {

        static int H;
        static int W;
        static int[][] gameBoard;

        //주어진 칸을 덮을 수 있는 네 가지 방법
        //블록을 구성하는 세 칸의 상대적 위치(dy, dx)의 목
        static final int[][][] coverType ={
                {{0,0}, {1,0}, {0,1}},
                {{0,0}, {0,1}, {1,1}},
                {{0,0}, {1,0}, {1,1}},
                {{0,0}, {1,0}, {1,-1}}
        };
        //board의 (y, x)를 type번 방법으로 덮거나, 덮었던 블록을 없앤다.
        //delta = 1이면 덮고, -1이면 덮었던 블록을 없앤다.
        //만약 블록이 제대로 덮이지 않은 경우(게임판 밖으로 나가거나, 겹치거나, 검은 칸을 덮을 때) false를 반환한다.

        static boolean set(int y, int x, int type, int delta) {
            boolean ok = true;
            for(int i=0; i < 3; i++) {
                int ny = y + coverType[type][i][0];
                int nx = x + coverType[type][i][1];
                if(ny < 0 || ny >= H || nx < 0 || nx >= W)
                    ok = false;
                gameBoard[ny][nx] += delta;
                if(gameBoard[ny][nx] > 1)
                    ok = false;
            }
            return ok;
        }

        static int cover(){
            int y = -1; int x = -1;
            for(int i=0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (gameBoard[i][j] == 0) {
                        y = i;
                        x = j;
                        break;
                    } }
                if (y != -1)
                    break;
            }
            // 기저 사례: 모든 칸을 채웠으면 1을 반환
            if( y == -1) return 1;
            int ret=0;
            for(int type=0; type < 4; type++) {
                // 만약 board[y][x]를 type 형태로 채울수 있으면 재귀 호출
                if(set(y,x,type,1))
                    ret += cover();
                //덮었던 블록을 치움
                set(y,x,type, -1);
            }
            return ret;

        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Scanner sc = new Scanner(System.in);

            int C = sc.nextInt();
            int[] ans = new int[C];
            while(C-- > 0) {
                H = sc.nextInt(); // hight
                W = sc.nextInt(); // width

                gameBoard = new int[H][W];

                for(int i = 0; i < H; i++) {

                    char[] inputChar = (br.readLine()).toCharArray();
                    for(int j = 0; j < W; j++) {
                        if(inputChar[j] == '#')
                            gameBoard[i][j] = 1;
                    }
                }
                ans[C] = cover();

            }
            for(int i = ans.length -1 ; i >= 0; --i)
                System.out.println(ans[i]);

    }
}
