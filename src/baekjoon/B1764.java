package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        HashSet<String> nSet = new HashSet<>();
        List<String> mSet = new ArrayList<>();

        for(int i=0; i < N; i++)
            nSet.add(br.readLine());


        for(int i=0; i < M; i++) {
            String s = br.readLine();
            if(nSet.contains(s))
                mSet.add(s);

        }
        System.out.println(mSet.size());
        Collections.sort(mSet);
        for(String s: mSet)
            System.out.println(s);

        br.close();
    }
}
