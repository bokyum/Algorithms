package dongbinbook.bfs_dfs;

import java.util.*;

class NodeYX implements Comparable<NodeYX> {
    int y;
    int x;
    int second;
    int value;

    public NodeYX(int y, int x, int second, int value) {
        this.y = y;
        this.x = x;
        this.second = second;
        this.value = value;
    }




    @Override
    public int compareTo(NodeYX n) {
        return this.value - n.value;
    }
}
public class B18405 {
    static int N, K;
    static int S, Y, X;
    static int[][] arr;
    static int[][] direct = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    static int solve() {
        Queue<NodeYX> q = new LinkedList<>();
        List<NodeYX> l = new ArrayList<>();
        for(int i=0; i < N; i++)
            for(int j=0; j < N; j++)
                if(arr[i][j] != 0)
                    l.add((new NodeYX(i, j, 0,arr[i][j])));


        Collections.sort(l);
        for(NodeYX a: l)
            q.add(a);

        while(!q.isEmpty()) {
            NodeYX node = q.poll();
            int tempy = node.y; int tempx = node.x;
            int second = node.second;
            int value = node.value;
            if(second == S)
                break;

            for (int i = 0; i < 4; i++) {
                int dy = tempy + direct[i][0];
                int dx = tempx + direct[i][1];
                if (dy < N && dy >= 0 && dx < N && dx >= 0) {
                    if(arr[dy][dx] == 0) {
                        arr[dy][dx] = value;
                        q.add(new NodeYX(dy,dx, second+1,value));
                    }

                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); K = sc.nextInt();
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++)
                arr[i][j] = sc.nextInt();
        }
        S = sc.nextInt();
        Y = sc.nextInt();
        X = sc.nextInt();
        solve();
        System.out.println(arr[Y-1][X-1]);

    }
}
