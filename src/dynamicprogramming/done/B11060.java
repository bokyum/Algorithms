package dynamicprogramming.done;

import java.io.*;
import java.util.*;

public class B11060 {
    static int N;
    static int[] A;
    static final int MAX_VALUE = 100_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N+100];
        int[] d = new int[N+100];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            d[i] = MAX_VALUE;
        }
        for(int i=N; i < N+100; i++)
            d[i] = MAX_VALUE;
        d[0] = 0;
        for(int i=0; i < N; i++) {
            for(int j=1; j <= A[i]; j++) {
                d[i+j] = Math.min(d[i] + 1, d[i+j]);
            }
        }

        if(d[N-1] == MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(d[N-1]);

    }
}
