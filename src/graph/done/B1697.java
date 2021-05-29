package graph.done;



import java.util.*;

public class B1697 {
    static int K;
    static final int MAX_POSITION = 150_000;

    static int bfs(int x) {
        boolean[] check = new boolean[MAX_POSITION];
        Queue<XC> q = new LinkedList<>();
        q.add(new XC(x, 0));
        check[x] = true;

        while (!q.isEmpty()) {
            XC now = q.poll();
            int nx = now.x;
            int nc = now.c;
            if(nx == K)
                return nc;

            if(nx * 2 < MAX_POSITION && !check[nx*2])  {
                check[nx*2] = true;
                q.add(new XC(nx*2, nc+1));
            }
            if(nx+1 <= MAX_POSITION && !check[nx+1]) {
                check[nx + 1] = true;
                q.add(new XC(nx + 1, nc + 1));
            }
            if(nx-1 >= 0 && !check[nx-1]) {
                check[nx - 1] = true;
                q.add(new XC(nx - 1, nc + 1));
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        K = sc.nextInt();

        if(N == K){
            System.out.println(0);
            return;
        }

        int answer = bfs(N);
        System.out.println(answer);



    }
}
