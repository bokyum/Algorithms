package bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {

    //  2 4 6 5 3 1
    static boolean next_permutation(int[] arr) {
        int i = arr.length-1;
        while(i > 0 && arr[i-1] >= arr[i]) i--;

        if(i <= 0)
            return false; // 정렬 마침
        int j = arr.length-1;
        while(arr[j] <= arr[i-1]) j--;

        int temp = arr[j];
        arr[j] = arr[i-1];
        arr[i-1] = temp;

        int left = i;
        int right = arr.length-1;
        while(left < right) {
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++; right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for(int i=0; i < N; i++)
            a[i] = sc.nextInt();


        if(!next_permutation(a)) {
            System.out.println(-1);
            return;
        }
        else {
            for (int i = 0; i < a.length; i++)
                System.out.print(a[i] + " ");
            System.out.println();
        }


    }
}
