package bruteforce.done;

import java.util.*;
import java.io.*;

public class B6603 {


    static void solve(boolean[] check, int[] A,int index, int cnt) {
        if(cnt == 6){
            for(int i=0; i < check.length; i++ )
                if(check[i])
                    System.out.print(A[i] + " ");
            System.out.println();
            return;
        }
        if(index >= A.length)
            return;

        check[index] = true;
        solve(check, A, index+1, cnt+1);
        check[index] = false;
        solve(check, A, index+1, cnt);

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true) {

            int k = sc.nextInt();
            if(k==0)
                break;
            int[] A = new int[k];
            for(int i=0; i < k; i++)
                A[i] = sc.nextInt();

            solve(new boolean[k], A,0,0);
            System.out.println();
        }
    }
}
