package jongmanbook.Chap08;

import java.util.Scanner;

public class JLIS {
    static int A, B;
    static int[] aArr;
    static int[] bArr;
    static int[][] cache;
    static int NEGINF = Integer.MIN_VALUE;
    // 입력이 32비트 부호 있는 정수의 모든 값을 가질 수 있기 때문에
    // 인위적으로 최소치는 64비트 여야함

    // min(aArr[indexA], bArr[indexB], max(aArr[indexA], bArr[indexB])로 시작하는
    // 합친 증가 부분 수열의 최대 길이를 반환한다.
    // 단 indexA == indexB == -1 혹은 aArr[indexA] != bArr[indexB]라고 가정한다.

    static int jlis(int indexA, int indexB) {
        // 메모이제이션
        if(cache[indexA+1][indexB+1] != -1)
            return cache[indexA+1][indexB+1];

        // A[indexA], B[indexB]가 이미 존재하므로 2개는 항상 있다.
        cache[indexA+1][indexB+1] = 2;
        int a = ((indexA == -1) ? NEGINF : aArr[indexA]);
        int b = ((indexB == -1) ? NEGINF : bArr[indexB]);
        int maxElement = Math.max(a, b);
        // 다음 원소를 찾음
        for(int nextA = indexA + 1; nextA < A; ++nextA)
            if(maxElement < aArr[nextA])
                cache[indexA+1][indexB+1] = Math.max(cache[indexA+1][indexB+1], jlis(nextA, indexB) + 1);
        for(int nextB = indexB + 1; nextB < B; ++nextB)
            if(maxElement < bArr[nextB])
                cache[indexA+1][indexB+1] = Math.max(cache[indexA+1][indexB+1], jlis(indexA, nextB) + 1);
        return cache[indexA+1][indexB+1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        while(C-- > 0){
            A = sc.nextInt(); B = sc.nextInt();
            aArr = new int[A]; bArr = new int[B];
            cache = new int[A+1][B+1];
            for(int i=0; i < A; i++)
                aArr[i] = sc.nextInt();
            for(int i=0; i < B; i++)
                bArr[i] = sc.nextInt();

            for(int i=0; i<A+1; i++)
                for(int j=0; j<B+1; j++)
                    cache[i][j] = -1;

            System.out.println(jlis(-1, -1)-2);

        }

    }
}
