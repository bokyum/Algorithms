package bruteforce.done;

import java.io.*;
import java.util.*;

public class B1248 {
    static int N;
    static char[][] c;
    static int[] numArr;

    static boolean check(int index) {
        int sum = 0;
        for(int i=index; i>=0 ; i--) {
            sum += numArr[i];
            if (c[i][index] == '0') {
                if(sum != 0) return false;
            }
            else if(c[i][index] == '+') {
                if(sum <= 0) return false;
            }
            else if(c[i][index] == '-') {
                if(sum >= 0) return false;
            }
        }
        return true;
    }

    public static boolean solve(int index){
        if(index == N){
            return true;
        }

        if (c[index][index] == '0') {
            numArr[index] = 0;
            return check(index) && solve(index+1);
        }
        for(int i= 1; i <= 10; i++) {
            if(c[index][index] == '+')
                numArr[index] = i;
            else if(c[index][index] == '-')
                numArr[index] = -i;
            if(check(index) && solve(index+1))
                return true;
        }
        return false;
    }

    // - + 0 +
    //   + + +
    //     - -
    //       +
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        c = new char[N][N];
        numArr = new int[N];
        char[] pm = br.readLine().toCharArray();

        int index = 0;
        for(int i=0; i < N; i++) {
            for(int j=i; j < N; j++) {
                c[i][j] = pm[index++];
            }
        }
        solve(0);
        for(int num: numArr)
            System.out.println(num + " ");
        System.out.println();
    }
}
