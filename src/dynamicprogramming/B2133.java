package dynamicprogramming;

import java.util.*;
import java.io.*;

public class B2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];

        if(n % 2 != 0) {
            System.out.println(0);
            return;
        }
        d[0] = 1;

        for(int i=2; i <= n; i+=2) {
            d[i] += d[i-2] * 3;
            for(int j=4; j <= i; j += 2)
                d[i] += d[i-j] * 2;
            //d[i] += 1;
        }

        System.out.println(d[n]);
    }

}
