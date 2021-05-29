package dynamicprogramming.done;

import java.util.Scanner;

public class B2225 {

    public static void main(String[] args) {
        final int mod = 1_000_000_000;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long[][] d = new long[N+1][K+1];

        d[0][0] = 1;


        for(int i=0; i <= N; i++) {
            for(int j=1; j <= K; j++) {
                for(int l=0; l <= i; l++) {
                    d[i][j] +=  d[i-l][j-1];
                    d[i][j] %= mod;

                }

            }
        }


        System.out.println(d[N][K] % mod);
    }
}
