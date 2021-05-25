package dynamicprogramming;

/*
* 0,0
* 1,0 1,1
* 2,0 2,1 2,2
* 3,0 3,1 3,2 3,3
* y+1, x or y+1, x+1 가능
* */

import java.util.Scanner;

public class B1932 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] A = new int[n][n];
        for(int i=0; i < n; i++) {
            for(int j=0; j<=i; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        int[][] d = new int[n+1][n+1];
        for(int i=n-1; i >=0; i--) {
            for(int j=0; j <= i; j++) {
                d[i][j] = A[i][j] + d[i+1][j];
                d[i][j] = Math.max(d[i][j], A[i][j] + d[i+1][j+1]);
            }
        }

        System.out.println(d[0][0]);

    }
}
