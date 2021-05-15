package baekjoon.retry;

import java.util.*;

public class B1697 {



    // N == N-1 || N+1 || N*2
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = scan.nextInt();
        int second = scan.nextInt();
        int point = first; // 첫번째부터 검색

        int[] dir = new int[3];
        int[] visit = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(first);

        while(!queue.isEmpty() && point != second) {
            point = queue.poll();
            dir[0] = point + 1; dir[1] = point - 1; dir[2] = point * 2;

            for(int i = 0; i < 3; i++) {
                if(dir[i] >= 0 && dir[i] <= 100000) {
                    if(visit[dir[i]] == 0) {
                        visit[dir[i]] = visit[point] + 1; queue.add(dir[i]);
                    }
                }
            }
        }
        System.out.print(visit[second]);


    }
}
