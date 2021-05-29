package bruteforce.done;

import java.util.Scanner;

/*
일부 숫자가 고장남
--> 가장 가까운 숫자로 이동
--> + / - 몇번 가능한지 계산
--> ---+++--- 식은 무의미함

0 ~ 500,000 이동하려는 채널
--> 0 ~ 999,999 중 하나를 이동하여 목적지까지 이동
--> + / -로 이동

0. + / - 로만 이동한 수로 초기화
1. 0에서부터 999,999까지 이동
2. 입력한 수가 허용 가능한 숫자인지(불가능한 수를 저장하는 배열 필요)
3. 수가 몇개의 수로 이루어진지
4. + / - 가 몇번 필요한지

* */
public class B1107 {
    static int N, M;
    static boolean[] impossible = new boolean[10];

    public static int solve(int i) {

        int pmNum = Math.abs(N-i);
        int len = 0;

        while(true) {
            int last = i % 10; // 맨뒤 숫자를 비교
            len++; // 개수 하나씩 체크 됨
            if(impossible[last])
                return -1;
            i /= 10;
            if(i==0)
                break;
        }

        return len+pmNum;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for(int i=0; i < M; i++) {
            impossible[sc.nextInt()] = true;
        }

        int answer = Math.abs(100-N); // 초기화를 그냥 + / - 누를때로 지정
        for(int i=0; i < 1000_000; i++) {
            int temp = solve(i); // 다음 이동해서 + / - 누를때를 계산
            if(temp != -1)
                answer = Math.min(answer, temp);
        }

        System.out.println(answer);
    }
}
