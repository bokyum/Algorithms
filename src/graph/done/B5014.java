package graph.done;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B5014 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int F = sc.nextInt(); // 총 높이
        int S = sc.nextInt(); // 현재 위치
        int G = sc.nextInt(); // Start link 위치
        int U = sc.nextInt(); // 위로
        int D = sc.nextInt(); // 아래로

        int[] A = new int[F+1];

        for(int i=0; i <= F; i++)
            A[i] = -1;

        Queue<Integer> q = new LinkedList<>();
        A[S] = 0;
        q.add(S);

        while(!q.isEmpty()) {
            int n = q.poll();

            if(n == G) {
                break;
            }

            int toUp = n+U;
            int toDown = n-D;
            if(toUp <= F && A[toUp] == -1) {
                A[toUp] = A[n] + 1;
                q.add(toUp);
            }
            if(toDown > 0 && A[toDown] == -1) {
                A[toDown] = A[n]+1;
                q.add(toDown);
            }

        }

        if(A[G] >= 0) {
            System.out.println(A[G]);
        }
        else {
            System.out.println("use the stairs");
        }

    }
}
