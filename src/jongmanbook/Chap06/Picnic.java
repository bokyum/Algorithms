package jongmanbook.Chap06;

import java.io.IOException;
import java.util.Scanner;

/*
INPUT
---------------------------
3    테스트 케이스의 수 C (C <= 50)
2 1  n (2 <= n <= 10) 과 친구 쌍의 수 m (0 <= m <= n*(n-1)/2)
0 1  다음 줄에 m 개의 정수 쌍으로 서로 친구인 두 학생의 번호가 주어집니다. 번호는 모두 0 부터 n-1 사이의 정수이고, 같은 쌍은 입력에 두 번 주어지지 않습니다

4 6
0 1 1 2 2 3 3 0 0 2 1 3

6 10
0 1 0 2 1 2 1 3 1 4 2 3 2 4 3 4 3 5 4 5
OUTPUT
------------------------------
1
3
4
* */
public class Picnic {
/*
    static int countPairs(boolean[] taken, int N, boolean[][] friends) { // 중복을 세기 때문에 오답
        boolean finished = true;
        for(int i = 0; i < N; i++)
            if(!taken[i])
                finished = false;
        if(finished)
            return 1;
        int ret = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++) {
                if(!taken[i] && !taken[j] && friends[i][j] ) {
                    taken[i] = taken[j] = true;
                    ret += countPairs(taken, N, friends);
                    taken[i] = taken[j] = false;
                }
            }
        }
        return ret;
    }
*/

    static boolean[][] friends;
    static int N;
    static int M;

    static int countPairs1(boolean[] taken){
        // 남은 학생들 중 가장 번호가 빠른 학생을 찾는다.
        int firstFree = -1;
        for(int i = 0; i < N; i++) {
            if(!taken[i]){
                firstFree = i;
                break;
            }
        }
        // 기저 사례: 모든 학생이 짝을 찾았으면 한 가지 방법을 찾았으니 종료한다.
        if(firstFree==-1) return 1;
        int ret = 0;
        for(int pairWith = firstFree+1; pairWith < N; pairWith++){
            if(!taken[pairWith] && friends[firstFree][pairWith]) {
                taken[firstFree] = taken[pairWith] = true;
                ret += countPairs1(taken);
                taken[firstFree] = taken[pairWith] = false;
            }
        }
        return ret;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(System.in);
        int C = scanner.nextInt();
        //scanner.nextLine(); // scanner buffer clear
        int[] ans = new int[C];
        
        for (int i = 0; i < C; ++i) {
            N = scanner.nextInt();
            M = scanner.nextInt();

            friends = new boolean[N][N];
            boolean[] taken = new boolean[N];
            
            for(int j=0; j < M; j++)
                friends[scanner.nextInt()][scanner.nextInt()] = true;
            ans[i] = countPairs1(taken);
        }
        for(int a: ans)
            System.out.println(a);

    }

    /*
     	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			boolean[][] relation = new boolean[N][N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int t = Integer.parseInt(st.nextToken());
				int f = Integer.parseInt(st.nextToken());

				relation[t][f] = relation[f][t] = true;
			}

			boolean[] check = new boolean[N];
			sb.append(recursion(check, relation, N) + "\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
     */
}
