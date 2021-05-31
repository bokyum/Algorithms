package bruteforce.done;

import java.util.*;

public class B14225 {
    static int N;
    static int A[];
    static boolean[] check = new boolean[10_000_000];

    static void solve(int index, int sum) {
        if(index == N) {
            check[sum] = true;
            return;
        }

        solve(index+1, sum);
        solve(index+1, sum+A[index]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];
        for(int i=0; i < N; i++)
            A[i] = sc.nextInt();

        Arrays.sort(A);
        check[0] = true;

        solve(0,0);
        for(int i=1; i < check.length; i++) {
            if(!check[i]) {
                System.out.println(i);
                return;
            }
        }
    }
}
