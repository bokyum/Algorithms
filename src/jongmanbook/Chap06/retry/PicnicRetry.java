package jongmanbook.Chap06.retry;

import java.util.Scanner;
// bufferredear로 받으니까 parsing 시간이 너무 오래걸림 --> 런타임 오류 발생
public class PicnicRetry {
    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static boolean[][] fairsOfBF;


    static void solve() throws NumberFormatException{
        int C = sc.nextInt();

        while(C-- > 0) {
            N = sc.nextInt(); M = sc.nextInt();

            fairsOfBF = new boolean[N][N];
            boolean[] check = new boolean[N];

            for(int i=0; i < M; i++){
                int temp1 = sc.nextInt(); int temp2 = sc.nextInt();
                fairsOfBF[temp1][temp2] = true;
                fairsOfBF[temp2][temp1] = true;
            }

            System.out.println(checkMatching(check));
        }

    }

    static int checkMatching(boolean[] check){
        int firstFree = -1;
        for(int i=0; i < N; i++){
            if(!check[i]) {
                firstFree = i;
                break;
            }
        }
        if(firstFree == -1)
            return 1;

        int ret = 0;
        for(int pairWith=firstFree+1; pairWith < N; pairWith++) {
            if(!check[pairWith] && fairsOfBF[firstFree][pairWith] ){
                check[firstFree] = check[pairWith] = true;
                ret += checkMatching(check);
                check[firstFree] = check[pairWith] = false;

            }
        }
        return ret;
    }

    public static void main(String[] args){
        solve();
    }
}
