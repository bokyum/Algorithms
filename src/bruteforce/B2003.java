package bruteforce;

import java.io.*;
import java.util.*;
public class B2003 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());
        int ans = 0;
        for(int i=0; i < N; i++) {
            int sum = 0;
            for(int j=i; j < N; j++) {
                sum += A[j];
                if(sum == M)
                    ans++;
                else if(sum > M)
                    break;

            }
        }

        System.out.println(ans);
    }
}
