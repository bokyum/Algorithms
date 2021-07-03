package dynamicprogramming.done;

import java.util.*;
/**
 * 1
 *
 * 1 + 1,
 * 2
 *
 * 1 + 1 + 1,
 * 1 + 2,
 * 2 + 1,
 * 3
 *
 *
 * 1 + 1 + 1 + 1,
 *
 * 1 + 1 + 2,
 * 1 + 2 + 1,
 * 2 + 1 + 1,
 * 2+ 2
 *
 * 3 + 1,
 * 1 + 3
 * */

public class B9095 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] d = new int[11];
        d[0] = 1;
        d[1] = 1;
        d[2] = 2;

        for(int i=3; i < 11; i++) {
            d[i] = d[i-1] + d[i-2] + d[i-3];
        }

        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            int n = sc.nextInt();
            sb.append(d[n]);
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
