package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15988 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] d = new long[1_000_001];
        d[0] = 1;
        d[1] = 1;
        d[2] = 2;
        for(int i=3; i<=1_000_000; i++) {
            d[i] = d[i-3] + d[i-2] + d[i-1];
            d[i] %= 1_000_000_009;
        }

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int t = Integer.parseInt(br.readLine());
            System.out.println(d[t]);
        }

    }
}
