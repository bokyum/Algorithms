package dynamicprogramming;

import java.util.Scanner;

public class B11058 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] d = new long[N+1];
        for(int i=1; i <= N; i++) {
            d[i] = d[i-1] + 1;
            for (int j=1; j<=i-3; j++) {
                long cur = d[i-j-2]*(j+1);
                if (cur > d[i]) {
                    d[i] = cur;
                }
            }

           
        }
        System.out.println(d[N]);


    }
}
