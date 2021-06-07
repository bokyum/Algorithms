package bruteforce.retry;

import java.util.*;

public class B2529 {

    //3 5  7 6 4 3 2 1

    // 9 8 5 1 2 3 6 4
    public static boolean pre_permutation(int[] A) {
        int i = A.length - 1;

        while(i-1 >= 0 && A[i-1] <= A[i]) {
            i--;
        }

        if(i <= 0) {
            return false;
        }

        int j = A.length - 1;

        while(A[i-1] <= A[j]) {
            j--;
        }



        int temp = A[i-1];
        A[i-1] = A[j];
        A[j] = temp;

        int right = A.length-1;

        while(i < right) {
            temp = A[i];
            A[i] = A[right];
            A[right] = temp;
            i++; right--;
        }

        return true;

    }
    public static boolean next_permutation(int[] A) {
        int i = A.length - 1;

        while(i-1 >= 0 && A[i-1] >= A[i]) {
            i--;
        }

        if(i <= 0) {
            return false;
        }

        int j = A.length-1;

        while(A[i-1] >= A[j]) {
            j--;
        }


        int temp = A[i-1];
        A[i-1] = A[j];
        A[j] = temp;

        int right = A.length-1;

        while(i < right) {
            temp = A[i];
            A[i] = A[right];
            A[right] = temp;
            i++; right--;
        }

        return true;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] B = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        char[] input = new char[N];

        for(int i=0; i < N; i++)
            input[i] = sc.next().charAt(0);

        ArrayList<String> answer = new ArrayList<>();
        do {

            boolean ok = true;
            for(int i=0; i < N; i++) {
                if(input[i] == '<') {
                    if(A[i] >= A[i+1]) {
                        ok = false;
                        break;
                    }
                }
                else if(input[i] == '>') {
                    if(A[i] <= A[i+1]){
                        ok=false;
                        break;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();

            for(int i=0; i <= N; i++)
                sb.append(A[i]+"");
            if(ok) {
                answer.add(sb.toString());
                break;
            }
        }while(next_permutation(A));

        do {
            boolean ok = true;
            for(int i=0; i < N; i++) {
                if(input[i] == '<') {
                    if(B[i] >= B[i+1]) {
                        ok = false;
                        break;
                    }
                }
                else if(input[i] == '>') {
                    if(B[i] <= B[i+1]){
                        ok=false;
                        break;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();

            for(int i=0; i <= N; i++)
                sb.append(B[i]+"");
            if(ok) {
                answer.add(sb.toString());
                break;
            }
        }while(pre_permutation(B));

        System.out.println(answer.get(answer.size()-1));
        System.out.println(answer.get(0));
    }



}
