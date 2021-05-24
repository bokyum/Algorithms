package graph;

import java.util.Scanner;

public class MatchingTeam {
    static int N, M;
    public static int[] parent = new int[100001]; // 부모 테이블 초기화하기

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        while(M-- > 0) {
            int c = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(c == 0) {
                unionParent(a, b);
            }
            else if (c == 1){
                if(findParent(a) == findParent(b)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }


        }
    }
}
