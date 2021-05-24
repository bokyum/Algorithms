package bruteforce;

import java.util.*;
import java.io.*;

public class TSP {
    static int N;
    static int[][] W;
    static int[] city;

    // 2 4 8 5 3 1
    static boolean next_permutation(int[] arr) {

        int i = arr.length-1;
        while(i > 0 && arr[i-1] >= arr[i]) i--;

        if(i <= 0) return false;

        int j = arr.length-1;
        while(arr[i-1] > arr[j]) j--;

        int temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;

        int last = arr.length-1;

        while(i < last) {
            temp = arr[last];
            arr[last] = arr[i];
            arr[i] = temp;

            i++; last--;
        }

        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N+1][N+1];


        for(int i=1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j <= N; j++)
                W[i][j] = Integer.parseInt(st.nextToken());
        }

        city = new int[N];
        for(int i=1; i <= N; i++)
            city[i-1] = i;

        int answer = 999_999_999;
        do {
            int sum = 0;
            boolean check = true;

            for(int i = 0; i < N-1; i++) { // 0 1 2 3 4 ... N-2
                int temp = W[city[i]][city[i+1]];
                if(temp == 0)
                    check = false;
                else
                    sum += W[city[i]][city[i+1]];
            }
            if(check && W[city[N-1]][1] != 0) {
                sum += W[city[N - 1]][1];
                answer = Math.min(answer, sum);
            }

        }while(next_permutation(city) && city[0] == 1);

        System.out.println(answer);

    }
}
