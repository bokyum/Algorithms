package dynamicprogramming;

import java.util.Scanner;

public class NWon {

    static int N, M;
    static int[] won;
    static int[] cache;

    static int solve() {
        cache[0] = 0;
        for(int i=0; i < N; i++) {
            for(int j=won[i]; j<M+1; j++) {
                if(cache[j-won[i]] != 10_001)
                    cache[j] = Math.min(cache[j], cache[j-won[i]] + 1);
            }
        }

        if(cache[M] == 10_001)
            return -1;
        return cache[M];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();

        won = new int[N];
        cache = new int[M+1];

        for(int i=0; i < N; i++) {
            won[i] = sc.nextInt();
        }
        for(int i=0; i < M+1; i++)
            cache[i] = 10_001;

        System.out.println(solve());
    }
}
