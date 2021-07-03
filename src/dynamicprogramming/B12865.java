package dynamicprogramming;

import java.io.*;
import java.util.*;

public class B12865 {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 물품수
        K = Integer.parseInt(st.nextToken()); // 버틸수있는 무게
        int[] w = new int[N+1];
        int[] v = new int[N+1];

        for(int i=1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());

        }
        int[][] d = new int[N+1][K+1];
        for(int i=1; i <= N; i++) {
            for(int j=1; j <= K; j++) {
                d[i][j] = d[i-1][j];
                if(j - w[i] >= 0){
                    d[i][j] = Math.max(d[i][j], d[i-1][j-w[i]] + v[i]);
                }
            }
        }
        System.out.println(d[N][K]);
    }

}
