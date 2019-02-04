import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int T, ANS, N, M, R, C, L;
    static int[][] A;
    static boolean[][] V;
    static int[][] P = {
            {0,0,0,0,0},
            {0,1,1,1,1},
            {0,1,0,1,0},
            {0,0,1,0,1},
            {0,1,1,0,0},
            {0,0,1,1,0},
            {0,0,0,1,1},
            {0,1,0,0,1}
    };
    static int[][] ck;
    static int[] dr = {0,-1, 0, 1, 0};
    static int[] dc = {0,0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            ANS = 0;
            N = sc.nextInt();
            M = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();
            L = sc.nextInt();
            A = new int[N+1][M+1];
            ck = new int[N+1][M+1];
            V = new boolean[N+1][M+1];
            for (int i = 1; i <=N ; i++) {
                for (int j = 1; j <=M ; j++) {
                    A[i][j] = sc.nextInt();
                }
            }

            V[R+1][C+1] = true;
            ck[R+1][C+1] = 1;
            dfs(1, 1, R+1, C+1);
            V[R+1][C+1] = false;

            for (int i = 1; i <=N ; i++) {
                for (int j = 1; j <=M ; j++) {
                    if(ck[i][j] ==1) ANS++;
                }
            }

            System.out.println("#"+tc+" "+ANS);


        }


    }

    static void dfs(int dept, int max, int r, int c){
        if(dept > L){
            //ANS = Math.max(max, ANS);
            return;
        }else{
            ck[r][c] = 1;
            for (int i = 1; i <=4 ; i++) {
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(nr<1 || nr>N || nc<1||nc>M) continue;
                if(P[A[r][c]][i] != 1 || P[A[nr][nc]][(i-1+2)%4+1]!=1 || V[nr][nc]) continue;
                V[nr][nc] = true;
                dfs(dept+1, max+1, nr, nc);
                V[nr][nc] = false;


            }


        }


    }
}
