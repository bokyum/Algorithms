package jongmanbook.Chap06;

import java.util.ArrayList;
import java.util.List;

public class RecursionExample {
    int sum(int n) {
        int ret = 0;
        for(int i = 1; i <= n; ++i) {
            ret += 1;
        }
        return ret;
    }

    int recursiveSum(int n){
        if(n==1) return 1;
        return n + recursiveSum(n-1);
    }

/*    n: 전체 원소의 수
    picked: 지금까지 고른 원소들의 번호
    toPick: 더 고를 원소의 수
    일 때, 앞으로 toPick개의 원소를 고르는 모든 방법을 출력한다.*/

    static void pick(int n, List<Integer> picked, int toPick) {
        // 기저 사례: 더 고를 원소가 없을 때 고른 원소들을 출력한다.
        if(toPick == 0) {
            for(Integer p: picked)
                System.out.print(p+" ");
            System.out.println();
            return ;
        }
        //고를 수 있는 가장 작은 번호를 계산한다.
        int smallest = picked.isEmpty() ? 0 : picked.get(picked.size() - 1) + 1;
        //이 단계에서 원소 하나를 고른다.
        for(int next = smallest; next < n; ++next) {
            picked.add(next);
            pick(n, picked, toPick-1);
            picked.remove(picked.size() - 1);
        }
    }

    public static void main(String[] args) {
        pick(7, new ArrayList<Integer>(), 4);
    }

}
