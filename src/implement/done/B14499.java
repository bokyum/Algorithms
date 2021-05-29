package implement.done;

import java.io.*;
import java.util.*;

public class B14499 {
    static int N, M;
    static int x, y;
    static int[][] arr;
    static int[] dice = {0, 0, 0, 0, 0, 0}; // 1 2 3 4 5 6

    // 1 <-> 6 2 <-> 5 3 <-> 4

    static void printSix() {
        if(arr[x][y] == 0){
            arr[x][y] = dice[0];
            System.out.println(dice[5]);
            return;
        }
        else {
            dice[0] = arr[x][y];
            arr[x][y] = 0;
            System.out.println(dice[5]);
        }
    }

    static void firstCase() {
        int ny = y + 1;
        if(ny < 0 || ny >= M)
            return; // map 넘어감
        // 동쪽으로 이동
        // 3번이 아래로 오게됨;
        y = ny;
        int[] temp = new int[6];
        temp[1] = dice[1]; temp[4] = dice[4];
        temp[0] = dice[2]; temp[5] = dice[3];
        temp[3] = dice[0]; temp[2] = dice[5];
        dice = temp;
        printSix();
    }

    static void secondCase() { // 서쪽으로 이동
        int ny = y - 1;
        if (ny < 0 || ny >= M)
            return;
        y = ny; // y좌표 이동
        int[] temp = new int[6];
        temp[1] = dice[1]; temp[4] = dice[4];
        temp[0] = dice[3]; temp[3] = dice[5];
        temp[5] = dice[2]; temp[2] = dice[0];
        dice = temp;
        printSix();
    }
    static void thirdCase() {
        int nx = x - 1;
        if(nx < 0 || nx >= N)
            return;
        x = nx;
        int[] temp = new int[6];
        temp[3] = dice[3]; temp[2] = dice[2];
        temp[0] = dice[1]; temp[5] = dice[4];
        temp[1] = dice[5]; temp[4] = dice[0];
        dice = temp;
        printSix();
    }
    static void fourthCase() {
        int nx = x + 1;
        if(nx < 0 || nx >= N)
            return;
        x = nx;
        int[] temp = new int[6];
        temp[3] = dice[3]; temp[2] = dice[2];
        temp[0] = dice[4]; temp[5] = dice[1];
        temp[1] = dice[0]; temp[4] = dice[5];
        dice = temp;
        printSix();
    }

    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0; i < K; i++) {
            int inp = Integer.parseInt(st.nextToken());
            if(inp == 1) {
                firstCase();
            }
            else if(inp == 2)
            {
                secondCase();
            }
            else if(inp == 3){
                thirdCase();
            }
            else if(inp == 4) {
                fourthCase();
            }

        }
    }
}
