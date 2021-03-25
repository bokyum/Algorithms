package jongmanbook.Chap06.retry;

import java.io.*;

public class BoggleRetry {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int C;
    static int N;
    static String[] gameBoard;
    static String[] testWord;
    static boolean[] answer;
    static int dx[] = {-1, -1, -1, 1, 1, 1, 0, 0};
    static int dy[] = {-1, 0, 1, -1, 0, 1, -1, 1};
    static void testStart(){
        C = inputInteger();

        while(C-- > 0) {
            gameBoard = inputString(5);
            N = inputInteger();
            testWord = inputString(N);
            answer = new boolean[N];
            iterateRange();
            for(boolean a: answer)
                System.out.println(a);
        }
    }

    static void iterateRange(){
        for(int i=0; i < N; i++) {
            for(int j=0; j < 5; j++) {
                for(int k=0; k < 5; k++) {
                    if (checkAnswer(testWord[i], j, k, 0))
                        answer[i] = true;
                }
            }
        }
    }

    static boolean checkAnswer(String str, int y, int x, int index) {
        if( y < 0 || y >= 5 || x < 0 || x >= 5)
            return false;

        if((gameBoard[y].charAt(x)) != str.charAt(index))
            return false;

        if(str.length()-1 == index)
            return true;

        for (int direction = 0; direction < 8; direction++) {
            int nextY = y + dy[direction];
            int nextX = x + dx[direction];
            if (checkAnswer(str, nextY, nextX, index + 1)) {
                return true;
            }
        }

        return false;
    }

    static String[] inputString(int num) {
        String[] arr = new String[num];
        for(int i=0; i < num; i++) {
            try {
                arr[i] = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
        return arr;
    }

    static int inputInteger() {
        int temp = -1;
        try {
            temp = Integer.parseInt(br.readLine());
        } catch (IOException e) { // throws IOException으로 간단히 처리 가능
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return temp;
    }

    public static void main(String[] args) {
        testStart();
    }

}
/*
* 1
URLPM
XPRET
GIAET
XTNZY
XOQRS
6
PRETTY
GIRL
REPEAT
KARA
PANDORA
GIAZAPX*/




