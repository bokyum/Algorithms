package implement.done;

import java.util.Scanner;

public class B16931 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[][][] A = new boolean[102][102][102];

        for(int i=1; i <= N; i++) {
            for(int j=1; j <= M; j++) {
                int height = sc.nextInt();
                for(int h=1; h <= height; h++)
                    A[i][j][h] = true;
            }
        }
        int ans =0;
        for(int i=1; i <= N; i++) {
            for(int j=1; j <= M; j++) {
                for(int h=1; h <= 100; h++) {
                    if(A[i][j][h]) {
                        if(!A[i+1][j][h])
                            ans++;
                        if(!A[i-1][j][h])
                            ans++;
                        if(!A[i][j-1][h])
                            ans++;
                        if(!A[i][j+1][h])
                            ans++;
                        if(!A[i][j][h+1])
                            ans++;
                        if(!A[i][j][h-1])
                            ans++;
                    }

                }
            }
        }
        System.out.println(ans);
    }
}
