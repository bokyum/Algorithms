package dongbinbook.greedy;

public class Prog42860 {
    public static int solution(String name) { // "A"로만 구성되게 만들면 성공
        final int[] ALPHA_NUM  = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1};
        int answer = 0;
        char[] alphaArr = name.toCharArray();
        name = name.replaceAll("[B-Z]", "A");


        int index = 0;
        boolean leftFirst = true;
        while(true) {
            if(new String(alphaArr).equals(name)) {
                break;
            }

            answer += ALPHA_NUM[(alphaArr[index] - 'A')];
            alphaArr[index] = 'A';
            if(new String(alphaArr).equals(name)) {
                break;
            }
            else
                answer++;

            int toRightIndex = index+1;
            int toLeftIndex = index-1;
            if(toLeftIndex < 0)
                toLeftIndex = alphaArr.length-1;
            if(toRightIndex > alphaArr.length-1)
                toRightIndex = 0;

            while(true) {
                if(alphaArr[toRightIndex] != 'A' || alphaArr[toLeftIndex] != 'A')
                    break;
                toRightIndex++; toLeftIndex--;
                answer++;
                if(toLeftIndex < 0)
                    toLeftIndex = alphaArr.length-1;
                if(toRightIndex > alphaArr.length-1)
                    toRightIndex = 0;
            }

            if(alphaArr[toRightIndex] == 'A')
                index = toLeftIndex;
            else
                index = toRightIndex;



        }

        return answer;
    }

    public int solution2(String name) {
        int answer = 0;
        int[] diff={0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1};
        for(char c:name.toCharArray())
            answer+=diff[c-'A'];

        int length=name.length();
        int min=length-1;

        for(int i=0;i<length;i++){
            int next=i+1;
            while(next<length && name.charAt(next)=='A'){
                next++;
            }
            min=Math.min(min,i+length-next+Math.min(i,length-next));
        }

        return answer+min;
    }

    public static void main(String[] args) {
        System.out.println(solution("ABAAABAAAAAAAAABA"));
    }
}
