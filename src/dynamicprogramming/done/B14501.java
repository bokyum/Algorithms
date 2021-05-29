package dynamicprogramming.done;

import java.io.*;
import java.util.*;

public class B14501 {
    static int N;
    static int[] T, P;
    static int[] d;

    static int solve(int index) {
        if(index == N)
            return 0;
        if(index > N)
            return -999_999_999;

        if(d[index] != -1)
            return d[index];

        int temp1 = solve(index + T[index]) + P[index];
        int temp2 = solve(index+1);
        d[index] = Math.max(temp1, temp2);

        return d[index];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];
        d = new int[N];
        for(int i=0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
            d[i] = -1;
        }

        System.out.println(solve(0));
    }
}
