package bruteforce;

import java.util.Scanner;

public class Sudoku {

    static int N = 9;
    static int[][] A = new int[N][N];
    static boolean[][] checkX = new boolean[N][10];
    static boolean[][] checkY = new boolean[N][10];
    static boolean[][] checkCell = new boolean[N][10];

    static boolean canPut(int y, int x, int i) {
        if(checkX[y][i])
            return false;
        if(checkY[x][i])
            return false;
        if(checkCell[(y/3) * 3 + (x/3)][i])
            return false;

        return true;
    }

    static boolean solve(int z) { // y = (z/N) x = (z - (y * N)
        if(z == 81){
            return true;
        }
        int y = (z/N);
        int x = (z - (y*N));

        if(A[y][x] != 0) {
            return solve(z + 1);

        }
        else {
            for(int i=1; i <= 9; i++) {
                if(canPut(y, x, i)) {
                    A[y][x] = i;
                    checkY[x][i] = checkX[y][i] = checkCell[(y/3)*3 + (x/3)][i] = true;
                    if(solve(z+1)) {
                        return true;
                    }
                    A[y][x] = 0;
                    checkY[x][i] = checkX[y][i] = checkCell[(y/3)*3 + (x/3)][i] = false;
                }
            }
        }

        return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i < N; i++) {
            for(int j=0; j < N; j++) {
                A[i][j] = sc.nextInt();
                if(A[i][j] != 0) {
                    checkY[j][A[i][j]] = true;
                    checkX[i][A[i][j]] = true;
                    checkCell[(i/3)*3 + (j/3)][A[i][j]] = true;
                }
            }
        }

        solve(0);

        for(int i=0; i < N; i++) {
            for(int j=0; j < N; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }

    }
}
