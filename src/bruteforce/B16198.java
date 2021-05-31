package bruteforce;

import java.util.ArrayList;
import java.util.Scanner;

public class B16198 {

    static int solve(ArrayList<Integer> A, int ans) {
        int N = A.size();
        if(N == 2)
            return ans;

        int max = -1;
        for(int i=1; i < N-1; i++) {
            ArrayList<Integer> B = new ArrayList<>(A);
            int temp = B.get(i-1) * B.get(i+1);
            B.remove(i);
            int tempAns = solve(B, ans + temp);
            if(max == -1 || max < tempAns)
                max = tempAns;

        }

        return max;


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<Integer>();
        for(int i=0; i < N; i++) {
            A.add(sc.nextInt());
        }

        System.out.println(solve(A, 0));
    }
}
