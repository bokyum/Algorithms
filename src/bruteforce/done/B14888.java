package bruteforce.done;

import java.util.Scanner;

public class B14888 {
    static int N, opNum;
    static int maxNum = -1_000_000_000;
    static int minNum = 1_000_000_000;
    static int[] A;
    static int[] operator = new int[4]; // + - * /

    static void solve(int index, int sum, int cnt) {
        if(index == N-1 && cnt == N-1) {
            if(maxNum < sum)
                maxNum = sum;
            if(minNum > sum)
                minNum = sum;
            return;
        }
        else if(index == N-1)
            return;
        else if(cnt == N-1)
            return;

        if(operator[0] > 0) {
            operator[0]--;
            solve(index+1, sum + A[index+1], cnt+1);
            operator[0]++;
        }
        if(operator[1] > 0) {
            operator[1]--;
            solve(index+1, sum - A[index+1], cnt+1);
            operator[1]++;
        }
        if(operator[2] > 0) {
            operator[2]--;
            solve(index+1, sum * A[index+1], cnt+1);
            operator[2]++;
        }
        if(operator[3] > 0) {
            operator[3]--;
            solve(index+1, sum / A[index+1], cnt+1);
            operator[3]++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];
        for(int i=0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        opNum = 0;
        for(int i=0; i < 4; i++) {
            operator[i] = sc.nextInt();
            opNum += operator[i];
        }

        solve(0, A[0], 0);
        System.out.println(maxNum);
        System.out.println(minNum);
    }
}
