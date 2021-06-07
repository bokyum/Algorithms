package bruteforce.done;

import java.util.*;

public class B14889 {
    static int N;
    static int[][] A;

    // 1 2 4 7 6 5 3
    static boolean next_permutation(int[] A) {
        int i = A.length - 1;
        while(i > 0 && A[i-1] >= A[i])
            i--;

        if(i <= 0)
            return false;

        int j = A.length-1;
        while(A[i-1] >= A[j])
            j--;

        int temp = A[i-1];
        A[i-1] = A[j];
        A[j] = temp;

        int right = A.length-1;
        while(i < right) {
            temp = A[i];
            A[i] = A[right];
            A[right] = temp;
            i++; right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N][N];
        int[] team = new int[N];

        for(int i=0; i < N/2; i++)
            team[i] = 0;
        for(int i = N/2; i < N; i++)
            team[i] = 1;

        for(int i=0; i < N; i++) {
            for(int j=0; j < N; j++)
                A[i][j] = sc.nextInt();
        }

        int ans = 999_999_999;
        do {
            int teamA = 0;
            int teamB = 0;
            for(int i=0; i < N; i++) {
                for(int j=0; j < N; j++) {
                    if(i==j)
                        continue;
                    if(team[i] == team[j] && team[i] == 1)
                        teamB += A[i][j];
                    if(team[i] == team[j] && team[i] == 0)
                        teamA += A[i][j];

                }
            }
            if(ans > Math.abs(teamA - teamB))
                ans = Math.abs(teamA - teamB);
        }while(next_permutation(team));

        System.out.println(ans);
    }
}
