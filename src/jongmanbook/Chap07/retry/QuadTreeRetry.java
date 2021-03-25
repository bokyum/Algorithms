package jongmanbook.Chap07.retry;

import java.util.Scanner;

public class QuadTreeRetry {
    static String fixel;
    static int point;


    static String solve() {
        char c = fixel.charAt(point++);
        if(c == 'b' || c == 'w')
            return c + "";
        String first = solve();
        String second = solve();
        String third = solve();
        String quad = solve();
        return 'x' + third + quad + first + second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        sc.nextLine(); // clear buffer;
        while(C-- > 0) {
            fixel = sc.nextLine();
            point = 0;
            System.out.println(solve());
        }
    }
}
