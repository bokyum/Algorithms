package baekjoon.retry;

import java.util.PriorityQueue;
import java.util.Scanner;

class Time implements Comparable<Time>{
    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if(this.end == o.end)
            return this.start - o.start;
        return this.end - o.end;


    }
}
public class B1931 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Time> pq = new PriorityQueue<>();
        int N = sc.nextInt();

        for(int i=0; i< N; i++){
            int s= sc.nextInt();
            int e = sc.nextInt();
            pq.add(new Time(s,e));
        }

        int startTime = 0;
        int lastTime = 0;
        int answer = 0;
        while(!pq.isEmpty()) {
            Time t = pq.poll();
            if(t.start == lastTime && t.end == t.start) {
                answer++;
                continue; // 같은 쌍은 걍 넘기기
            }
            else if(t.start >= lastTime) {
                startTime = t.start; // last 시간을 넘기면 새로 새팅
                lastTime = t.end;
                answer++;
            }
            else
                continue;
        }
        System.out.println(answer);

    }
}
