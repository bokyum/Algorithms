import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

public class Team {


    static int count(String q) {
        int ans = 0;
        for(int i=0; i < q.length(); i++){
            if(q.charAt(i) == 'a')
                ans++;
        }
        return ans;
    }

    public int solution(String S) {
        // write your code in Java SE 8
        // b a b a a
        //   i   j
        int len = S.length();
        int ans =0;
        for(int i= 1; i < len - 1; i++ )
            for(int j=i+1; j < len; j++) {
                String q = S.substring(0, i);
                String w = S.substring(i, j);
                String e = S.substring(j, len);
                if(q.length() ==0 || w.length() == 0 || e.length() == 0)
                    continue;
                else {
                    int r = count(q);
                    int t = count(w);
                    int y = count(e);
                    if(r == t && t == y)
                        ans++;

                }
            }

        return ans;
    }

    public static void main(String[] args) {
        Team t = new Team();
        System.out.println(t.solution("ababa"));

    }
}
