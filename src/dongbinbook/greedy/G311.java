package dongbinbook.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class G311 {
    static int N;
    static int[] arr;




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for(int i=0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        // 여까지 입력 받는 작업

        // 2 3 1 2 2
        // ! ! !
        // 1 2 2 2 3
        // ! @ @ X X

        int result = 0;
        int count = 0;
        for(int i=0; i < N; i++) {
            count++;
            if(count >= arr[i]) {
                result++;
                count = 0;
            }
        }

        System.out.println(result);

    }
}
