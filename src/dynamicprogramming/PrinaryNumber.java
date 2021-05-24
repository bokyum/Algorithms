package dynamicprogramming;

import java.util.*;
import java.io.*;

// 0으로 시작하지 않음
// 1이 두번 연속으로 시작하지 않음
// 100
// 101
public class PrinaryNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] D = new long[N+1];

        D[1] = 1;

        for(int i=2; i <= N; i++)
            D[i] = D[i-1] + D[i-2];

        System.out.println(D[N]);
    }
}