package bruteforce;

import java.util.Scanner;

public class NQueen {
    static int N;
    static boolean canAttack(boolean[][] check, int y, int x) {

        for(int i=0; i < y; i++) {
            if(check[i][x])
                return true;
        }

        int ty = y-1;
        int tx  = x-1;
        while(ty >= 0 && tx >=0) {
            if(check[ty][tx])
                return true;
            ty--;  tx--;
        }

        ty = y-1;
        tx = x+1;
        while(ty >= 0 && tx < N) {
            if(check[ty][tx])
                return true;
            ty--; tx++;
        }


        return false;


    }

    static int solve(boolean[][] check, int y){

        if(y == N) {
            return 1;
        }

        int ans = 0;
        for(int i=0; i < N; i++) {
            check[y][i] = true;
            if(!canAttack(check, y, i)) { // 값을 넣기 전에 공격이 가능하다면 넣지 않음
                ans += solve(check, y+1);
            }
            check[y][i] = false;
        }

        return ans;

    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        boolean[][] check = new boolean[N][N];


        int answer = solve(check,0);

        System.out.println(answer);
    }
}
