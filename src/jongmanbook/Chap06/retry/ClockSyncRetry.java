package jongmanbook.Chap06.retry;

import java.util.Scanner;

// 각 clock을 움직이면 시간이 바뀜
// 각 manipulate를 통해 움직이는 시계는 3번 까지만 효력이 있음 4번 움직이면 같은 시간
// manipulate에 1번을 먼저하나 나중에 하나 결과는 같음 !!
// 각 바뀐 정보를 넘겨야

public class ClockSyncRetry {
    static final int CLOCK_NUM = 16;
    static final int MANIPU_NUM = 10; //manipulate 배열 수
    static final int INF = 9999999;
    static int[] clock; // clock 시간 정보 저장
    static final int[][] manipulate = { // 각 연관된 동작
            {0, 1, 2}, {3, 7, 9, 11}, {4, 10, 14, 15}, {0, 4, 5, 6, 7},
            {6, 7, 8, 10, 12}, {0, 2, 14, 15}, {3, 14, 15}, {4, 5, 7, 14, 15},
            {1, 2, 3, 4, 5}, {3, 4, 5, 9, 13}
    };

    static boolean isAligned() {
        for(int i=0; i < CLOCK_NUM; i++){
            if(clock[i] != 12)
                return false;
        }
        return true;
    }

    static int solve(int index, int num) { // 움직인 개수 index => manipulate 몇번째꺼 실행할지 num ==> 지금까지 움직인 개
        if(index == MANIPU_NUM)
            return isAligned() ? 0 : INF;
        int ret = INF;
        for(int i=0; i < 4; i++) { // 0번 1번 2번 3번 가능
            ret = Math.min(ret, i + solve(index+1, num));
            for (int m : manipulate[index]) { // manipulate에 속해있는 clock 움지
                clock[m] += 3;
                if (clock[m] == 15)
                    clock[m] = 3;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();
        while(C-- > 0) {
            // 각 테스트 케이스는 한 줄에 16개의 정수
            clock = new int[CLOCK_NUM];
            for(int i=0; i < CLOCK_NUM; i++) {
                clock[i] = sc.nextInt();
            }

            System.out.println(solve(0, 0));

        }
    }
}
