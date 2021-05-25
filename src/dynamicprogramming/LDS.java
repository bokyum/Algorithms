package dynamicprogramming;

import java.util.Scanner;

public class LDS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] A = new int[n];
        int[] D = new int[n];
        for(int i=0; i < n; i++) {
            A[i] = sc.nextInt();
            D[i] = 1;
        }

        for(int i=1; i < n; i++) {
            for(int j=0; j < i; j++) {
                if(A[j] > A[i] && D[j] >= D[i]) {
                    D[i] = D[j] + 1;
                }
            }
        }

        int ans=0;
        for(int i=0; i < n; i++) {
            if(ans < D[i])
                ans = D[i];
        }
        System.out.println(ans);
    }
}
