package bruteforce;

import java.util.Scanner;

public class B14225 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        boolean[] c = new boolean[2_000_000+1];
        for(int i=0; i < N; i++)
            A[i] = sc.nextInt();
        int max = 1 << N;

        for(int i=0; i < max; i++) {
            int sum = 0;
            for(int j=0; j < N; j++) {
                if((i&(1<<j)) != 0)
                    sum += A[j];
            }
            c[sum] = true;

        }

        for(int i=1; ; i++)
            if(!c[i]) {
                System.out.println(i);
                break;
            }
    }
}
