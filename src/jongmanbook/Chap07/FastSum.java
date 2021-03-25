package jongmanbook.Chap07;

public class FastSum {

    static int fastSum(int n) {
        if(n == 1) return 1;
        if(n % 2 == 1) return n + fastSum(n-1);
        return (n/2)*(n/2) + 2 * fastSum(n/2);
    }

    public static void main(String[] args) {
        System.out.println(fastSum(100));
    }
}
