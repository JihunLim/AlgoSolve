import java.util.Scanner;

public class Solution {
    static int T, ANS, D,W,K;
    static int[][] A;
    static int[] M;
    static boolean[] V;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int tc = 1; tc <=T ; tc++) {
            ANS = Integer.MAX_VALUE;
            D = sc.nextInt();
            W = sc.nextInt();
            K = sc.nextInt();
            A = new int[D+1][W+1];
            V = new boolean[D+1];
            M = new int[D+1];
            for (int i = 1; i <=D ; i++) {
                for (int j = 1; j <=W ; j++) {
                    A[i][j] = sc.nextInt();
                }
            }
            if(K == 1) ANS = 0;
            else
            dfs(1, 0);

            System.out.println("#"+tc+" "+ANS);
        }


    }

    /*
        깊이 : 선택하는 개수
        첫번째 dfs -> 약 투여 횟수를 정한다.
        두번째 dfs -> a or b를 전체순열로 정한후 solve함수로 넘긴다.
        solve() -> 모든 w길이의 필름이 k만큼 연속되는지 확인
     */
    static void dfs(int dept, int min){
        if(min >= ANS){
            return;
        }

        if(dept > D){
            int[][] temp = new int[D+1][W+1];
            for (int i = 1; i <=D ; i++) {
                if(M[i] == 1){
                    for (int j = 1; j <=W ; j++) {
                        temp[i][j] = 0;
                    }
                }else if(M[i] == 2){
                    for (int j = 1; j <=W ; j++) {
                        temp[i][j] = 1;
                    }
                }else{
                    for (int j = 1; j <=W ; j++) {
                        temp[i][j] = A[i][j];
                    }
                }

            }

            if(solve(temp, min)) ANS = Math.min(ANS, min);
            return;
        }


        //시약투여 없음
        M[dept] = 0;
        dfs(dept+1, min);

        // A시약투여
        M[dept] = 1;
        dfs(dept+1, min+1);

        // B시약투여
        M[dept] = 2;
        dfs(dept+1, min+1);


        
    }

    private static boolean solve(int[][] temp, int min) {
        int num = 0, check = 0;
        int n_chk = 0;
        boolean ans = true;

        for (int i = 1; i <=W ; i++) {
            num = 0;
            n_chk = 0;
            if(check < i-1) break; //안되는 경우 미리 끝내기
            for (int j = 1; j <=D ; j++) {
                if(n_chk == temp[j][i]){
                    num++;
                }else{
                    num = 1;
                    n_chk = (n_chk+1)%2; // 다른걸로 변경
                }

                if(num >= K){
                    check++;
                    break;
                }
            }
        }

        if(check == W) ans = true;
        else ans = false;



        return ans;
    }

}
