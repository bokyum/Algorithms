package bruteforce.done;

import java.util.ArrayList;
import java.util.Scanner;

public class B1182 {
    static int N, S;
    static int[] A;

    static int solve(int index, int ans, int cnt) {
        if(index == N && ans == S && cnt > 0)
            return 1;
        else if(index == N && ans == S)
            return 0;
        if(index == N && ans != S)
            return 0;



        int answer = 0;
        answer += solve(index+1, ans+A[index], cnt+1);

        answer += solve( index+1, ans, cnt);

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        A = new int[N];
        for(int i=0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int answer = solve(0, 0, 0);
        System.out.println(answer);
    }
}
