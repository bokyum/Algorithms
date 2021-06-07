package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1046 {
    static int N, K;
    static int[] A;


    static int count(int mask) {
        int temp = 0;
        for(int i = 0; i < N; i++) {
            if((A[i] & (~(1 << 27) - mask)) == 0)
                temp++;
        }

        return temp;
    }

    static boolean ok(int index) {
        if(index == 'a' - 'a' || index == 'n' - 'a' || index == 't' - 'a'
            || index == 'i' - 'a' || index == 'c' - 'a')
            return true;
        return false;
    }

    static int solve(int index, int cnt, int mask) {
        if(index == 27) {
            return count(mask);
        }
        if(cnt > K) {
            return -1;
        }
        int ans = 0;
        int max;
        if(ok(index)) {
            max = solve(index+1, cnt+1, mask | (1 << index));
        }
        else {
            int temp1 = solve(index+1, cnt, mask);
            int temp2 = solve(index+1, cnt+1, mask | (1<<index));
            if(temp1 < temp2)
                max = temp2;
            else
                max = temp1;
        }
        if(ans < max)
            ans = max;
        return ans;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N];
        for(int i=0; i < N; i++) {
            String temp = br.readLine();
            for(char c: temp.toCharArray()) {
                A[i] = A[i] | (1 << (c - 'a'));
            }
        }
        if(K < 5) {
            System.out.println(0);
            return;
        }

        System.out.println(solve(0, 0, 0));
        // a n t i c



    }
}
