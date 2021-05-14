package dongbinbook.greedy;

import java.util.Scanner;

public class G315_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] numArr = new int[11];
        for(int a: arr) {
            numArr[a] += 1;
        }

        int result = 0;
        for(int i=1; i < 10; i++) {
            N -= numArr[i];
            result += numArr[i] * N;
        }
        System.out.println(result);

/*        int result = 0;
        for(int i=0; i < N-1; i++) {
            for(int j=i+1; j < N; j++) {
                if(arr[i] != arr[j]) {
                    result++;
                }
            }

        }
        System.out.println(result);*/
    }
}
