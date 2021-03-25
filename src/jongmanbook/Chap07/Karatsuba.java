package jongmanbook.Chap07;

import java.util.*;

public class Karatsuba {
    public static void main(String[] args) {
        String test1_a = "123";
        String test1_b = "456";
        String test2_a = "123456789123456789123456789123456789123456789123456789";
        String test2_b = "123456789123456789123456789123456789123456789123456789";

        List<Integer> list1_a = fromString(test1_a);
        List<Integer> list1_b = fromString(test1_b);
        List<Integer> list2_a = fromString(test2_a);
        List<Integer> list2_b = fromString(test2_b);

        List<Integer> answer1 = karatsuba(list1_a, list1_b);
        List<Integer> answer2 = karatsuba(list2_a, list2_b);

        String print1 = toString(answer1);
        String print2 = toString(answer2);

        System.out.println(print1);
        System.out.println(print2);
    }
     //코드 7.3 두 큰 수를 구하는 O(n^2) 시간 알고리즘 // num[]의 자릿수 올림을 처리
     static List<Integer> normalize(List<Integer> num) {
         num.add(0);
            // 자릿수 올림 처리
         for (int i = 0 ; i+1 < num.size(); ++i) {
             if(num.get(i) < 0) {
                 int borrow = (Math.abs(num.get(i)) + 9) / 10;
                 num.set(i+1, num.get(i+1) - borrow);
                 num.set(i, num.get(i) + borrow*10);
             } else {
                 num.set(i+1, num.get(i+1) + (num.get(i) / 10));
                 num.set(i, num.get(i) % 10);
             }
         }
         while(num.size() > 1 && num.get(num.size()-1) == 0)
             num.remove(num.size()-1); return num; }
             // 두 긴 자연수의 곱을 반환한다.
    // 각 배열에는 각 수의자릿수가 1의 자리에서부터 시작해 저장되어 있다.
    // 예: multiply([3, 2, 1], [6, 5, 4]) = 123*456 = 56088 = [8, 8, 0, 6, 5]
     static List<Integer> multiply(List<Integer> a, List<Integer> b) {
         List<Integer> c = new ArrayList<Integer>();
         for (int i = 0; i < a.size() + b.size(); i++) {
             c.add(0);
         }
         for (int i = 0; i < a.size(); ++i) {
             for (int j = 0; j < b.size(); ++j) {
                 c.set(i+j, c.get(i+j) + a.get(i)*b.get(j));
             }
         }
         c = normalize(c);
         return c;
     }

     // a += b * (10^k);를 구현한다.
    static void addTo(List<Integer> a, List<Integer> b, int k) {
        int aLen = a.size(), bLen = b.size();
        int bIdx = 0;
        int totalLength = bLen + k;

        for(int i = k; i < aLen; i++)
            a.set(i, a.get(i) + b.get(bIdx++));

        if(totalLength > aLen)
            while(bIdx < bLen)
                a.add(b.get(bIdx++));
        normalize(a);
    }
    // a -= b;를 구현한다. a >= b를 가정
    static void subFrom(List<Integer> a, List<Integer> b){
        int aLen = a.size(), bLen = b.size();
        if(aLen < bLen) throw new RuntimeException("a길이가 b길이보다 더 작습니다.");

        boolean flag = false;
        for(int i=0; i<bLen; i++) {
            int temp = a.get(i) - b.get(i);
            if(flag)
                --temp;

            if(temp < 0) {
                temp = 10 + temp;
                flag = true;
            } else
                flag = false;

            a.set(i, temp);
        }
        normalize(a);
    }
    // 두 긴 정수의 곱을 반환
    static List<Integer> karatsuba(List<Integer> a, List<Integer> b) {
         int an = a.size(), bn = b.size();
         // a가 b보다 짧을 경우 둘을 바꾼다
        if (an < bn)
            karatsuba(b, a);
        // 기저 사례: a나 b가 비어 있는 경우
        if(an == 0 || bn == 0) return new ArrayList<>();
        // 기저 사례: a가 비교적 짧은 경우 O(n^2) 곱셈으로 변경한다.
        if(an <= 50) return multiply(a, b);
        int half = an / 2;
        // a와 b를 밑에서 half자리와 나머지로 분리한다.
        List<Integer> a0 = new ArrayList<>(a.subList(0, half));
        List<Integer> a1 = new ArrayList<>(a.subList(half, a.size()));
        List<Integer> b0 = new ArrayList<>(b.subList(0, Math.min(b.size(), half)));
        List<Integer> b1 = new ArrayList<>(b.subList(Math.min(b.size(), half), b.size()));

        // z2 = a1 * b1
        List<Integer> z2 = karatsuba(a1, b1);
        // z0 = a0 * b0
        List<Integer> z0 = karatsuba(a0, b0);
        // a0 = a0 + a1; b0 = b0 + b1;
        addTo(a0, a1, 0); addTo(b0, b1, 0);
        // z1 = (a0 * b0) - z0 - z2;
        List<Integer> z1 = karatsuba(a0, b0);
        subFrom(z1, z0);
        subFrom(z1, z2);
        //ret = z0 + z1 * 10^half + z2*10^(half*2)
        List<Integer> ret = new ArrayList<>();
        addTo(ret, z0, 0);
        addTo(ret, z1, half);
        addTo(ret, z2, half+half);
        return ret;

    }

    static String toString(List<Integer> a){
        String ret = "";
        //앞의 0 없애기
        while(a.size() > 1 && a.get(a.size()-1)==0)
            a.remove(a.size()-1);
        for(int i =0; i < a.size(); i++)
            ret += (char)('0' + a.get(a.size() - 1 - i));

        return ret;
    }

    static List<Integer> fromString(String s){
        List<Integer> ret = new ArrayList<>();
        for(int i=0; i < s.length(); i++)
            ret.add(s.charAt(i) - '0');

        Collections.reverse(ret);

        return ret;
    }
}
