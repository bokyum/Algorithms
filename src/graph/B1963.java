package graph;

import java.io.*;
import java.util.*;
public class B1963 {
    static ArrayList<Integer> prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        boolean[] prime = new boolean[10001];

        for (int i = 2; i <= 10000; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= 10000; j += i)
                    prime[j] = true;
            }
        }

        for (int i = 0; i <= 10000; i++) {
            prime[i] = !prime[i];
        }

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            boolean[] c = new boolean[10001];
            int[] d = new int[10001];

            d[p1] = 0;
            c[p1] = true;
            Queue<Integer> q = new LinkedList<>();
            q.add(p1);

            while (!q.isEmpty()) {
                int now = q.remove();
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j <= 9; j++) {
                        int next = change(now, i, j) ;
                        if(next != -1 && prime[next] && !c[next]) {
                            q.add(next);
                            d[next] = d[now] + 1;
                            c[next] = true;
                        }
                    }
                }
            }

            System.out.println(d[p2]);
        }

    }

    public static int change(int num, int index, int digit) {
        if (index == 0 && digit == 0) {
            return -1;
        }
        String s = Integer.toString(num);
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(index, (char) (digit + '0'));
        return Integer.parseInt(sb.toString());

    }
}
