package bruteforce.retry;

import java.util.Scanner;

public class B16197 {
    static int N, M;
    static int fY, fX, sY, sX;
    static char[][] A;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static boolean outCoin(int fY, int fX) {
        if(fY < 0 || fY >= N || fX < 0 || fX >= M)
            return true;
        else
            return false;
    }


    static int solve(int fY, int fX, int sY, int sX, int cnt) {

        if(cnt > 10)
            return -1;
        if(outCoin(fY, fX) && outCoin(sY,sX)) {
            return -1;
        }

        if(outCoin(fY,fX) || outCoin(sY, sX))
            return cnt;



        int ans = 100;
        for(int i=0; i < 4; i++) {
            int ny1 = fY+dy[i];
            int nx1 = fX+dx[i];
            int ny2 = sY+dy[i];
            int nx2 = sX+dx[i];

            if(!outCoin(ny1, nx1) && A[ny1][nx1] == '#') {
                ny1 = fY;
                nx1 = fX;
            }
            if(!outCoin(ny2, nx2) && A[ny2][nx2] == '#'){
                ny2 = sY;
                nx2 = sX;
            }

            int temp = solve(ny1,nx1, ny2, nx2, cnt + 1);

            if(temp == -1)
                continue;
            if (ans == -1 || ans > temp)
                ans = temp;
        }

        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();
        sc.nextLine();
        A = new char[N][M];
        int count = 0;
        for(int i=0; i < N; i++) {
            String s = sc.nextLine();
            for(int j=0; j < M; j++) {
                A[i][j] = s.charAt(j);
                if(A[i][j] == 'o' && count == 0){
                    fY = i; fX = j;
                    count++;
                }
                else if(A[i][j] == 'o' && count == 1) {
                    sY = i; sX = j;
                }
            }
        }

        int answer = solve(fY, fX, sY, sX, 0);
        if (answer > 10)
            System.out.println(-1);
        else {
            System.out.println(answer);
        }
    }
}
