package dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class B1495 {
    static int N, S, M;
    static int[] A;
    static int[][] d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        M = sc.nextInt();
        A = new int[N+1];
        d = new int[N+1][M+1];
        for(int i=1; i <= N; i++) {
            A[i] = sc.nextInt();
            Arrays.fill(d[i], -1);
        }

        Arrays.fill(d[0], -1);
        d[0][S] = S;
        for(int i=1; i <= N; i++) {
            for(int j=0; j <= M; j++) {
                if(d[i-1][j] != -1) {
                    if(j+A[i] <= M) {
                        d[i][j+A[i]] = d[i-1][j] + A[i];
                    }
                    if(j-A[i] >= 0) {
                        d[i][j-A[i]] = d[i-1][j] - A[i];
                    }
                    //System.out.println(d[i-1][j]);
                }
            }

        }
        int max = -1;
        for(int i=0; i <= M; i++) {

            if(max < d[N][i])
                max = d[N][i];
        }

        System.out.println(max);
    }
}
