package implement.done;

import java.util.Scanner;

public class B14891 {
    static int T;
    static int[][] arr; //= new int[8][8];
    static int[][] beforState;// = new int[8][8];

    static void turnLeft(int num) {

        int temp = arr[num][0];
        for(int i=0; i < 7; i++) {
            arr[num][i] = arr[num][i+1];
        }
        arr[num][7] = temp;
    }

    static void turnRight(int num) {
        int temp = arr[num][7];
        for(int i=7; i > 0; i--) {
            arr[num][i] = arr[num][i-1];
        }
        arr[num][0] = temp;
    }

    static void turnObj(int num, int direct) {
        if(direct == -1) {
            turnLeft(num);
        }
        else if (direct == 1){
            turnRight(num);
        }
    }

    static int turnObjLeft(int num, int direct) {
        int left = num;
        if(left >= 0) {
            if(beforState[left+1][6] != beforState[left][2] && direct == -1) {
                turnRight(left);
                return direct * -1;
            }
            else if(beforState[left+1][6] != beforState[left][2] && direct == 1){
                turnLeft(left);
                return direct * -1;
            }
        }

        return direct;
    }
    public static int turnObjRight(int num, int direct) {
        int right = num;
        if (right < T) {
            if(beforState[right-1][2] != beforState[right][6] && direct == -1) {
                turnRight(right);
                return direct * -1;
            }
            else if (beforState[right-1][2] != beforState[right][6] && direct == 1){
                turnLeft(right);
                return direct * -1;
            }


        }

        return direct;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        sc.nextLine();
        arr = new int[T][8];
        beforState = new int[T][8];

        for(int i=0; i < T; i++) {
            String s = sc.nextLine();
            for(int j=0; j < 8; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        int K = sc.nextInt();

        for(int i=0; i < K; i++) {
            int num = sc.nextInt();
            int dir = sc.nextInt();
            for(int k = 0; k < T; k++) {
                for(int q=0; q < 8; q++) {
                    beforState[k][q] = arr[k][q];
                }
            }
            turnObj(num-1, dir);
            int rightDir = dir;
            int index = 1;
            while(true) {
                int compValue = turnObjLeft(num-1-index, dir);
                if(compValue == dir){
                    break;
                }
                else
                    dir = compValue;
                index++;

            }
            index = 0;
            while(true) {
                int compValue = turnObjRight(num + index, rightDir);
                if(compValue == rightDir){
                    break;
                }
                else
                    rightDir = compValue;

                index++;

            }
        }

        int ans = 0;
        for(int i=0; i < T; i++){
            if(arr[i][0] == 1)
                ans++;
        }

        System.out.println(ans);

    }
}
