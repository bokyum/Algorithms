package graph;

import java.util.*;

class ABC {
    int a;
    int b;
    int c;

    public ABC(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class B14226 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();

        boolean[][] cache = new boolean[1000+1][1000+1];
        Queue<ABC> q = new LinkedList<>();
        q.add(new ABC(1,0,0));
        cache[1][0] = true;

        while(!q.isEmpty()) {
            ABC now = q.poll();
            int a = now.a;
            int b= now.b;
            int c = now.c;
            if(a == S) {
                System.out.println(c);
                break;
            }
            if(a >= 0 && !cache[a][a]) {
                q.add(new ABC(a, a, c + 1));
                cache[a][a] = true;
            }
            if(a+b <= 1000 && a >= 0 && b > 0 && !cache[a+b][b]) {
                q.add(new ABC(a+b, b, c+1));
                cache[a+b][b] = true;
            }
            if(a-1 >= 0 && !cache[a-1][b]) {
                q.add(new ABC(a-1, b, c+1));
                cache[a-1][b] = true;
            }
        }


    }
}
