package jongmanbook.Chap08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LIS {
    static int N;
    static int[] sequence;
    static int[] cache;

    static int solve(List<Integer> sequence) {
        if(sequence.size() == 0)
            return 0;
        int ret = 0;
        for(int i=0; i < sequence.size(); i++) {
            List<Integer> B = new ArrayList<>();
            for(int j = i+1; j < sequence.size(); j++)
                if(sequence.get(i) < sequence.get(j))
                    B.add(sequence.get(j));
            ret = Math.max(ret, 1 + solve(B));
        }
        return ret;

    }

    static int solve2(int start) {
        if(cache[start] != -1)
            return cache[start];
        int ret = 1;
        for(int next = start+1; next < N; next++)
            if(sequence[start] < sequence[next])
                ret = Math.max(ret, solve2(next) + 1);
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();

        while(C-- > 0) {
            N = sc.nextInt();
            sequence = new int[N];
            cache = new int[N];
            for(int i=0; i < N; i++) {
                sequence[i] = sc.nextInt();
                cache[i] = -1;
            }
            int maxLen = 0;
            for(int begin=0; begin < N; begin++)
                maxLen = Math.max(maxLen, solve2(begin));
            System.out.println(maxLen);
        }
    }
}
