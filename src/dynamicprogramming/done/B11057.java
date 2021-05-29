package dynamicprogramming.done;

import java.util.Scanner;

public class B11057 {
    static final int mod = 10_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] d = new int[N][10];

        for(int i=0; i<10; i++)
            d[0][i] = 1;

        for(int i=1; i<N; i++) {
            for(int j=0; j <10; j++) {
                for(int k=0; k <= j; k++){
                    d[i][j] += d[i-1][k];
                    d[i][j] %= mod;
                }
            }
        }

        long ans=0;
        for(int i=0; i<10; i++) {
            ans += d[N-1][i];
            ans %= mod;
        }
        System.out.println(ans);


    }
}
