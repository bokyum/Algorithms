package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
* 다양한 수로 이루어진 배열이 있을 때 주어진 수들을 M번 더하여 가장 큰 수를 만드는 법칙
* 단, 배열의 특정한 인덱스에 해당하는 수 가 연속해서 K번 초과하여 나올 수 없다.
* */
public class BigNum02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M, K;
        int sum = 0;
        N = sc.nextInt(); M = sc.nextInt(); K = sc.nextInt();
        Integer[] arr = new Integer[N];

        for(int i=0; i < N; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr, Collections.reverseOrder());

        int i = 0;
        while(i < M) { // 총 M번 수를 더해야함

            for(int j=0; j < K && i < M; j++, i++){
                sum += arr[0];
            }
            if(i < M) {
                sum += arr[1];
                i++;
            }
        }

        System.out.println(sum);

    }
}
