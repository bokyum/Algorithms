package dongbinbook.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class NumCard03 {
    static final int INF = 987654321;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        N = sc.nextInt(); M = sc.nextInt();
        Integer[] inputArr = new Integer[N];

        for(int i=0; i < N; i++) {
            int temp = INF;
            for (int j = 0; j < M; j++)
                temp = Math.min(temp, sc.nextInt());
            inputArr[i] = temp;
        }
        Arrays.sort(inputArr, Collections.reverseOrder());
        System.out.println(inputArr[0]);
    }
}
