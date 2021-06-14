package bruteforce;

import java.util.*;
import java.io.*;

public class B2143 {
    static int[] A;
    static int[] B;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i < n; i++)
            A[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        B = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < m; i++)
            B[i] = Integer.parseInt(st.nextToken());

       ArrayList<Integer> sumA = new ArrayList<>();

       ArrayList<Integer> sumB = new ArrayList<>();


       for(int i=0; i < n; i++) {
           int sum = 0;
           for(int j=i; j < n; j++) {
               sum += A[j];
               sumA.add(sum);
           }
       }

       for(int i=0; i < m; i++) {
           int sum = 0;
           for(int j=i; j < m; j++) {
               sum += B[j];
               sumB.add(sum);
           }
       }

       HashMap<Integer, Integer> map = new HashMap<>();
       for(int x: sumB) {
           if(map.containsKey(x)) {
               int temp = map.get(x);
               map.put(x, temp+1);
           }else {
               map.put(x, 1);
           }
       }
       long ans = 0;
       for(int x: sumA) {
           if (map.containsKey(T - x)) {
               ans += map.get(T - x);
           }
       }
        System.out.println(ans);

    }
}
