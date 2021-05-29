package graph.done;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 1. 1을 무작위 3개 세우고
*  2. 2를 bfs로 채울수 있는 곳 다 채움
*  3. 남은 0의 개수 모두 세서 가장 큰 수 출력 */
class YX {
    int y;
    int x;

    public YX(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
public class B14502 {
    static int N, M; // N == 세로 M == 가로
    static int[][] direct = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    static int countNumOfZero(int[][] map) {
        int answer = 0;
        for(int i=0; i < N; i++)
            for(int j=0; j < M; j++)
                if(map[i][j] == 0)
                    answer++;
        return answer;
    }

    static int[][] setTwoByBfs(int[][] map) {
        Queue<YX> q = new LinkedList<YX>();
        for(int i=0; i < N; i++)
            for(int j=0; j < M; j++) {
                if(map[i][j] == 2)
                    q.offer(new YX(i, j));
            }
        while(!q.isEmpty()) {
            YX yx = q.poll();
            int y = yx.y;
            int x = yx.x;
            for(int i=0; i<4; i++) {
                int directY = y + direct[i][0];
                int directX = x + direct[i][1];
                if(directY < N &&  directY >= 0 &&
                directX < M && directX >= 0) {
                    if (map[directY][directX] == 0) {

                        map[directY][directX] = 2;
                        q.offer(new YX(directY, directX));
                    }
                }
            }
        }
        return map;
    }

    static int solve(int[][] map,int current) {
        if(current >= 3) { // 0->1 1 -> 2 2->3
            return countNumOfZero(setTwoByBfs(map));
        }
        int answer = 0;
        for(int i=0; i < N; i++)
            for(int j=0; j < M; j++) {
                if(map[i][j] == 0) {
                    int[][] temp = new int[N][M];
                    for(int q=0; q < N; q++)
                        for(int w=0; w < M; w++)
                            temp[q][w] = map[q][w];
                    temp[i][j] = 1;
                    answer = Math.max(answer, solve(temp, current + 1));
                }
            }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();
        int[][] map = new int[N][M];

        for(int i=0; i < N; i++)
            for(int j=0; j < M; j++)
                map[i][j] = sc.nextInt();
        System.out.println(solve(map,0));

    }
}
