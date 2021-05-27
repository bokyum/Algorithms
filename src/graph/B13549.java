package graph;

import java.util.*;

public class B13549 {
    static final int MAX_VALUE = 100_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] d = new int[MAX_VALUE+1];

        Arrays.fill(d, -1);

        Queue<Integer> q0 = new LinkedList<Integer>();
        Queue<Integer> q1 = new LinkedList<Integer>();


        q0.add(N);
        d[N] = 0;

        while(!q0.isEmpty()) {
            int crtIdx = q0.poll();
            if(crtIdx == K){
                System.out.println(d[crtIdx]);
                break;
            }
            int crtValue = d[crtIdx];

            if(crtIdx == 0) {
                if(d[crtIdx+1] == -1) {
                    q1.add(crtIdx+1);
                    d[crtIdx+1] = crtValue+1;
                }
            }

            else {

                if(crtIdx * 2 <= MAX_VALUE && d[crtIdx*2] == -1) {
                    q0.add(crtIdx * 2);
                    d[crtIdx*2] = crtValue;
                }
                if(crtIdx-1 >= 0 && d[crtIdx-1] == -1) {
                    q1.add(crtIdx-1);
                    d[crtIdx-1] = crtValue+1;
                }
                if(crtIdx+1 <= MAX_VALUE && d[crtIdx+1] == -1) {
                    q1.add(crtIdx+1);
                    d[crtIdx+1] = crtValue+1;
                }



            }

            if(q0.isEmpty()){
                q0 = q1;
                q1 = new LinkedList<>();
                continue;
            }
        }
    }
}
