package baekjoon.done;

import java.util.Scanner;
/*
2 * 2
0 1 2 3
1 2 3 4
2 3 4 5
3 4 5 6

0,0 0,1 0,2 0,3
1,0 1,1 1,2 1,3
2,0 2,1 2,2 2,3
3,0 3,1 3,2 3,3
* */
public class B1074 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        int ans = 0;
        int y = (int) Math.pow(2, n) / 2;
        int x = y;

        while (n-- > 0) {
            int temp = (int) Math.pow(2, n) / 2;
            int skip = (int) Math.pow(4, n);

            if (r < y && c < x) {
                // 1
                x -= temp;
                y -= temp;
            } else if (r < y && x <= c) {
                // 2
                x += temp;
                y -= temp;
                ans += skip;
            } else if (y <= r && c < x) {
                // 3
                x -= temp;
                y += temp;
                ans += skip * 2;
            } else {
                // 4
                x += temp;
                y += temp;
                ans += skip * 3;
            }
        }
        System.out.println(ans);

    }
}
