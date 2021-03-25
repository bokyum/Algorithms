package jongmanbook.Chap07;

import java.util.Scanner;

public class Fence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        int[] ans = new int[C];
        while(C-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = sc.nextInt();// 여기까지 입력 받는 과정

            ans[C] = solve(arr, 0, arr.length-1);

        }
        for(int i = ans.length-1; i >= 0; i--)
            System.out.println(ans[i]);
    }

    static int solve(int[] arr, int left, int right) {
        //기저 사례: 판자가 하나밖에 없는 경우
        if(left == right) return arr[left];
        //[left, mid] [mid+1, right]의 두 구간으로 문제를 분할한다.
        int mid = (left + right) / 2;
        // 분할한 문제를 각개격파
        int ret = Math.max(solve(arr, left, mid), solve(arr, mid+1, right));
        //부분 문제 3: 두 부분에 모두 걸치는 사각형 중 가장 큰 것을 찾는다.
        int lo = mid, hi = mid+1;
        int height = Math.min(arr[lo], arr[hi]);
        //[mid, mid+1]만 포함하는 너비 2인 사각형을 고려한다.
        ret = Math.max(ret, height*2);
        // 사각형이 전체를 덮을 때까지 확장한다.
        while(left < lo || right > hi) {
            //항상 높이가 더 높은 쪽으로 확장한다.
            if(hi < right && (lo == left || arr[lo-1] < arr[hi+1])){
                hi++;
                height = Math.min(height, arr[hi]);
            } else {
                lo--;
                height = Math.min(height, arr[lo]);
            }
            //확장한 후 사각형의 높이
            ret = Math.max(ret, height * (hi - lo + 1));
        }
        return ret;
    }

    static int bruteForce(int[] arr) {
        int ret = 0;
        int N = arr.length;
        for (int left = 0; left < N; left++) {
            int minHeight = arr[left];
            for (int right = left; right < N; right++) {
                minHeight = Math.min(minHeight, arr[right]);
                ret = Math.max(ret, (right - left + 1) * minHeight);
            }
        }
        return ret;
    }
}
