package dynamicprogramming.done;

import java.io.*;
import java.util.*;

public class B10942 {
    static int N;
    static int[] A;
    static int[][] d;

    static int solve(int l, int r) {
        if(l == r) {
            return 1;
        }
        else if(l+1 == r) {
            if(A[l] == A[r])
                return 1;
            else
                return 0;
        }

        if(d[l][r] != -1)
            return d[l][r];
        if(A[l] != A[r])
            return d[l][r] = 0;
        else
            return d[l][r] = solve(l+1, r-1);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        d = new int[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(d[i], -1);
        }


        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            sb.append(solve(l, r));
            sb.append('\n');
        }

        System.out.println(sb.toString());


    }


}
