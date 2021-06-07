package bruteforce.done;

import java.util.*;

public class B1339 {

    // 1 3 5 9 8 7 6 4 2

    public static boolean next_permutation(int[] A) {
        int i = A.length-1;

        while(i > 0 && A[i-1] >= A[i]) {
            i--;
        }

        if(i <= 0)
            return false;

        int j = A.length-1;
        while (A[i - 1] >= A[j]) {
            j--;
        }

        int temp = A[j];
        A[j] = A[i-1];
        A[i-1] = temp;

        int right = A.length-1;
        while(i < right) {
            temp = A[i];
            A[i] = A[right];
            A[right] = temp;
            i++; right--;
        }
        return true;
    }

    static int solve(String nArr, int[] value_set, ArrayList<Character> alpha_set) {
        int ans = 0;
        int mul = 1;

        for(int i=nArr.length()-1; i >= 0; i--) {
            ans += value_set[alpha_set.indexOf(nArr.charAt(i))] * mul;
            mul *= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] value_set = new int[10];
        ArrayList<Character> alpha_set = new ArrayList<>();
        String[] nArr;
        for(int i=0; i < 10; i++)
            value_set[i] = i;

        int N = sc.nextInt();
        sc.nextLine();
        nArr = new String[N];
        for(int i=0; i < N; i++) {
            nArr[i] = sc.nextLine();
        }

        for(int i=0; i < N; i++) {
            for(int j=0; j < nArr[i].length(); j++) {
                if(!alpha_set.contains(nArr[i].charAt(j)))
                    alpha_set.add(nArr[i].charAt(j));
            }
        }
        Collections.sort(alpha_set);
        int maxNum = 0;
        do {
            int temp = 0;
            for(int i=0; i < N; i++)
                temp += solve(nArr[i], value_set, alpha_set);
            if(maxNum < temp)
                maxNum = temp;
        }while(next_permutation(value_set));


        System.out.println(maxNum);
    }
}
