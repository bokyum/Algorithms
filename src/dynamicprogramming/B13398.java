package dynamicprogramming;

import java.io.*;
import java.util.StringTokenizer;

public class B13398 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] incToR = new int[n];
        int[] incToL = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        incToR[0] = A[0];
        for(int i=1; i < n; i++) {
            if(incToR[i-1] + A[i] > A[i])
                incToR[i] = incToR[i-1] + A[i];
            else
                incToR[i] = A[i];
        }
        incToL[n-1] = A[n-1];
        for(int i=n-2; i>=0; i--) {
            if(incToL[i+1] + A[i] > A[i])
                incToL[i] = incToL[i+1] + A[i];
            else
                incToL[i] = A[i];
        }
        int max = -999_999;
        for(int i=0; i < n; i++) {
            if(max < incToR[i])
                max = incToR[i];
        }
        for(int i=1; i < n-1; i++) {
            if(max < incToR[i-1] + incToL[i+1])
                max = incToR[i-1] + incToL[i+1];
        }

        System.out.println(max);
    }
}
