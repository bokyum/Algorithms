package implement.retry;

import java.io.*;
import java.util.*;
public class B2290 {
    static int[][] numView = {
            {1, 1, 1, 0, 1, 1, 1}, //0
            {0, 0, 1, 0, 0, 1, 0}, //1
            {1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 0, 1, 1}, // 3
            {0, 1, 1, 1, 0, 1, 0}, // 4
            {1, 1, 0, 1, 0, 1, 1}, // 5
            {1, 1, 0, 1, 1, 1, 1}, // 6
            {1, 0, 1, 0, 0, 1, 0}, // 7
            {1, 1, 1, 1, 1, 1, 1}, // 8
            {1, 1, 1, 1, 0, 1, 1}, // 9
    };

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        String num = st.nextToken();

        for(int i=0; i <= 6;) {
            if(i == 0 || i == 3 || i == 6) {
                for (int j = 0; j < num.length(); j++) {
                    int now = num.charAt(j) - '0';

                    System.out.print(" ");
                    if (numView[now][i] == 1) {
                        for (int k = 0; k < s; k++)
                            System.out.print("-");
                    } else {
                        for (int k = 0; k < s; k++)
                            System.out.print(" ");
                    }
                    System.out.print("  ");


                }
                System.out.println();
                i++;
            }
            else {
                for(int q=0; q < s; q++) {
                    for (int j = 0; j < num.length(); j++) {
                        int now = num.charAt(j) - '0';
                        if (numView[now][i] == 1) {
                            System.out.print("|");
                            for (int k = 0; k < s; k++)
                                System.out.print(" ");
                        }
                        if(numView[now][i] == 0) {
                            System.out.print(" ");
                            for (int k = 0; k < s; k++)
                                System.out.print(" ");
                        }
                        if (numView[now][i + 1] == 1) {
                            System.out.print("|");
                        }
                        if(numView[now][i+1] == 0)
                            System.out.print(" ");
                        System.out.print(" ");
                    }
                    System.out.println();
                }
                //System.out.println();
                i+=2;
            }

        }
    }
}
