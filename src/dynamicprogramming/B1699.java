package dynamicprogramming;

import java.util.Scanner;

public class B1699 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] D = new int[N+1];


        for(int i=1; i <= N; i++) {
            D[i] = i;
            for(int j=1; j*j <= i; j++) {
                int minus = j*j;
                if(D[i] > D[i-minus] + 1)
                    D[i] = D[i-minus] + 1;
            }
        }

        System.out.println(D[N]);

    }
}
