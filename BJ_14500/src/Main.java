import java.util.Scanner;

public class Main {
    static int N, M, ANS = Integer.MIN_VALUE;
    static int[][] A;
    static boolean[][] check;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N+1][M+1];
        check = new boolean[N+1][M+1];
        for (int i = 1; i <=N; i++) {
            for (int j = 1; j <=M; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        for (int r = 1; r <=N ; r++) {
            for (int c = 1; c <=M ; c++) {
                check[r][c] = true;
                dfs(A[r][c], 1, r, c);
                check[r][c] = false;
                solve(A[r][c], r, c);
            }
        }

        System.out.println(ANS);


    }

    private static void solve(int sum, int r, int c) {
        int wing = 4, min = Integer.MAX_VALUE, s=sum;
        int ss = A[r][c];
        for (int i = 0; i <4 ; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(wing <= 2) return;

            if(nr <1 || nr>N || nc<1 || nc>M){
                wing--; continue;
            }
            min = Math.min(min, A[nr][nc]);
            ss += A[nr][nc];
            s += A[nr][nc];
        }



        if(wing == 4) {
            ss -=min;
            s -= min;
        }
        ANS = Math.max(ANS, s);

    }

    private static void dfs(int sum, int dept, int r, int c) {
        if(dept >=4){
            ANS = Math.max(ANS, sum);
            return;
        }else{

            for (int i = 0; i <4 ; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                //check out the boundary & dup
                if(nr <1 || nr>N || nc<1 || nc>M) continue;
                if(check[nr][nc]) continue;

                check[nr][nc] = true;
                dfs(sum + A[nr][nc], dept+1, nr, nc);
                check[nr][nc] = false;




            }








        }


    }

}
