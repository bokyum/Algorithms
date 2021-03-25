package jongmanbook.Chap06;

import java.util.Scanner;

public class ClockSync {
    static final int INF = 99999, SWITCHES = 10, CLOCKS = 16;
    // linked[i][j] = 'x': i번째 스위치가 j번째 시계와 연결되어 있다.
    // linked[i][j] = '.': i번째 스위치가 j번째 시계와 연결되어 있지 않다.
    static final String[] linked = {
            "xxx.............",
            "...x...x.x.x....",
            "....x.....x...xx",
            "x...xxxx........",
            "......xxx.x.x...",
            "x.x...........xx",
            "...x..........xx",
            "....xx.x......xx",
            ".xxxxx..........",
            "...xxx...x...x..",
    };
    // 모든 시계가 12시를 가르키고 있는지 확인한다.
    static boolean areAligned(int[] clocks){
        for(int i = 0; i < clocks.length; i++) {
            if(clocks[i] != 12)
                return false;
        }
        return true;
    }

    static void push(int[] clocks, int swtch) {
        for(int clock = 0; clock < CLOCKS; ++clock) {
            if(linked[swtch].charAt(clock) == 'x') {
                clocks[clock] += 3;
                if(clocks[clock] == 15) clocks[clock] = 3;
            }
        }
    }

    // clocks: 현재 시계들의 상태
    // switch: 이번에 누를 스위치의 번호
    // 가 주어질 때, 남은 스위치들을 눌러서 clocks를 12시로 맞출 수 있는 최소 횟수를 반환한다.
    // 만약 불가능하다면 INF 이상의 큰 수를 반환한다.
    static int solve(int[] clocks, int swtch) {
        if(swtch == SWITCHES)
            return areAligned(clocks) ? 0 : INF;
        // 이 스위치를 0번 누르는 경우부터 세 번 누르는 경우까지를 모두 시도한다.
        int ret = INF;
        for(int cnt = 0; cnt < 4; ++cnt) {
            ret = Math.min(ret, cnt + solve(clocks, swtch + 1));
            push(clocks, swtch);
        }
        // push(clocks, swtch)가 네 번 호출되었으니 clocks는 원래와 같은 상태가 된다.

        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        int[] clocks = new int[16];
        int[] ans = new int[C];
        while(C-- > 0) {
            for(int i=0; i < CLOCKS; i++)
                clocks[i] = sc.nextInt();
            int temp = solve(clocks, 0);
            ans[C] = temp >= INF ? -1 : temp;
        }

        for(int i = ans.length - 1; i >= 0; --i)
            System.out.println(ans[i]);
    }
}
/*
2
        12 6 6 6 6 6 12 12 12 12 12 12 12 12 12 12
        12 9 3 12 6 6 9 3 12 9 12 9 12 12 6 6

10
3 6 6 12 3 3 9 9 6 6 6 6 6 12 6 6
12 3 6 12 6 6 6 12 12 12 12 3 12 9 6 6
3 12 12 12 3 3 6 9 9 9 9 12 9 9 12 12
9 3 3 9 6 12 3 6 3 3 9 6 3 9 3 3
12 9 6 6 12 6 6 6 6 12 12 6 6 6 9 9
12 9 3 3 6 9 3 6 3 9 12 3 3 6 6 6
3 12 6 12 6 12 12 6 3 9 9 6 3 3 3 3
12 12 12 9 6 12 12 3 9 3 3 12 9 3 12 12
6 12 12 12 6 9 3 3 12 3 9 9 12 6 12 12
3 12 12 9 9 6 6 12 6 9 9 9 6 12 3 3

OUT:
0 2 0 3 2 0 0 2 2 0 ; 11
3 3 0 2 0 3 0 3 0 1 ; 15
2 0 0 1 1 0 1 3 2 1 ; 11
1 2 2 0 3 0 0 1 2 1 ; 12
3 2 2 0 2 1 0 2 2 2 ; 16
2 3 1 0 3 2 3 0 3 2 ; 19
0 2 2 1 3 2 3 0 0 3 ; 16
1 0 2 3 1 0 3 3 3 3 ; 19
3 1 1 3 0 0 0 3 1 2 ; 14
3 1 3 0 2 0 3 1 1 0 ; 14
        */

