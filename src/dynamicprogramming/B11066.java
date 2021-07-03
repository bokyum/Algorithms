package dynamicprogramming;
import java.io.*;
import java.util.*;
public class B11066 {
    static int[] A;
    static int[][] d;

    static int solve(int i, int j) {
        if(i==j)
            return 0;
        if(d[i][j] != -1)
            return d[i][j];

        int ans = -1;
        int sum = 0;
        for(int k=i; k <= j; k++)
            sum += A[k];

        for(int k=i; k <= j-1; k++){
            int temp = solve(i, k) + solve(k+1, j) + sum;
            if(ans == -1 || temp < ans)
                ans = temp;
        }
        d[i][j] = ans;
        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            A = new int[N+1];
            d = new int[N+1][N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i <= N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
                Arrays.fill(d[i], -1);
            }

            System.out.println(solve(1, N));
        }

    }
}
