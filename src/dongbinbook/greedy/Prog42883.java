package dongbinbook.greedy;

import java.util.Stack;

public class Prog42883 {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

    public String solution2(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        for (int i = 0; i+1 < sb.length() && k>0; i++) {
            if(sb.charAt(i) < sb.charAt(i+1)) {
                sb.deleteCharAt(i);
                i=-1;
                k--;
            }
        }
        if(k!=0)
            sb.delete(sb.length()-k, sb.length());
        return sb.toString();
    }

    public String solution3(String number, int k) {

        StringBuilder sb = new StringBuilder(number);
        int len = sb.length();
        int first=0, second=0;
        int cnt=0;

        while(k>0) {
            if(cnt==len-1) {
                return sb.substring(0,len-k);
            }
            else {
                cnt++;
                first = (int)sb.charAt(cnt-1)-'0';
                second = (int)sb.charAt(cnt)-'0';
                if(first < second) {
                    sb.delete(cnt-1, cnt);
                    cnt=0;
                    len = sb.length();
                    k--;
                }

            }
        }
        return sb.toString();

    }


}
