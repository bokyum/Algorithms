package graph.done;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B14395 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s= sc.nextInt();
        int t = sc.nextInt();
        if(s == t) {
            System.out.println(0);
            System.exit(0);
        }
        else if(t == 0) {
            System.out.println("-");
            System.exit(0);
        }
        else if(t == 1) {
            System.out.println("/");
            System.exit(0);
        }

        boolean[] check = new boolean[1000_000_001];

        Queue<Node> q = new LinkedList<>();
        check[s] = true;
        q.add(new Node(s, ""));

        boolean first = true;
        boolean ok = false;
        while(!q.isEmpty()) {
            Node n = q.poll();
            int num = n.now;
            String crt = n.crt;
            if(num == t) {
                System.out.println(crt);
                ok = true;
                break;
            }
            for(int i=0; i < 4; i++) {
                long value = num;
                String nowString = crt;
                if(i == 0) {
                    value *= value;
                    nowString += '*';
                }
                else if(i == 1) {
                    value += value;
                    nowString += '+';
                }
                else if(first && i == 2) {
                    value = 0;
                    nowString = "-";
                }
                else if(first && i == 3) {
                    value = 1;
                    nowString = "/";
                    first = false;

                }
                if(value > 1000_000_000 || value > (long)t*t)
                    continue;
                int intValue = (int)value;
                if(intValue == num || check[intValue])
                    continue;
                else {
                    q.add(new Node(intValue, nowString));
                    check[intValue] = true;
                }
            }

        }
        if(!ok)
            System.out.println(-1);
    }

    static class Node {
        int now;
        String crt;
        public Node(int now, String crt) {
            this.now = now;
            this.crt = crt;
        }
    }
}
