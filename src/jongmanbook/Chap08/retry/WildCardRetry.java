package jongmanbook.Chap08.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class WildCardRetry {

/*    //완전 탐색 알고리즘
    static boolean bruteForseMatch(String w, String s) {
        //w[pos]와 s[pos]를 맞춰나간다.
        int pos = 0;
        while(pos < w.length() && pos < s.length() &&
                (w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos)))
            ++pos;
        // 더이상 대응할 수 없으면 왜 while문이 끝났는지 확인한다.
        //2.패턴 끝에 도달해서 끝난 경우: 문자열도 끝났어야 대응됨
        if(pos == w.length())
            return pos == s.length();
        if(w.charAt(pos) == '*')
            for(int skip = 0; pos+skip <= s.length(); skip++)
                if(bruteForseMatch(w.substring(pos+1), s.substring(pos+skip)))
                    return true;
        //이 외에 경우에는 모두 대응되지 않는다.
        return false;
    }*/
    static String wildCardPattern;
    static String testName;
    //-1은 아직 답이 계산되지 않았음을 의미한다.
    // 1은 해당 입력들이 서로 대응됨을 의미한다.
    // 0은 해당 입력들이 서로 대응되지 않음을 의미한다.
    static int[][] cache = new int[101][101];

    static int matchMemorized(int w, int s) {
        //메모이제이션

        if (cache[w][s] != -1) return cache[w][s];
        //wildCardPattern[w]와 testName[s]를 맞춰감
        while (w < wildCardPattern.length() && s < testName.length()
                && (wildCardPattern.charAt(w) == '?' || wildCardPattern.charAt(w) == testName.charAt(s))){
            ++w; ++s;
        }
        // 더이상 대응할 수 없으면 왜 while문이 끝났는지 확인한다.
        // 2. 패턴 끝에 도달해서 끝난 경우: 문자열도 끝났어야
        if(w == wildCardPattern.length()){
            if(s == testName.length())
                return cache[w][s] = 1;
            else
                return cache[w][s] = 0;
            }
        // 4. *를 만나서 끝난 경우: *에 몇 글자를 대응해야 할지 재귀 호출하면서 확인한다.
        if(wildCardPattern.charAt(w) == '*')
            for(int skip = 0; skip+s <= testName.length(); ++skip)
                if(matchMemorized(w+1, s+skip) == 1)
                    return cache[w][s] = 1;

        return cache[w][s] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();
        while(C-- > 0){
            wildCardPattern = br.readLine();
            int N = sc.nextInt();

            for(int i=0; i < 101; i++)
                for(int j=0; j < 101; j++)
                    cache[i][j] = -1; // cache 초기화

            for(int i=0; i < N; i++) {
                testName = br.readLine();
                for(int j=0; j < 101; j++)
                    for(int k=0; k < 101; k++)
                        cache[j][k] = -1; // cache 초기화
                if(matchMemorized(0, 0) == 1)
                    System.out.println(testName);
            }

        }

    }
}

/*
2
he?p
3
help
heap
helpp
*p*
3
help
papa
hello*/
