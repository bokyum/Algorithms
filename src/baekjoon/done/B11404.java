package baekjoon.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11404 {
    static int n, m;
    static int[][] city;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        city = new int[n][n];

        for(int i=0; i < n; i++) {
            Arrays.fill(city[i], 999_999_999);
            city[i][i] = 0;
        }

        for(int i=0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            if(city[from-1][to-1] != 999_999_999)
                city[from-1][to-1] = Math.min(city[from-1][to-1], value);
            else
                city[from-1][to-1] = value;
        }

        for(int k=0; k<n; k++)
            for(int i=0; i<n; i++)
                for(int j=0; j<n; j++) {
                    if(i!=j)
                        city[i][j] = Math.min(city[i][j], city[i][k] + city[k][j]);
                }
        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                if(city[i][j] == 999_999_999)
                    city[i][j] = 0;
                if(j == n-1) {
                    System.out.println(city[i][j]);
                }
                else
                    System.out.print(city[i][j] + " ");
            }
        }

        br.close();

    }

}
