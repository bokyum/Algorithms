package jongmanbook.Chap03;

public class FloatingPoint {

    //[1,n] 범위의 자연수x에 대해 x*1.0/x == 1인 x의 수를 센다
    static int countObvious(int n) {
        int same = 0;
        for(int x = 1; x <= n; ++x) {
            double y = 1.0 / x;
            //if(y * x == 1.0)
            //if(absoluteEqual(y*x, 1.0))
            //if(relativeError(y*x, 1.0))
            if(doubleEqual(y*x, 1.0))
                ++same;
        }
        return same;
    }
    //두 실수 a,b가 같은지 판단하기 위해 두 실수의 차의 절대 값이 미리 정해둔 오차 한도 1e-10보다 작은지를 확인
    //이 방법도 (10^20 / x) * x와 같은 식은 해결하지 못
    static boolean absoluteEqual(double a, double b){
        return Math.abs(a - b) < 1e-10;
    }

/*relativeError(a, b) = ( | a - b |) / max(|a|, |b|)
비교하는 숫자들의 크기에 비례하여 오차를 정하는 방식
두 숫자의 크기에 비해 그 차이가 작다면 두 수가 같다고 판정하는 식
a와 b의 오차가 더 큰 수의 0.000001%이하이면 true를 반환한다.
이 방식은 큰 수를 비교할 때는 별 문제가 없지만 매우 작은 숫자들을 비교하려 할 때는 문제가 됨
ex) x = 0.00000000001  ==> relativeError(0, x) = x/x = 1
*/
    static boolean relativeError(double a, double b) {
        return Math.abs(a - b) <= 1e-8 * Math.max(Math.abs(a), Math.abs(b));
    }

    //절대 오차와 상대 오차를 모두 이용해서 두 수가 같은지 판정한다.
    static boolean doubleEqual(double a, double b) {
        double diff = Math.abs(a - b);
        if(diff < 1e-10) return true;
        return diff <= 1e-8 * Math.max(Math.abs(a), Math.abs(b));

    }
    public static void main(String[] args) {
        System.out.println(countObvious(50));
    }
}
