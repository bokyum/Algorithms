package jongmanbook.Chap08;

import java.util.Arrays;

public class BinomialCoefficient {
    static int[][] cache = new int[30][30];

    public static void main(String[] args) {
        for(int i = 0; i < cache.length; i++)
            Arrays.fill(cache[i], -1);

        System.out.println(bino(7, 3));
        System.out.println(bino2(7, 3));
    }

    static int bino(int n, int r) {
        // 기저 사례: n == r (모든 원소를 다 고르는 경우) 혹은 r == 0 (고를 원소가 없는 경우)
        if(r == 0 || n == r)
            return 1;
        return bino(n-1, r) + bino(n-1, r-1);
    }

    static int bino2(int n, int r) {
        // 기저 사례
        if(r == 0 || n == r)
            return 1;
        if(cache[n][r] != -1)
            return cache[n][r];

        return cache[n][r] = bino2(n-1, r-1) + bino2(n-1, r);
    }


}
