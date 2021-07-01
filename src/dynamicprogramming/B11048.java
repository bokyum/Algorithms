package dynamicprogramming;

import java.io.*;
import java.util.*;

public class B11048 {
    static int N, M;
    static int[][] A;
    static int[][] d;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N+1][M+1];
        d = new int[N+1][M+1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j <= M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1; i <= N; i++) {
            for(int j=1; j <= M; j++) {
                d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
                d[i][j] = Math.max(d[i][j], d[i-1][j-1]);
                d[i][j] += A[i][j];
            }
        }

        System.out.println(d[N][M]);

    }
}
