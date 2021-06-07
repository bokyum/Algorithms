package bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B14888 {

    // 1 2 4 9 8 7 5 3
    static boolean next_permutation(ArrayList<Integer> A) {
        int i = A.size() - 1;

        while(i > 0 && A.get(i-1) >= A.get(i))
            i--;

        if(i <= 0)
            return false;

        int j = A.size() - 1;
        while(A.get(i-1) >= A.get(j))
            j--;

        int temp = A.get(j);
        A.set(j, A.get(i-1));
        A.set(i-1, temp);

        int right = A.size()-1;

        while(i < right) {
            temp = A.get(i);
            A.set(i, A.get(right));
            A.set(right, temp);
            i++; right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        ArrayList<Integer> operatorList = new ArrayList<>();

        for(int i=0; i < N; i++)
            A[i] = sc.nextInt();
        for(int i=1; i <= 4; i++) {
            int temp = sc.nextInt();
            for(int j=0; j < temp; j++)
                operatorList.add(i);
        }



        int min = 999_999_999;
        int max = -999_999_999;
        do {
            int temp = A[0];
            for(int i=0; i < operatorList.size(); i++) {
                int op = operatorList.get(i);
                if(op == 1)
                    temp += A[i+1];
                else if(op == 2)
                    temp -=  A[i+1];
                else if(op == 3)
                    temp *= A[i+1];
                else
                    temp /= A[i+1];
            }
            if(temp < min)
                min = temp;
            if(temp > max)
                max = temp;
        }while(next_permutation(operatorList));

        System.out.println(max);
        System.out.println(min);
    }


}
