package dongbinbook.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Node implements Comparable<Node>{
    private int A;
    private int B;
    private int C;

    public Node(int a,int b, int c) {
        A = a;
        B = b;
        C = c;
    }

    public int getA() {
        return A;
    }

    public void setA(int a) {
        A = a;
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

    public int getC() {
        return C;
    }

    public void setC(int c) {
        C = c;
    }

    @Override
    public int compareTo(Node o) {
        if(this.C < o.getC()) {
            return -1;
        }
        return 1;
    }
}

public class SeparateVillage {
    static int N, M;
    public static int result = 0;
    public static int[] parent = new int[100001];
    public static ArrayList<Node> graph = new ArrayList<Node>();

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

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for(int i=0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            graph.add(new Node(A, B, C));
        }

        Collections.sort(graph);
        int last = 0;

        for(int i=0; i < graph.size(); i++) {
            int A = graph.get(i).getA();
            int B = graph.get(i).getB();
            int C = graph.get(i).getC();
            if(findParent(A) != findParent(B)) {
                unionParent(A, B);
                result += C;
                last = C;

            }

        }

        System.out.println(result - last);

    }
}
