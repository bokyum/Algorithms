package implement.retry;

import java.util.Scanner;

public class B14890 {
    static int N, L;
    static int[][] A;

    static boolean solve(int[] temp) {
        boolean[] c = new boolean[N];
        for(int i=1; i < N; i++) {
            if(temp[i-1] == temp[i])
                continue;
            else if((temp[i-1] + 1) == temp[i]) {
                // 왼쪽이 더 작을 때
                int rightValue = temp[i-1];
                if(c[i-1])
                    return false;
                c[i-1] = true;
                for(int l=1; l < L; l++) {
                    if(i-1-l < 0 || c[i-1-l] ||temp[i-1-l] != rightValue) {
                        return false;
                    }
                    else {
                        c[i-1-l] = true;
                    }
                }

            }

            else if((temp[i-1] - 1) == temp[i]) {
                // 오른쪽이 더 작을 때
                int leftValue = temp[i];
                if(c[i])
                    return false;
                c[i] = true;
                for(int l=1; l < L; l++) {
                    if(i+l >= N || c[i + l] ||temp[i+l] != leftValue) {
                        return false;
                    }
                    else {
                        c[i+l] = true;
                    }
                }
            }
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        A = new int[N][N];


        for(int i=0; i < N; i++) {
            for(int j=0; j < N; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        int ans = 0;

        for(int i=0; i < N; i++) {
            int[] temp = new int[N];
            for(int j=0; j < N; j++) {
                temp[j] = A[i][j];
            }
            if(solve(temp))
                ans++;
        }
        for(int i=0; i < N; i++) {
            int[] temp = new int[N];
            for(int j=0; j < N; j++) {
                temp[j] = A[j][i];
            }
            if(solve(temp))
                ans++;
        }


        System.out.println(ans);


    }
}
