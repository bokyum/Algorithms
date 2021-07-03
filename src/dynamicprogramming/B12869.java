package dynamicprogramming;

import java.util.Scanner;

public class B12869 {
    static int[][][] d;

    static int go(int i, int j, int k) {
        if(i < 0)
            return go(0, j, k);
        if(j < 0)
            return go(i, 0, k);
        if(k < 0)
            return go(i, j, 0);

        if(i == 0 && j == 0 && k == 0) {
            return 0;
        }
        if(d[i][j][k] != -1)
            return d[i][j][k];

        int ans = 1000_000_000;
        if (ans > go(i-1, j-3, k-9)) {
            ans = go(i-1, j-3, k-9);
        }
        if (ans > go(i-1, j-9, k-3)) {
            ans = go(i-1, j-9, k-3);
        }
        if (ans > go(i-3, j-1, k-9)) {
            ans = go(i-3, j-1, k-9);
        }
        if (ans > go(i-3, j-9, k-1)) {
            ans = go(i-3, j-9, k-1);
        }
        if (ans > go(i-9, j-1, k-3)) {
            ans = go(i-9, j-1, k-3);
        }
        if (ans > go(i-9, j-3, k-1)) {
            ans = go(i-9, j-3, k-1);
        }
        ans += 1;
        d[i][j][k] = ans;
        return d[i][j][k];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[3];
        for(int i=0; i < N; i++)
            A[i] = sc.nextInt();

        d = new int[61][61][61];

        for (int i=0; i<=60; i++) {
            for (int j=0; j<=60; j++) {
                for (int k=0; k<=60; k++) {
                    d[i][j][k] = -1;
                }
            }
        }

        System.out.println(go(A[0], A[1], A[2]));
    }
}
