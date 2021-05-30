package implement;

import java.util.Scanner;

public class B20055 {
    static int N, K;
    static boolean[] robot;
    static int[] A;

    static boolean ok() {
        int ans = 0;
        for(int i=1; i <= 2*N; i++) {
            if(A[i] == 0)
                ans++;
        }
        if(ans >= K)
            return false;
        else
            return true;
    }

    static void caseOne() {
        robot[N] = false;
        A[0] = A[2*N];
        robot[0] = robot[2*N];
        for(int i = 2*N; i > 0; i--) {
            A[i] = A[i-1];
            robot[i] = robot[i-1];
        }
        robot[N] = false;
    }

    static void caseTwo() {
        for(int i = 2*N-1; i >= 0; i--) {
            if(robot[i] && !robot[i+1] && A[i+1] > 0){
                robot[i] = false;
                robot[i+1] = true;
                A[i+1]--;

            }
        }
    }

    static void caseThree() {
        if(A[1] > 0){
            robot[1] = true;
            A[1]--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        A = new int[2*N+1];

        for(int i=1; i <= 2*N; i++)
            A[i] = sc.nextInt();
        robot = new boolean[2*N+1];

        int ans = 1;
        while(true) {
            caseOne();
            caseTwo();
            caseThree();
            if(!ok())
                break;
            else
                ans++;
        }

        System.out.println(ans);
    }
}
