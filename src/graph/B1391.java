package graph;


import java.util.*;


public class B1391 {
    static int K;
    static final int MAX_POSITION = 150_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        K = sc.nextInt();

        if(N == K){
            System.out.println(0);
            System.out.println(N);
            return;
        }
        boolean[] check = new boolean[MAX_POSITION];
        int[] before = new int[MAX_POSITION];

        Queue<XC> q = new LinkedList<>();
        ArrayList<Integer> temp  = new ArrayList<>();


        q.add(new XC(N, 0));
        check[N] = true;
        before[N] = -1;
        int ans = 0;
        while (!q.isEmpty()) {
            XC now = q.poll();
            int nx = now.x;
            int nc = now.c;
            if(nx == K){
                ans = nc;
                while(true) {
                    temp.add(nx);
                    if(before[nx] == -1)
                        break;
                    nx = before[nx];
                }
                break;


            }


            if(nx * 2 < MAX_POSITION && !check[nx*2])  {
                check[nx*2] = true;
                q.add(new XC(nx*2, nc+1));
                before[nx*2] = nx;
            }
            if(nx+1 < MAX_POSITION && !check[nx+1]) {
                check[nx + 1] = true;
                q.add(new XC(nx + 1, nc + 1));
                before[nx+1] = nx;
            }
            if(nx-1 >= 0 && !check[nx-1]) {
                check[nx - 1] = true;
                q.add(new XC(nx - 1, nc + 1));
                before[nx-1] = nx;
            }
        }
        System.out.println(ans);

        for(int i = temp.size()-1; i>=0; i--)
            System.out.print(temp.get(i) + " ");
        System.out.println();



    }
}

