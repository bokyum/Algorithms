package jongmanbook.Chap08;

import java.util.Scanner;

// 2*n 크기의 사각형을 2*1 크기의 사각형으로 빈틈없이 채우는 경우의 수
public class Tiling2 {
    static final int MOD = 1000000007;
    static int[] cache = new int[101];


    static int solve(int width) {
        // 기저사례 width가 1이하 일때
        if(width <= 1) return 1;

        if(cache[width] != -1)
            return cache[width];
        return cache[width] =( solve(width - 2) + solve(width-1) ) % MOD;


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        while(C-- > 0) {
            int n = sc.nextInt();

            for(int i=0; i< cache.length; i++)
                cache[i] = -1;
            System.out.println(solve(n));
        }
    }
}
