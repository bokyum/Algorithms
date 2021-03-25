package jongmanbook.Chap08;

import java.util.Scanner;

public class WildCard {



    static boolean solve(String pattern, String fileName) {
        int wp = 0;
        int np = 0;
        int patternLength = pattern.length();
        int fileNameLength = fileName.length();

        while(wp < patternLength && np < fileNameLength) {
            if(pattern.charAt(wp) != '*' && pattern.charAt(wp) != '?' ) {
                if(pattern.charAt(wp) == fileName.charAt(np)) {
                    wp++;
                    np++;
                    continue;
                }
                else
                    return false;
            }
            else if(pattern.charAt(wp) == '?'){
                wp++;
                np++;
            }
            else if(pattern.charAt(wp) == '*'){
                char checkChar = '*';
                if(wp+1 < patternLength)
                    checkChar = pattern.charAt(++wp);
                while(np < fileNameLength && checkChar != fileName.charAt(np))
                    np++;
            }

        }
        while(wp == '*')
            wp++;
        if(wp == patternLength && np == fileNameLength)
            return true;
        else
            return false;
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        sc.nextLine();// 버퍼 비우기
        while(C-- >= 0) {
            String pattern = sc.nextLine();
            int n = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            String[] fileNames = new String[n];
            for(int i=0; i < n; i++)
                fileNames[i] = sc.nextLine();

            for(int i=0; i < n; i++)
                System.out.println(solve(pattern, fileNames[i]));

        }

    }
}
