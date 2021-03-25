package implementation;

import java.util.Scanner;

public class Time02 {
    // 분 == 60초
    // 시 == 60 * 60 = 3600초
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 0;
        for(int i=0; i<N+1; i++)
            for(int j=0; j<60; j++)
                for(int k=0; k <60; k++){
                    String h = Integer.toString(i);
                    String m = Integer.toString(j);
                    String s = Integer.toString(k);
                    if(h.indexOf('3') >= 0 || m.indexOf('3')>=0 || s.indexOf('3')>=0)
                        count++;
                }

        /*int i=0;
        while(i++ < N-1) {
            int minute = i / 60;
            int hour = minute / 60;
            int second = i % 60;
            String min = Integer.toString(minute % 60);
            String h = Integer.toString(hour);
            String s = Integer.toString(second);
            if(h.indexOf('3') >= 0 || min.indexOf('3')>=0 || s.indexOf('3')>=0)
                count++;
        }*/
        System.out.println(count);

    }
}
