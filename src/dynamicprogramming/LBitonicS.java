package dynamicprogramming;

import java.util.Scanner;

public class LBitonicS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] DI = new int[n];
        int[] DD = new int[n];
        for(int i=0; i < n; i++) {
            A[i] = sc.nextInt();
            DI[i] = 1; DD[i] = 1;
        }

        for(int i=1; i < n; i++) {
            for(int j=0; j < i; j++) {
                if(A[i] > A[j] && DI[i] <= DI[j])
                    DI[i] = DI[j] + 1;
            }
        }
        for(int i=n-2; i >=0; i--) {
            for(int j=i+1; j < n; j++) {
                if(A[i] > A[j] && DD[i] <= DD[j])
                    DD[i] = DD[j] + 1;
            }
        }

        int max = Math.max(DI[n-1], DD[0]);

        for(int i=1; i < n-1; i++) {
            if(max < DI[i] + DD[i] -1)
                max = DI[i] + DD[i] - 1;
        }

        System.out.println(max);

    }
}
