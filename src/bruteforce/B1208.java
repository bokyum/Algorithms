package bruteforce;

import java.util.*;
import java.io.*;

public class B1208 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int s=sc.nextInt();
        int[] A = new int[n];

        for(int i=0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        int m = n/2;
        n = n - m;
        int[] left = new int[1 << n];

        for(int i=0; i < (1<<n); i++) { // 1010110
            for(int k=0; k < n; k++) {
                if((i & (1 << k)) == (1 << k)) {
                    left[i] += A[k];
                }
            }
        }

        int[] right = new int[1 << m];

        for(int i=0; i < (1<<m); i++) {
            for(int k=0; k < m; k++) {
                if((i & (1 << k)) == (1 << k))
                    right[i] += A[A.length - 1 - k];
            }
        }

        Arrays.sort(left);
        Arrays.sort(right);

        int lIdx = 0;
        int rIdx = right.length-1;
        long ans = 0;
        while(lIdx < left.length && rIdx >= 0) {
            int sum = left[lIdx] + right[rIdx];
            long cLeft = 1;
            long cRight = 1;

            if(sum > s) {
                rIdx--;
            } else if(sum == s) {
                rIdx--;
                lIdx++;
                while(lIdx < left.length && left[lIdx] == left[lIdx-1]) {
                    cLeft++;
                    lIdx++;
                }
                while(rIdx >= 0 && right[rIdx] == right[rIdx+1]) {
                    cRight++;
                    rIdx--;
                }

                ans += cLeft * cRight;

            } else if(sum < s) {
                lIdx++;
            }
        }

        if(s == 0)
            System.out.println(ans-1);
        else
            System.out.println(ans);


    }
}
