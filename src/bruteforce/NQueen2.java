package bruteforce;

import java.util.Scanner;

public class NQueen2 {
    static int N;
    static boolean[] checkX;
    static boolean[] checkDR;
    static boolean[] checkDL;
    static boolean canAttack(int y, int x) {
        if(checkX[x])
            return false;
        if(checkDR[N+(x-y)])
            return false;
        if(checkDL[y+x])
            return false;
        else
            return true;
    }

    static int solve(int y) {
        if(y == N)
            return 1;

        // x자리에 들어갈수 있는지 검사하고
        // 들어갈수있다면 체크하고 y+1
        int ans = 0;
        for(int i=0; i < N; i++){
            if(canAttack(y, i)) {
                checkX[i] = true;
                checkDR[N+(i-y)] = true;
                checkDL[y+i] = true;
                ans += solve(y+1);
                checkX[i] = false;
                checkDR[N+(i-y)] = false;
                checkDL[y+i] = false;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        checkX = new boolean[N];
        checkDR = new boolean[N*2];
        checkDL = new boolean[N*2];
        System.out.println(solve(0));
    }
}
