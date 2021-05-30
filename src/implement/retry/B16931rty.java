package implement.retry;

import java.util.Scanner;

public class B16931rty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] A = new int[N + 2][M + 2]; // N+1까지

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        int ans = 2 * N * M;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (A[i][j] > A[i][j + 1])
                    ans += (A[i][j] - A[i][j + 1]);
                if (A[i][j] > A[i + 1][j])
                    ans += (A[i][j] - A[i + 1][j]);
                if (A[i][j - 1] < A[i][j])
                    ans += (A[i][j] - A[i][j - 1]);
                if (A[i - 1][j] < A[i][j])
                    ans += (A[i][j] - A[i - 1][j]);
            }

        }
        System.out.println(ans);
    }
}
