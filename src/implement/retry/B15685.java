package implement.retry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class B15685 {
    static ArrayList<Integer> solve(int x, int y, int d, int g){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(d); // 0 1 2 3

        for(int i=0; i < g; i++) {
            ArrayList<Integer> reversedArr = new ArrayList<>(a);

            for(int j=reversedArr.size()-1; j >= 0; j--) {
                a.add((reversedArr.get(j) + 1) % 4);
            }

        }

        return a;

    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[][] cache = new boolean[101][101];
        for(int i=0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            int g = sc.nextInt();

            ArrayList<Integer> dirArr = solve(x,y,d, g);

            cache[x][y] = true;
            for(int j=0; j < dirArr.size(); j++) {
                int dir = dirArr.get(j);
                //System.out.println(dir);
                if(dir == 0) {
                    cache[x+1][y] = true;
                    x = x+1;
                }
                else if(dir == 1) {
                    cache[x][y-1] = true;
                    y = y-1;
                }
                else if(dir == 2) {
                    cache[x-1][y] = true;
                    x = x-1;
                }
                else if(dir == 3) {
                    cache[x][y+1] = true;
                    y = y+1;
                }
                else {
                    System.out.println("잘못된 입력이 되었습니다. ");
                }
            }
        }

        int ans =0 ;
        for(int i=0; i <= 99; i++) {
            for(int j=0; j <= 99 ; j++) {
                if(cache[i][j] && cache[i+1][j] && cache[i][j+1] && cache[i+1][j+1])
                    ans++;
            }
        }

        System.out.println(ans);

    }
}
