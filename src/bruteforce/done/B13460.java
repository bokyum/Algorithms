package bruteforce.done;

import java.util.Scanner;

public class B13460 {
    static int N, M;
    static char[][] A;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};
    static int ry, rx, by, bx;

    static boolean moveTo(int dir, int which) {
        if(which == 0) {
            while(true) {
                int ny = ry + dy[dir];
                int nx = rx + dx[dir];
                if(A[ny][nx] == '#')
                    return true;
                else if (A[ny][nx] == 'O') {
                    ry = ny; rx = nx;
                    return false;
                }
                else if(ny == by && nx == bx) {
                    return true;
                }
                 else if (A[ny][nx] == '.') {
                    ry = ny;
                    rx = nx;
                }
                else {
                    return true;
                }
            }
        }
        else if(which == 1) {
            while (true) {
                int ny = by + dy[dir];
                int nx = bx + dx[dir];
                if(A[ny][nx] == '#')
                    return true;
                else if (A[ny][nx] == 'O') {
                    by = ny; bx = nx;
                    return false;
                }
                else if(ny == ry && nx == rx) {
                    return true;
                }
                 else if (A[ny][nx] == '.') {
                    by = ny;
                    bx = nx;
                } else {
                    return true;
                }
            }
        }
        return true;
    }

    static int solve(int cnt, int dir) {
        if(cnt > 10)
            return 11;

        boolean[] c = new boolean[3];
        c[0] = !moveTo(dir, 0);
        c[1] = !moveTo(dir, 1);
        c[2] = !moveTo(dir, 0);

        if(c[1] && (c[0] || c[2]))
            return 11;
        else if(!c[1] && (c[0] || c[2]))
            return cnt;
        else if(c[1])
            return 11;


        int ans = 11;
        for(int i=1; i < 4; i++) {
            int[] D = new int[4];
            D[0] = ry; D[1] = rx; D[2] = by; D[3] = bx;
            int temp = solve(cnt+1, (dir + i) % 4);
            ry = D[0]; rx = D[1]; by = D[2]; bx = D[3];
            if (temp < ans)
                ans = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = new char[N][M];
        int[] R = new int[2];
        int[] B = new int[2];
        sc.nextLine();
        for(int i=0; i < N; i++) {
            String s = sc.nextLine();
            for(int j=0; j < M; j++) {
                A[i][j] = s.charAt(j);
                if(A[i][j] == 'R') {
                    R[0] = i; R[1] = j;
                    A[i][j] = '.';
                }
                if(A[i][j] == 'B') {
                    B[0] = i; B[1] = j;
                    A[i][j] = '.';
                }
            }
        }

        int ans = 11;
        for(int i=0; i < 4; i++) {
            ry = R[0]; rx = R[1];
            by = B[0]; bx = B[1];
            int temp = solve(1, i);

            if(temp < ans)
                ans = temp;
        }
        if(ans > 10)
            System.out.println(-1);
        else
            System.out.println(ans);
    }
}
