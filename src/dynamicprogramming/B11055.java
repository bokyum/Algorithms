package dynamicprogramming;

import java.util.Scanner;

public class B11055 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] D = new int[n];
        for(int i=0; i < n; i++) {
            A[i] = sc.nextInt();
            D[i] = A[i];
        }

        for(int i=1; i < n; i++) {
            for(int j=0; j<i; j++) {
                if(A[i] > A[j]) {
                    if(D[i] <= D[j] + A[i]) {
                        D[i] = D[j] + A[i];
                    }
                }
            }
        }

        int max = 0;
        for(int i=0; i < n; i++) {
            if(max < D[i])
                max = D[i];
        }

        System.out.println(max);

    }
}
