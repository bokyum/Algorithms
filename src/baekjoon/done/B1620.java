package baekjoon.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        HashMap<String, Integer> hashMapStr = new HashMap<>();
        HashMap<Integer, String> hashMapInt = new HashMap<>();
        for(int i=1; i<=n; i++) {

            String str = br.readLine();
            hashMapStr.put(str, i);
            hashMapInt.put(i, str);

        }

        while(m-- > 0) {
            String str = br.readLine();
            char valueCheck = str.charAt(0);
            if('A' <= valueCheck && valueCheck <= 'Z') {
                System.out.println(hashMapStr.get(str));
            }
            else {
                System.out.println(hashMapInt.get(Integer.parseInt(str)));
            }
        }

    }
}
