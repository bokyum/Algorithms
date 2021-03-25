package jongmanbook.Chap07.retry;

import java.util.Scanner;
// Case 1: 가장 큰 직사각형을 왼쪽 부분 문제에서만 잘라낼 수 있다.
// Case 2: 가장 큰 직사각형을 오른쪽 부분 문제에서만 잘라낼 수 있다.
// Case 3: 가장 큰 직사각형은 왼쪽 부분 문제와 오른쪽 부분문제에 걸쳐 있다.
public class FenceRetry {
    static int[] fenceArr;

    // left...right구간에서 찾을 수 있는 가장 큰 직사각형의 넓이를 구함
    static int dAndCSolve(int left, int right) {
        if(left == right)
            return fenceArr[left];
        // [left...mid] [mid+1...right]의 두 구간 문제로 분할
        int mid = (left + right) / 2;
        // Case 1,2 해결
        int ret = Math.max(dAndCSolve(left, mid), dAndCSolve(mid+1, right));
        // Case 3
        int lo = mid; int hi = mid+1;
        int height = Math.min(fenceArr[lo], fenceArr[hi]);
        ret = Math.max(ret, height * 2);
        // 사각형을 전체 덮을 때 까지 확장
        while(left < lo || hi < right) {
            //항상 높이가 더 높은 쪽으로 이동
            if(hi < right && (lo == left || fenceArr[lo-1] < fenceArr[hi+1])){
                ++hi;
                height = Math.min(height, fenceArr[hi]);
            }
            else {
                --lo;
                height = Math.min(height, fenceArr[lo]);
            }
            ret = Math.max(ret, height * (hi - lo + 1));
        }
        return ret;

    }

    static int bruteSolve() {
        int ret = 0;
        for(int left = 0; left < fenceArr.length; left++){
            int minHeight = fenceArr[left];
            for(int right = left; right < fenceArr.length; right++) {
                minHeight = Math.min(minHeight, fenceArr[right]);
                ret = Math.max(ret, (right - left + 1) * minHeight);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        while(C-- > 0) {
            int N = sc.nextInt();
            fenceArr = new int[N];
            for(int i=0; i < N; i++)
                fenceArr[i] = sc.nextInt();

        }
    }
}
