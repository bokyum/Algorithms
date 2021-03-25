package jongmanbook.Chap08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PI {
    static final int INF = 987654321;
    static int N;
    static String inputStr;
    static int[] cache;


    //L == (3, 4, 5)에 값을 갖음 --> 숫자를 3 ~ 5에 문자로 나눌수 있기 때문
    //memorize(begin) = min(memorize(begin+L) +  solve(arr[begin ~ bigin+L]])
    static int classify(int left, int right) {
        String subString = inputStr.substring(left, right);

        // case1. 모든 숫자가 같을 때
        boolean sameNum = true;
        for(int i=1; i < subString.length(); i++)
            if(subString.charAt(0) != subString.charAt(i))
                sameNum = false;
        if(sameNum) return 1;

        //등차수열인지 검사
        boolean progressive = true;
        for(int i=0; i < subString.length()-1; i++)
            if(subString.charAt(i+1) - subString.charAt(i) !=
                            subString.charAt(1) - subString.charAt(0))
                progressive = false;
        if(progressive && (Math.abs(subString.charAt(1) - subString.charAt(0)) == 1))
            return 2;
        // 두 수가 번갈아 나타나는지 확인
        boolean alternating = true;
        for(int i=0; i < subString.length(); i++)
            if(subString.charAt(i) != subString.charAt(i%2))
                alternating = false;
        if(alternating) return 4;
        if(progressive) return 5;
        return 10;
    }

    static int solve(int begin) {
        //기저 사례: 수열의 끝에 도달했을 경우
        if(begin == inputStr.length()) return 0;
        // 메모제이션
        if(cache[begin] != -1) return cache[begin];
        cache[begin] = INF;
        for(int L = 3; L <= 5; L++)
            if(begin + L <= inputStr.length())
                cache[begin] = Math.min(cache[begin],
                        solve(begin + L) + classify(begin, begin + L) );
        return cache[begin];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        while(N-- > 0) {
            inputStr = br.readLine();
            cache = new int[inputStr.length()];
            for(int i=0; i < cache.length; i++)
                cache[i] = -1;
            System.out.println(solve(0));
        }
    }
}
