package dongbinbook.greedy;

import java.util.Scanner;

public class G313 {
    static int[] arr;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        arr = new int[str.length()];

        for(int i=0; i < str.length(); i++) {
            arr[i] = Integer.parseInt(str.charAt(i) + "");
        }
        result = arr[0];
        for(int i=1; i < arr.length; i++) {
            if(result == 0 || arr[i] == 0) {
                result += arr[i];
            }
            else {
                result *= arr[i];
            }
        }

        System.out.println(result);

    }
}
