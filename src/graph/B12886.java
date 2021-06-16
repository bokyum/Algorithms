package graph;

import java.util.*;

public class B12886 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] A = new int[3];
        A[0] = sc.nextInt();
        A[1] = sc.nextInt();
        A[2] = sc.nextInt();

        Arrays.sort(A);
        boolean[][] check = new boolean[1501][1501];
        Queue<int[]> q = new LinkedList<>();
        q.add(A);
        check[A[0]][A[1]] = true;


        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            if(now[0] == now[1] && now[1] == now[2]) {
                System.out.println(1);
                System.exit(0);
            }

            if(now[1] != now[0] && now[1] - now[0] >=0) {
                c1 = now[0] + now[0];
                c2 = now[1] - now[0];
                c3 = now[2];
                A = new int[]{c1, c2, c3};
                Arrays.sort(A);
                if (!check[A[0]][A[1]]) {
                    check[A[0]][A[1]] = true;
                    q.add(A);
                }
            }
            if(now[2] != now[0] && now[2] - now[0] >= 0) {
                c1 = now[0] + now[0];
                c2 = now[1] ;
                c3 = now[2] - now[0];
                A = new int[]{c1, c2, c3};
                Arrays.sort(A);
                if (!check[A[0]][A[1]]) {
                    check[A[0]][A[1]] = true;
                    q.add(A);
                }
            }
            if(now[2] != now[1] && now[2] - now[1] >= 0) {
                c1 = now[0];
                c2 = now[1] + now[1];
                c3 = now[2] - now[1];
                A = new int[]{c1, c2, c3};
                Arrays.sort(A);
                if (!check[A[0]][A[1]]) {
                    check[A[0]][A[1]] = true;
                    q.add(A);
                }
            }
        }

        System.out.println(0);

    }
}
