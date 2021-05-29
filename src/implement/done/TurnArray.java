package implement.done;

import java.io.*;
import java.util.*;

public class TurnArray {
    static int N, M, R;
    static int[][] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int groupNum  = Math.min(N, M) / 2;
        ArrayList<Integer>[] groups = new ArrayList[groupNum];
        for(int i=0; i < groupNum; i++) {
            ArrayList<Integer> group = new ArrayList<>();

            for(int n = i; n < M - 1 - i; n++) {
                group.add(arr[i][n]);
            }
            for(int n = i; n < N - 1 - i; n++ ) {
                group.add(arr[n][M-1-i]);
            }
            for(int n = M-i-1; n> i; n--) {
                group.add(arr[N-1-i][n]);
            }
            for(int n = N - i - 1; n > i; n--) {
                group.add(arr[n][i]);
            }

            groups[i] = group;
        }

        for(int i=0; i < groupNum; i++) {
            // arr에 이동한 수 만큼 이동하여 삽입
            int len = groups[i].size();
            int move = R % len;
            int crtIdex = 0;
            for(int n = i; n < M - 1 - i; n++) {
                arr[i][n] = groups[i].get( (move + crtIdex++) % len);
            }
            for(int n = i; n < N - 1 - i; n++) {
                arr[n][M-1-i] = groups[i].get((move + crtIdex++) % len);
            }
            for(int n = M-i-1; n> i; n--) {
                arr[N-1-i][n] = groups[i].get((move + crtIdex++) % len);
            }
            for(int n = N - i - 1; n > i; n--) {
                arr[n][i] = groups[i].get((move + crtIdex++) % len);
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i=0; i < N; i++) {
            for(int j=0; j < M; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

