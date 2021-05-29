package dynamicprogramming.done;

import java.util.*;
import java.io.*;

public class B1912 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        int[] D = new int[N];
        for(int i=0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        D[0] = A[0];
        for(int i=1; i < N; i++) {
            D[i] = Math.max(A[i], D[i-1] + A[i]);
        }

        int ans = -10_000;
        for(int i=0; i < N; i++) {
            if(ans < D[i])
                ans = D[i];
        }

        System.out.println(ans);

    }
}
