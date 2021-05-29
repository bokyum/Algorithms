package dynamicprogramming.done;

import java.util.Scanner;

public class B1309 {
    static final int mod = 9901;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] d = new long[N+1][3];

        for(int i=0; i < 3; i++)
            d[1][i] = 1;

        for(int i=2; i <= N; i++) {
            d[i][0] = d[i-1][1] + d[i-1][2];
            d[i][0] %= mod;
            d[i][1] = d[i-1][0] + d[i-1][1] + d[i-1][2];
            d[i][1] %= mod;
            d[i][2] = d[i-1][0] + d[i-1][1];
            d[i][2] %= mod;
        }

        System.out.println((d[N][0] + d[N][1] + d[N][2]) % mod);



    }
}
