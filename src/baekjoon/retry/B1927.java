package baekjoon.retry;

import java.io.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class B1927 {
    static int[] arr = new int[100005];
    static int size = 1;





    static void add(int input) {
        arr[size] = input;
        size++;
        int p = size-1;

        while(p > 1 && arr[p/2] > arr[p]){
            int temp = arr[p];
            arr[p] = arr[p/2];
            arr[p/2] = temp;
        }
    }
    static int delete() {
        if(size - 1 < 1)
            return 0;
        int deleteItem = arr[1];

        //arr.set(1, arr.get(arr.size()-1));
        arr[1] = arr[size-1];
        size--;
        int p = 1;
        while((p * 2) < size) {
            int min = arr[p*2];
            int minPos = p*2;

            if(((p*2 + 1) < size) && min > arr[p*2 + 1]){
                min = arr[p*2 + 1];
                minPos = p*2 + 1;
            }

            if(arr[p] < min)
                break;
            int temp = arr[p];
            arr[p] = arr[p*2 +1];
            arr[minPos] = temp;
            p = minPos;
        }
        return deleteItem;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        for(int i=0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                if(size == 1)
                    System.out.println(0);
                else
                    System.out.println(delete());
            }
            else
                add(input);
        }

        br.close();

    }
}
