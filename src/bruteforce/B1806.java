package bruteforce;

import java.util.*;
import java.io.*;
public class B1806 {
    static int N, M;
    static int[] A;

    static int solve() {
        int l = 0;
        int r = 0;
        int sum = A[0];
        int ans = N+1;
        while(l <= r && r < N) {
            if(sum < M) {
                r += 1;
                sum += A[r];
            } else if(sum == M) {
                ans = Math.min(r - l + 1, ans);
                r += 1;
                sum += A[r];
            } else if(sum > M) {
                ans = Math.min(r - l + 1, ans);
                sum -= A[l];
                l++;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        A = new int[N+1];
        for(int i=0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int ans = solve();
        if(ans > N)
            System.out.println(0);
        else
            System.out.println(ans);
    }
}
