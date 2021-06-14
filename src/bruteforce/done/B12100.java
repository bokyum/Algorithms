package bruteforce.done;

import java.util.Scanner;

public class B12100 {
    static int N;



    static void case1(int[][] A) { // 위로 이동
        boolean[][] check = new boolean[N][N];
        // 일단 2개씩 합치고 이동
        for(int j=0; j < N; j++) { // x 축
            for(int i=0; i < N-1; i++) { // y 축
                boolean ok = true;
                for(int k=i+1; k < N; k++) {
                    if(ok && !check[i][j] && !check[k][j] &&A[i][j] == A[k][j]) {
                        A[i][j] += A[k][j];
                        A[k][j] = 0;
                        check[i][j] = true;
                        check[k][j] = true;
                    }
                    if(A[k][j] != 0)
                        ok = false;
                }
            }
        }

        for(int j=0; j < N; j++) {
            for(int i=0; i < N-1; i++) {
                for(int k=i+1; k < N; k++) {
                    if(A[i][j] == 0 && A[k][j] != 0) {
                        A[i][j] = A[k][j];
                        A[k][j] = 0;
                    }
                }
            }
        }

    }

    static void case2(int[][] A) { // 아래로 이동
        boolean[][] check = new boolean[N][N];
        // 일단 2개씩 합치고 이동
        for(int j=0; j < N; j++) { // x 축
            for(int i=N-1; i > 0; i--) { // y 축
                boolean ok = true;
                for(int k=i-1; k >= 0; k--) {
                    if(ok && !check[i][j] && !check[k][j] &&A[i][j] == A[k][j]) {
                        A[i][j] += A[k][j];
                        A[k][j] = 0;
                        check[i][j] = true;
                        check[k][j] = true;
                        break;
                    }
                    if(A[k][j] != 0)
                        ok = false;
                }
            }
        }

        for(int j=0; j < N; j++) {
            for(int i=N-1; i > 0; i--) {
                for(int k=i-1; k >= 0; k--) {
                    if(A[i][j] == 0 && A[k][j] != 0) {
                        A[i][j] = A[k][j];
                        A[k][j] = 0;
                    }
                }
            }
        }
    }
    static void case3(int[][] A) { // 왼쪽으로 이동
        boolean[][] check = new boolean[N][N];
        // 일단 2개씩 합치고 이동
        for(int i=0; i < N; i++) {
            for(int j=0; j < N-1; j++) {
                boolean ok = true;
                for(int k=j+1; k < N; k++) {
                    if(ok && !check[i][j] && !check[i][k] && A[i][j] == A[i][k]) {
                        A[i][j] += A[i][k];
                        A[i][k] = 0;
                        check[i][j] = true;
                        check[i][k] = true;
                        break;
                    }
                    if(A[i][k] != 0)
                        ok = false;
                }
            }
        }

        for(int i=0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    if(A[i][j] == 0 && A[i][k] != 0){
                        A[i][j] = A[i][k];
                        A[i][k] = 0;
                    }
                }
            }
        }
    }

    static void case4(int[][] A) { // 오른쪽으로 이동
        boolean[][] check = new boolean[N][N];
        // 일단 2개씩 합치고 이동
        for(int i=0; i < N; i++) {
            for(int j=N-1; j > 0; j--) {
                boolean ok = true;
                for(int k=j-1; k >=0; k--) {
                    if(ok && !check[i][j] && !check[i][k] && A[i][j] == A[i][k]) {
                        A[i][j] += A[i][k];
                        A[i][k] = 0;
                        check[i][j] = true;
                        check[i][k] = true;
                        break;
                    }
                    if(A[i][k] != 0) {
                        ok = false;
                    }
                }
            }
        }

        for(int i=0; i < N; i++) {
            for (int j=N-1; j > 0; j--) {
                for (int k=j-1; k >=0; k--) {
                    if(A[i][j] == 0 && A[i][k] != 0){
                        A[i][j] = A[i][k];
                        A[i][k] = 0;
                    }
                }
            }
        }
    }

    static void copyArr(int[][] A, int[][] ret) {

        for(int i=0; i < N; i++) {
            for(int j=0; j < N; j++)
                ret[i][j] = A[i][j];
        }
    }

    static int solve(int[][] A, int cnt) {

        int ans = 0;
        for(int i=0; i < N; i++) {
            for(int j=0; j < N; j++) {
                if(A[i][j] > ans)
                    ans = A[i][j];
            }
        }
        if(cnt == 5)
            return ans;


        int[][] temp;
        for(int i=1; i <= 4; i++ ) {
            temp = new int[N][N];
            copyArr(A, temp);
            if(i==1)
                case1(temp);
            else if(i==2)
                case2(temp);
            else if(i==3)
                case3(temp);
            else if(i==4)
                case4(temp);
            int t = solve(temp, cnt+1);
            if(ans < t)
                ans = t;
        }
        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] A = new int[N][N];
        for(int i=0; i < N; i++) {
            for(int j=0; j < N; j++){
                A[i][j] = sc.nextInt();
            }
        }

        System.out.println(solve(A, 0));


    }
}
