package dongbinbook.greedy;

import java.util.Scanner;

public class ToOne04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        N = sc.nextInt(); M = sc.nextInt();

        int count = 0;
        while(N >= 1) {
            if(N % M == 0) {
                N /= M;
                count++;
            }
            else {
                N -= 1;
                count++;
            }
        }
        System.out.println(count);
    }
}
