package baekjoon.done;

import java.io.*;


public class B1003 {

    static int[] numOfZero;
    static int[] numOfOne;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        int[] n = new int[T];
        for(int i=0; i < T; i++)
            n[i] = Integer.parseInt(br.readLine());

        int maxValue = n[0];
        for(int i=1; i < T; i++)
            maxValue = Math.max(maxValue, n[i]);

        numOfZero = new int[maxValue+2];
        numOfOne = new int[maxValue+2];
        numOfZero[0] = 1; numOfZero[1] = 0;
        numOfOne[0] = 0; numOfOne[1] = 1;

        if(maxValue == 0 || maxValue == 1) {
            for(int a: n) {
                bw.write(numOfZero[a] + " " +numOfOne[a]);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            br.close();
            return;

        }

        for(int i=2; i < maxValue+1; i++) {
            numOfZero[i] = numOfZero[i-1] + numOfZero[i-2];
            numOfOne[i] = numOfOne[i-1] + numOfOne[i-2];
        }

        for(int a: n) {
            bw.write(numOfZero[a] + " " +numOfOne[a]);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

        return;




    }
}
