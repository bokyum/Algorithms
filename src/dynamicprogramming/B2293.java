package dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class B2293 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] A = new int[n];

        for(int i=0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int[] d = new int[k+1];
        Arrays.fill(d, -1);
        d[0] = 0;
        for(int i=0; i < n; i++) {
            for(int j=0; j <= k; j++) {
                if (j + A[i] <= k && d[j] != -1) {
                    if(d[j+A[i]] == -1 || d[j+A[i]] > d[j] + 1) {
                        d[j+A[i]] = d[j] + 1;
                    }
                }

            }
        }

        System.out.println(d[k]);
    }
}
