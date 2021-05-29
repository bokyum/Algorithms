package implement.done;

import java.io.*;
import java.util.StringTokenizer;

public class B16935 {
    static int N, M; // y축 x축
    static int[][] arr;

    public static void solve(int input) {
        if(input == 1) {
            firstCase();
        }
       else if(input == 2) {
           secondCase();
        }
        else if(input == 3) {
            thirdCase();
        }
        else if(input == 4) {
            quadCase();
        }
        else if(input == 5) {
            fifthCase();
        }else if(input == 6) {
            sixthCase();
        }
    }

    private static void firstCase() {
        int bottom = 0;
        int top = N-1;
        while(bottom < top) {
            for(int i=0; i < M; i++) {
                int temp = arr[bottom][i];
                arr[bottom][i] = arr[top][i];
                arr[top][i] = temp;
            }
            bottom++;
            top--;
        }
    }

    private static void secondCase() {
        int left = 0;
        int right = M-1;
        while(left < right) {
            for(int i=0; i < N; i++) {
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
            }
            left++;
            right--;
        }

    }

    private static void thirdCase() {
        int[][] temp = new int[M][N];
        for(int i=0; i < N; i++) {
            for(int j=0; j < M; j++) {
                temp[j][N-1-i] = arr[i][j];
            }
        }
        arr = temp;
        int tInt = M;
        M = N;
        N = tInt;
    }

    private static void quadCase() {
        int[][] temp = new int[M][N];
        for(int i=0; i < N; i++) {
            for(int j=0; j < M; j++) {
                temp[j][i] = arr[i][M - j - 1];
            }
        }
        arr = temp;
        int tInt = M;
        M = N;
        N = tInt;
    }

    private static void fifthCase() {
        int[][] temp = new int[N][M];
        for(int i=0; i < N/2; i++) {
            for(int j=0; j < M/2; j++) {
                temp[i][j+M/2] = arr[i][j];
                temp[i][j] = arr[i+N/2][j];
                temp[i+N/2][j+M/2] = arr[i][j+M/2];
                temp[i+N/2][j] = arr[i+N/2][j+M/2];
            }
        }
        arr = temp;
    }

    private static void sixthCase() {
        int[][] temp = new int[N][M];
        for(int i=0; i < N/2; i++) {
            for(int j=0; j < M/2; j++) {
                temp[i+N/2][j] = arr[i][j];
                temp[i+N/2][j+M/2] = arr[i+N/2][j];
                temp[i][j+M/2] = arr[i+N/2][j+M/2];
                temp[i][j] = arr[i][j+M/2];
            }
        }
        arr = temp;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        // inputData
        for(int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < R; i++) {
            int input = Integer.parseInt(st.nextToken());
            solve(input);
        }

        for(int i=0; i < arr.length; i++) {
            for(int j=0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
