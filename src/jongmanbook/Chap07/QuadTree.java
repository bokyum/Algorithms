package jongmanbook.Chap07;


import java.util.Scanner;

/*
Input
4
w
x[bwwb]
x[bw[xwbbw]b]
x[x[wwwb]x[wx[wbbbw]wx[x[x[wwbb]bww]wwb]b]

Output
w
xwbbw
xxbwwbbbw
xxwbxwwxbbwwbwbxwbwwxwwwxbbwb
 */
public class QuadTree {

    static char[][] decompressd = new char[20][20];
    static int point;
    static void decompress(String it, int y, int x, int size) {
        //한 글자를 검사할 때마다 한 칸씩 앞으로 옮김
        char head = it.charAt(point++);
        //기저 사례: 첫 글자가 b 또는 w인 경우
        if(head == 'b' || head == 'w') {
            for(int dy = 0; dy < size; ++dy) {
                for(int dx = 0; dx < size; ++dx)
                    decompressd[y+dy][x+dx] = head;
            }
        } else {
            //네 부분을 각각 순서대로 압축 해제한다.
            int half = size / 2;
            decompress(it, y, x, half);
            decompress(it, y, x + half, half);
            decompress(it, y + half, x, half);
            decompress(it, y + half , x + half, half);
        }

    }
    static String reverse(String input) {
        char head = input.charAt(point++);
        if(head == 'b' || head == 'w')
            return head + "";
        String upperLeft = reverse(input);
        String upperRight = reverse(input);
        String lowerLeft = reverse(input);
        String lowerRight = reverse(input);

        return "x" + lowerLeft + lowerRight + upperLeft + upperRight;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        sc.nextLine();
        while(C-- > 0) {
            String input = sc.nextLine();
            point = 0;
            System.out.println(reverse(input));
            /*decompress(input,0, 0, input.length());
            for(int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    System.out.print(decompressd[i][j]);
                }
                System.out.println();
            }*/

        }
    }
}
