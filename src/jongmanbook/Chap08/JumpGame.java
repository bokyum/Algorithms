package jongmanbook.Chap08;

import java.util.Scanner;

public class JumpGame {
    static int[][] arr = new int[100][100];
    static int[][] cache = new int[100][100];

    static int jump2(int y, int x, int N) {
        //기저 사례: 게임판 밖을 벗어난 경우
        if(y >= N || x >= N) return 0;
        if(y == N-1 && x == N-1) return 1;
        //메모이제이션
        if(cache[y][x] != -1) return cache[y][x];
        int jumpSize = arr[y][x];

        return cache[y][x] = (jump2(y+jumpSize, x, N) | jump2(y, x+jumpSize, N));

    }

    static boolean jump(int y, int x, int N) {
        //기저 사례: 게임판 밖을 벗어난 경우
        if(y >= N || x >= N) return false;
        //기저 사례: 마지막 칸에 도착한 경우
        if(y == N-1 && x == N-1) return true;
        int jumpSize = arr[y][x];
        return jump(y+jumpSize, x, N) || jump(y, x+jumpSize, N);
    }

    static void inputArr(int N) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                arr[i][j] = sc.nextInt();
    }

    static void memSet() {
        for(int i = 0; i < cache.length; i++)
            for(int j = 0; j < cache[i].length; j++)
                cache[i][j] = -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();

        while(C-- > 0) {
            int N = sc.nextInt();
            memSet();
            inputArr(N);
            System.out.println(jump2(0, 0, N));
        }
    }
}


/*
test case:
        2
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
        1 5 2 9 4 7 0
        */
