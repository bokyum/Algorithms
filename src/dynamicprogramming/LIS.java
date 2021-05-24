package dynamicprogramming;

import java.io.*;
import java.util.*;

public class LIS {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] D = new int[N];
        int[] V = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            D[i] = 1;
            V[i] = -1;
        }

        for(int i=1; i < N; i++) {
            for(int j=i-1; j>=0; j--) {
                if(A[i] > A[j]) {
                    if(D[i] <= D[j]) {
                        D[i] = D[j] + 1;
                        V[i] = j;
                    }
                }
            }
        }
        int ans = 0;
        int maxIndex = 0;
        for(int i=0; i < N; i++) {
            if(ans < D[i]) {
                ans = D[i];
                maxIndex = i;
            }
        }
        ArrayList<Integer> ansArr = new ArrayList<>();

        ansArr.add(A[maxIndex]);
        while(V[maxIndex] != -1) {
            maxIndex = V[maxIndex];
            ansArr.add(A[maxIndex]);
        }

        System.out.println(ans);
        for(int i=ansArr.size()-1; i >=0; i--)
            System.out.print(ansArr.get(i) + " ");
        System.out.println();

    }
}
