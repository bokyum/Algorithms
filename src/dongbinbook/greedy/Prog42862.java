package dongbinbook.greedy;

import java.util.Arrays;

public class Prog42862 {
    static int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        boolean[] check = new boolean[n+1];
        Arrays.fill(check, true);
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int l: lost) {
            check[l] = false;
            answer--;
        }

        if(answer == n)
            return answer;

        int lostIndex = 0;
        int reserveIndex = 0;
        while(lostIndex < lost.length && reserveIndex < reserve.length) {
            if(lost[lostIndex] == reserve[reserveIndex]) {
                check[lost[lostIndex]] = true;
                lost[lostIndex] = -1;
                reserve[reserveIndex] = -1;
                answer++;
                lostIndex++; reserveIndex++;
            }
            else if(lost[lostIndex] > reserve[reserveIndex])
                reserveIndex++;
            else if(lost[lostIndex] < reserve[reserveIndex])
                lostIndex++;
        }
        if(answer == n)
            return answer;
        for(int i=0; i < lost.length; i++) {
            if(lost[i] == -1)
                continue;
            else {
                for(int j=0; j < reserve.length; j++) {
                    if(lost[i] == -1 || reserve[j] == -1)
                        continue;
                    else {
                        if(!check[lost[i]] && lost[i] - 1 == reserve[j]) {
                            answer++;
                            check[lost[i]] = true;
                            lost[i] = -1;
                            reserve[j] = -1;
                        }
                        else if(!check[lost[i]] && lost[i] + 1 == reserve[j]) {
                            answer++;
                            check[lost[i]] = true;
                            lost[i] = -1;
                            reserve[j] = -1;
                        }
                    }
                }
            }
        }
        if(answer >= n)
            return n;
        else
            return answer;

    }

    public int solution2(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost)
            people[l-1]--;
        for (int r : reserve)
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else
                    answer--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] lost = {2,3,4,6};
        int[] reservce = {1,2,3};
        System.out.println(solution(7,lost, reservce ));
    }
}
