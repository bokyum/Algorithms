package dynamicprogramming.done;

import java.util.Scanner;

// 0 다음 0 or 1
// 1 다음 0 or 1
// 11 다음 0
// d[n] = 현재까지 최대 먹은 포도주
// n에서 안마신다면 ? d[n-1]
// n에서 마신다면 ? A[n] + d
// d[n] = max(d[n-1] (현재 안마시는 경우) ,
//          A[n] + d[n-2] (현재 마시고 전에 안마시는 경우),
//          A[n] + A[n-1] + d[n-3] (현재 마시고 전에도 먹은 경우)
public class B2156 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int D[] = new int[n+1];
        int A[] = new int[n+1];
        for(int i=1; i <= n; i++)
            A[i] = sc.nextInt();
        if(n == 1) {
            System.out.println(A[1]);
            return;
        }
        D[1] = A[1];
        D[2] = A[2] + A[1];
        for(int i=3; i <= n; i++) {
            D[i] = Math.max(D[i-1], A[i] + D[i-2]);
            D[i] = Math.max(D[i], A[i] + A[i-1] + D[i-3]);
        }

        System.out.println(D[n]);
    }
}
