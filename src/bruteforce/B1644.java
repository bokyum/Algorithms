package bruteforce;

import java.util.ArrayList;
import java.util.Scanner;

public class B1644 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[] A = new boolean[N+1];
        ArrayList<Integer> prime = new ArrayList<>();

        for(int i=2; i <= N; i++) {
            if(A[i])
                continue;
            else
                prime.add(i);
            for(int j = i; i*j <= N; ++j) {
                if(((long)i*j) > 4000000)
                    break;
                A[i*j] = true;
            }
        }
        prime.add(0);
        int left = 0;
        int right = 0;
        int sum = prime.get(0);
        int ans = 0;
        while(left <= right && right < prime.size()-1) {
            if(sum < N) {
                right++;
                sum += prime.get(right);
            } else if(sum > N) {
                sum -= prime.get(left);
                left++;
                if(left > right && left < prime.size()-1) {
                    right = left;
                    sum = prime.get(left);
                }
            } else if(sum == N) {
                ans ++;
                right++;
                sum += prime.get(right);
            }
        }
        System.out.println(ans);
    }
}
