package dongbinbook.greedy;

import java.util.Scanner;

public class G314 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] arr = new int[str.length()];

        int countZero = 0;
        int countOne =0;
        boolean first = true;
        boolean check = false;
        for(int i=0; i < str.length(); i++) {
            if(str.charAt(i) == '0') {
                if(first || check) {
                    countZero++;
                    check = false;
                }
                arr[i] = Integer.parseInt(str.charAt(i) + "");
            } else {
                if(first || !check) {
                    countOne++;
                    check = true;
                }
                arr[i] = Integer.parseInt(str.charAt(i) + "");
            }
            first = false;
        }
        // 0000110000
        System.out.println(Math.min(countOne, countZero));
    }
}
