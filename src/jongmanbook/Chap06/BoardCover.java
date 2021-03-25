package jongmanbook.Chap06;

/*
력의 첫 줄에는 테스트 케이스의 수 C (C <= 30) 가 주어집니다.
각 테스트 케이스의 첫 줄에는 2개의 정수 H, W (1 <= H,W <= 20) 가 주어집니다.
다음 H 줄에 각 W 글자로 게임판의 모양이 주어집니다. # 은 검은 칸, . 는 흰 칸을 나타냅니다. 입력에 주어지는 게임판에 있는 흰 칸의 수는 50 을 넘지 않습니다.

3
3 7
#.....#
#.....#
##...##
3 7
#.....#
#.....#
##..###
8 10
##########
#........#
#........#
#........#
#........#
#........#
#........#
##########

** **
*   *
*   *
** **
* */

import java.util.*;

public class BoardCover {

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
    static boolean set(int[][] gameBoard, int y, int x, int type, int delta) {
        boolean ok = true;
        for(int i = 0; i < 3; ++i) {
            int ny = y + coverType[type][i][0];
            int nx = x + coverType[type][i][1];
            if(ny < 0 || ny >= gameBoard.length || nx < 0 || nx >= gameBoard[0].length)
                ok = false;
            else if((gameBoard[ny][nx] += delta) > 1)
                ok = false;
        }
        return ok;
    }
    //board의 모든 빈 칸을 덮을 수 있는 방법의 수를 반환한다.
    //board[i][j] = 1 이미 덮인 칸 혹은 검은 칸
    //board[i][j] = 0 아직 덮이지 않은 칸
    static int cover(int[][] gameBoard){
        //아직 채우지 못한 칸 중 가장 윗줄 왼쪽에 있는 칸을 찾는다.
        int y = -1, x = -1;
        for(int i = 0; i < H; ++i) {
            for(int j = 0; j < W; ++j)
                if(gameBoard[i][j] == 0) {
                    y = i;
                    x = j;
                    break;
                }
            if( y != -1) break;
        }
        //기저 사례: 모든 칸을 채웠으면 1을 반환한다.
        if(y == -1) return 1;
        int ret = 0;
        for(int type = 0; type < 4; ++type) {
            //만약 board[y][x]를 type 형태로 덮을 수 있으면 재귀 호출한다.
            if(set(gameBoard, y, x, type, 1))
                ret += cover(gameBoard);
            //덮었던 블록을 치운다.
            set(gameBoard, y, x, type, -1);
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        int[] ans = new int[C];
        while(C-- > 0) {
            H = sc.nextInt(); // hight
            W = sc.nextInt(); // width
            sc.nextLine(); // buffer clear
            gameBoard = new int[H][W];
            for(int i = 0; i < H; i++) {
                String inputLine = sc.nextLine();
                char[] inputChar = inputLine.toCharArray();
                for(int j = 0; j < W; j++) {
                    if(inputChar[j] == '#')
                        gameBoard[i][j] = 1;
                }
            }
            ans[C] = cover(gameBoard);

        }
        for(int i = ans.length -1 ; i >= 0; --i)
            System.out.println(ans[i]);

    }
}
