package dynamicprogramming;

import java.util.Scanner;

public class ToOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int[] arr = new int[X+1];
        for(int i=2; i <= X; i++) {
            // 현재 수에서 1을 뺀 경우
            arr[i] = arr[i-1] + 1;

            if(arr[i] % 2 == 0)
                arr[i] = Math.min(arr[i], arr[i/2] + 1);
            if(arr[i] % 3 == 0)
                arr[i] = Math.min(arr[i], arr[i/3] + 1);
            if(arr[i] % 5 == 0)
                arr[i] = Math.min(arr[i], arr[i/5] + 1);
        }

        System.out.println(arr[X]);

    }
}
