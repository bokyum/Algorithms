package dongbinbook.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class G315 {

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

        int target = 1;
        for(int a: arr) {
            if (target < a)
                break;
            target += a;
        }

        System.out.println(target);




    }
}
