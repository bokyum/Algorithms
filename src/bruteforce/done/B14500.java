package bruteforce.done;

import java.util.Scanner;

public class B14500 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] A = new int[N][M];
        for(int i=0; i < N; i++) {
            for(int j=0; j < M; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for(int i=0; i < N; i++) {
            for(int j=0; j < M; j++) {
                if(i+1 < N && j+1 < M && ans < A[i][j] + A[i][j+1] + A[i+1][j] + A[i+1][j+1])
                    ans = A[i][j] + A[i][j+1] + A[i+1][j] + A[i+1][j+1];
                if(j+3 < M) {
                    if(ans < A[i][j] + A[i][j+1] + A[i][j+2] + A[i][j+3])
                        ans = A[i][j] + A[i][j+1] + A[i][j+2] + A[i][j+3];
                }
                if(i+3 < N) {
                    if(ans < A[i][j] + A[i+1][j] + A[i+2][j] + A[i+3][j])
                        ans = A[i][j] + A[i+1][j] + A[i+2][j] + A[i+3][j];
                }
                if(i+2 < N && j+1 < M) {
                    if(ans < A[i][j] + A[i+1][j] + A[i+2][j] + A[i+2][j+1])
                        ans = A[i][j] + A[i+1][j] + A[i+2][j] + A[i+2][j+1];
                    if(ans < A[i][j+1] + A[i+1][j+1] + A[i+2][j+1] + A[i+2][j])
                        ans = A[i][j+1] + A[i+1][j+1] + A[i+2][j+1] + A[i+2][j];
                    if(ans < A[i][j] + A[i+1][j] + A[i+2][j] + A[i][j+1])
                        ans = A[i][j] + A[i+1][j] + A[i+2][j] + A[i][j+1];
                    if(ans < A[i][j+1] + A[i+1][j+1] + A[i+2][j+1] + A[i][j])
                        ans = A[i][j+1] + A[i+1][j+1] + A[i+2][j+1] + A[i][j];
                }
                if(i + 1 < N && j+2 < M) {
                    if(ans < A[i][j] + A[i+1][j] + A[i+1][j+1] + A[i+1][j+2])
                        ans = A[i][j] + A[i+1][j] + A[i+1][j+1] + A[i+1][j+2];
                    if(ans < A[i][j+2] + A[i+1][j] + A[i+1][j+1] + A[i+1][j+2])
                        ans = A[i][j+2] + A[i+1][j] + A[i+1][j+1] + A[i+1][j+2];
                    if(ans < A[i][j] + A[i][j+1] + A[i][j+2] + A[i+1][j])
                        ans = A[i][j] + A[i][j+1] + A[i][j+2] + A[i+1][j];
                    if(ans < A[i][j] + A[i][j+1] + A[i][j+2] + A[i+1][j+2])
                        ans = A[i][j] + A[i][j+1] + A[i][j+2] + A[i+1][j+2];
                }

                if(i+2 < N && j + 1 < M) {
                    if(ans < A[i][j] + A[i+1][j] + A[i+1][j+1] + A[i+2][j+1])
                        ans = A[i][j] + A[i+1][j] + A[i+1][j+1] + A[i+2][j+1];
                    if(ans < A[i][j+1] + A[i+1][j] + A[i+1][j+1] + A[i+2][j])
                        ans = A[i][j+1] + A[i+1][j] + A[i+1][j+1] + A[i+2][j];
                }

                if(i+1 < N && j+2 < M) {
                    if(ans < A[i][j] + A[i][j+1] + A[i+1][j+1] + A[i+1][j+2])
                        ans = A[i][j] + A[i][j+1] + A[i+1][j+1] + A[i+1][j+2];
                    if(ans < A[i+1][j] + A[i][j+1] + A[i+1][j+1] + A[i][j+2])
                        ans = A[i+1][j] + A[i][j+1] + A[i+1][j+1] + A[i][j+2];
                }

                if(i+2 < N && j+1 < M) {
                    if(ans < A[i][j] + A[i+1][j] + A[i+2][j] + A[i+1][j+1])
                        ans = A[i][j] + A[i+1][j] + A[i+2][j] + A[i+1][j+1];
                    if(ans < A[i+1][j] + A[i][j+1] + A[i+1][j+1] + A[i+2][j+1])
                        ans = A[i+1][j] + A[i][j+1] + A[i+1][j+1] + A[i+2][j+1];
                }

                if(i+1 < N && j+2 < M) {
                    if(ans < A[i+1][j] + A[i+1][j+1] + A[i+1][j+2] + A[i][j+1])
                        ans = A[i+1][j] + A[i+1][j+1] + A[i+1][j+2] + A[i][j+1];
                    if(ans < A[i][j] + A[i][j+1] + A[i][j+2] + A[i+1][j+1])
                        ans = A[i][j] + A[i][j+1] + A[i][j+2] + A[i+1][j+1];
                }



            }
        }

        System.out.println(ans);

    }
}
