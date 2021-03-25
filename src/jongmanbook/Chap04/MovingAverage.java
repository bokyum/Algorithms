package jongmanbook.Chap04;

import java.util.ArrayList;
import java.util.List;

public class MovingAverage {

    static List<Double> movingAverage1(List<Double> a, int M) {
        List<Double> ret = new ArrayList<>();
        int N = a.size();
        for(int i = M-1; i < N; ++i) {
            //a[i]까지의 이동 평균 값을 구하자
            double partialSum = 0;
            for(int j = 0; j < M; ++j)
                partialSum += a.get(i - j);
            ret.add(partialSum / M);
        }
        return ret;
    }

    static List<Double> movingAverage2(List<Double> arr, int M) {
        List<Double> ret = new ArrayList<>();
        int N = arr.size();
        double partialSum = 0;
        for(int i = 0; i < M-1; ++i)
            partialSum += arr.get(i);
        for(int i = M-1; i < N; ++i){
            partialSum += arr.get(i);
            ret.add(partialSum/M);
            partialSum -= arr.get(i-M+1);
        }
        return ret;
    }

    static final int MIN = Integer.MIN_VALUE;

    static int inefficientMaxSum(List<Integer> arr) {
        int N = arr.size();
        int ret = MIN;
        for(int i = 0; i < N; ++i) {
            for(int j=i; j < N; ++j) {
                int sum = 0;
                for(int k = i; k <= j; ++k)
                    sum += arr.get(k);
                ret = Math.max(ret, sum);
            }
        }
        return ret;
    }
    static int betterMaxSum(List<Integer> arr) {
        int N = arr.size();
        int ret = MIN;
        for(int i = 0; i < N; ++i) {
            int sum = 0;
            for(int j = i; j < N; ++j) {
                sum += arr.get(j);
                ret = Math.max(ret, sum);
            }
        }
        return ret;
    }

    //a[lo..hi]의 연속된 부분 구간의 최대 합을 구한다. 시간 복잡도 O(nlogn)
    static int fastMaxSum(List<Integer> arr, int lo, int hi) {
        // 기저 사례: 구간의 길이가 1일 경우
        if(lo == hi) return arr.get(lo);
        //배열을 a[lo..mid], a[mid+1..hi]의 두 조각으로 나눈다.
        int mid = (lo + hi) / 2;
        // 두 부분에 모두 걸쳐 있는 최대 합 구간을 찾는다. 이 구간은
        // a[i..mid]와 a[mid+1..j] 형태를 갖는 구간의 합으로 이루어진다.
        // a[i..mid] 형태를 갖는 최대 구간을 찾는다.
        int left = MIN, right = MIN, sum = 0;
        for(int i = mid; i >= lo; --i){
            sum += arr.get(i);
            left = Math.max(left, sum);
        }
        //a[mid+1..j] 형태를 갖는 최대 구간을 찾는다.
        sum = 0;
        for(int j = mid+1; j <= hi; ++j) {
            sum += arr.get(j);
            right = Math.max(right, sum);
        }

        // 최대 구간이 두 조각 중 하나에만 속해 있는 경우의 답을 재귀 호출로 찾는다.
        int single = Math.max(fastMaxSum(arr, lo, mid), fastMaxSum(arr, mid+1, hi));
        //
        return Math.max(left + right, single);

    }

    // a[]의 연속된 부분 구간의 최대 합을 구한다 시간복잡도 O(n)
    int fastestMaxSum(List<Integer> arr){
        int N = arr.size(), ret = MIN, psum = 0;
        for(int i = 0; i < N; ++i) {
            psum = Math.max(psum, 0) + arr.get(i);
            ret = Math.max(psum, ret);
        }
        return ret;
    }
}
