package bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class Sudominoku {
    static int N = 9;
    static int[][] A;
    static boolean[][] checkX;
    static boolean[][] checkY;
    static boolean[][] checkCell;
    static boolean[][] domino;
    static int[] dy = {1, 0};
    static int[] dx = {0, 1};
    static boolean canPut(int y, int x, int value) {

        if(checkX[y][value])
            return false;
        if(checkY[x][value])
            return false;
        if(checkCell[(y/3)*3 + (x/3)][value])
            return false;
        return true;
    }

    static boolean solve(int z) {
        if(z == 81) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(A[i][j]);
                }
                System.out.println();
            }
            return true;
        }

        int y = (z / 9);
        int x = z % 9;

        if(A[y][x] != 0) {
            return solve(z + 1);
        }
        else {
            for(int i=1; i <= 9; i++) {
                for(int j=1; j <=9; j++) {
                    if(i == j)
                        continue;
                    if(domino[i][j] || domino[j][i])
                        continue;
                    for(int k=0; k < 2; k++) {
                        int ny = y + dy[k];
                        int nx = x + dx[k];
                        if(ny < 0 || ny >= N || nx < 0 || nx >= N)
                            continue;
                        if(A[ny][nx] != 0)
                            continue;
                        if(canPut(y, x, i) && canPut(ny, nx, j)) {
                            A[y][x] = i;
                            A[ny][nx] = j;
                            checkX[y][i] = checkY[x][i] =
                                    checkCell[(y/3) * 3 + (x/3)][i] = true;
                            checkX[ny][j] = checkY[nx][j] =
                                    checkCell[(ny/3) * 3 + (nx/3)][j] = true;
                            domino[i][j] = domino[j][i] = true;
                            if(solve(z+1))
                                return true;
                            A[y][x] = 0;
                            A[ny][nx] = 0;
                            checkX[y][i] = checkY[x][i] =
                                    checkCell[(y/3) * 3 + (x/3)][i] = false;
                            checkX[ny][j] = checkY[nx][j] =
                                    checkCell[(ny/3) * 3 + (nx/3)][j] = false;
                            domino[i][j] = domino[j][i] = false;
                        }
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int crt = 1;
        while(true) {
            int K = Integer.parseInt(br.readLine());
            if (K == 0)
                break;

            A = new int[10][10];
            checkX = new boolean[10][10];
            checkY = new boolean[10][10];
            checkCell = new boolean[10][10];
            domino = new boolean[10][10];

            for (int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int[] temp = new int[2];
                for (int j = 0; j < 2; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    String s = st.nextToken();
                    int y = s.charAt(0) - 'A';
                    int x = s.charAt(1) - '1';
                    A[y][x] = value;
                    checkX[y][value] = true;
                    checkY[x][value] = true;
                    checkCell[(y / 3) * 3 + (x / 3)][value] = true;
                    temp[j] = value;

                }
                domino[temp[0]][temp[1]] = true;
                domino[temp[1]][temp[0]] = true;
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 9; i++) {
                String s = st.nextToken();
                int y = s.charAt(0) - 'A';
                int x = s.charAt(1) - '1';
                A[y][x] = i;
                checkX[y][i] = true;
                checkY[x][i] = true;
                checkCell[(y / 3) * 3 + (x / 3)][i] = true;
            }

            System.out.println("Puzzle " + crt++);
            solve(0);


        }
    }
}
