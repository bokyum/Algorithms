package dynamicprogramming;

import java.util.Scanner;

public class AntWarrior {
    static int[] arr;
    static int[] cache;
    static int N;

    static int solve(int index) {
        if(index >= N)
            return 0;
        if(cache[index] != -1)
            return cache[index];
        int ret = 0;
        for(int i = 1; i + index < N; i++) {
            cache[index] = Math.max(solve(index+i), solve(index+1+i) + arr[index] );
            ret += cache[index];
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        cache = new int[N];

        for(int i=0; i< N; i++) {
            cache[i] = -1;
            arr[i] = sc.nextInt();
        }

        System.out.println(solve(0));

    }
}
