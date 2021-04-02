package dynamicprogramming;

import java.util.Scanner;

public class TileConstruction {
    static int N;
    static int[] arr;

    static int solve() {
        arr[0] = 1;
        arr[1] = 3;
        for(int i=2; i<N; i++) {
            arr[i] = (arr[i-1] + (2 * arr[i-2])) % 796_796;
        }
        return arr[N-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for(int i=0; i < N; i++)
            arr[i] = -1;

        System.out.println(solve());
    }
}
