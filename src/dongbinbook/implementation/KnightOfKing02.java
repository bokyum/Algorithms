package dongbinbook.implementation;

import java.util.Scanner;

public class KnightOfKing02 {
    public static int[][] step = {
            {-2, -1}, {-2, 1},
            {2, -1}, {2, 1},
            {1, -2}, {-1, -2},
            {1, 2}, {-1, 2}
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int y = input.charAt(0) - 'a';
        int x = input.charAt(1) - '1';

        int count = 0;
        for(int[] s : step) {
            if(y + s[0] >= 0 && y + s[0] < 8 && x + s[1] >= 0 && x + s[1] < 8)
                count++;
        }
        System.out.println(count);
    }
}
