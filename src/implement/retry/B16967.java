package implement.retry;

import java.util.Scanner;

public class B16967 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();

        int[][] A = new int[H+X][W+Y];

        for(int i=0; i < H+X; i++) {
            for(int j=0; j < W+Y; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i < H; i++) {
            for(int j=0; j < W; j++) {
                A[i+X][j+Y] -= A[i][j];
            }
        }

        for(int i=0; i < H; i++) {
            for(int j=0; j < W; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}
