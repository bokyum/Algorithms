package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
0 1 2 3 4 5 6 7 8 9
9 8 7 6 5 4 3 2 1 0
*/
public class B7662 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            int M = Integer.parseInt(br.readLine());
            TreeMap<Integer,Integer> tq = new TreeMap<>();

            for(int i=0; i < M; i++) {
                String[] strArr = br.readLine().split(" ");
                String str = strArr[0];
                int inputNum = Integer.parseInt(strArr[1]);
                if(str.equals("I")) {
                    tq.put(inputNum, tq.getOrDefault(inputNum, 0) + 1);

                }
                else {
                    if (tq.isEmpty())
                        continue;
                    if(inputNum == -1) {
                        int min = tq.firstKey();

                        if(tq.get(min) == 1)
                            tq.remove(min);
                        else
                            tq.replace(min, tq.get(min), tq.get(min) -1 );
                    }
                    else {
                        int max = tq.lastKey();

                        if(tq.get(max) == 1)
                            tq.remove(max);
                        else
                            tq.replace(max, tq.get(max), tq.get(max) -1);
                    }

                }

            }
            if(tq.isEmpty())
                System.out.println("EMPTY");
            else {
                System.out.println(tq.lastKey() + " " + tq.firstKey());
            }

        }
    }
}
