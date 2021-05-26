package graph;

import java.io.IOException;
import java.util.*;

class Node3 {
    private int x;
    private int y;

    public Node3(int y, int x) {
        this.y = y;
        this.x = x;
    }
    public int getY() {
        return this.y;
    }
    public int getX() {
        return this.x;
    }
}

public class Maze {

    static int N, M;
    static int[][] mazeArr;

    static final int[][] direct = {
            {-1, 0}, // 상
            {1, 0}, // 하
            {0, -1}, // 왼
            {0, 1}, // 오
    };

    static int solve(int y, int x) {
        Queue<Node3> queue = new LinkedList<>();
        queue.offer(new Node3(y, x));
        while(!queue.isEmpty()) {
            Node3 temp = queue.poll();
            y = temp.getY(); x = temp.getX();
            for(int directIndex=0; directIndex < 4; ++directIndex){
                int diY = y + direct[directIndex][0];
                int diX = x + direct[directIndex][1];
                if(0 <= diY && diY < N && 0 <= diX && diX < M && mazeArr[diY][diX] == 1){
                    queue.add(new Node3(diY, diX));
                    mazeArr[diY][diX] = mazeArr[y][x] + 1;
                }
            }

        }
        return mazeArr[N-1][M-1];
     }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();
        sc.nextLine();
        mazeArr = new int[N][M];
        for(int i=0; i<N; i++) {
            String temp = sc.nextLine();
            for(int j=0; j<M; j++)
                mazeArr[i][j] = temp.charAt(j) - '0';
        }

        System.out.println(solve(0, 0));
    }
}
