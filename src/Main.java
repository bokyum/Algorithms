import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static String[] A;

    // a, n, t, i , c --> 필수로 들어가야함
    // 영어 총 26개

    public static int check_arr(int now) {

        int ans = 0;

        for(int i=0; i < N; i++) {
            boolean ok = true;
            for(int j=0; j < A[i].length(); j++) {
                int crt = 1 << (A[i].charAt(j) - 'a');
                if((crt & now) == crt) {
                   continue;
                }
                else {
                    ok = false;
                    break;
                }
            }
            if(ok)
                ans++;
        }
        return ans;
    }

    static int solve(int move, int cnt, int alpha) {
        if(cnt == K) {
            return check_arr(alpha);
        }
        if(move > 26) {
            return 0;
        }
        int ans = 0;
        if((alpha & (1 << move)) == (1 << move)) {
            int temp = solve(move+1, cnt, alpha);
            if(temp > ans)
                ans = temp;
        }
        else {
            int temp1 = solve(move+1, cnt, alpha);
            alpha = alpha | (1 << move);
            int temp2 = solve(move+1, cnt+1, alpha);
            int temp = Math.max(temp1, temp2);
            if(temp > ans)
                ans = temp;
        }

        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new String[N];
        for(int i=0; i < N; i++) {
            A[i] = br.readLine();
            //System.out.println(A[i]);
        }
        if(K < 5) {
            System.out.println(0);
            System.exit(0);
        }

        System.out.println(solve(0, 5, must()));
    }

    private static int must() {
        int must = 0;
        must = must | 1;
        must = must | (1 << ('c' - 'a'));
        must = must | (1 << ('n' - 'a'));
        must = must | (1 << ('t' - 'a'));
        must = must | (1 << ('i' - 'a'));
        return must;
    }
}
