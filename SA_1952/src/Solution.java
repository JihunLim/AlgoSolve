//SA_1952. 수영장
//https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpFQaAQMDFAUq

import java.util.Scanner;

public class Solution {
    static int T, ANS;
    static int[] P, A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int gc = 1; gc <= T ; gc++) {
            P = new int[4];
            A = new int[12];
            ANS = Integer.MAX_VALUE;
            for (int i = 0; i <4 ; i++) {
                P[i] = sc.nextInt();
            }
            for (int i = 0; i <12 ; i++) {
                A[i] = sc.nextInt();
            }

            dfs(0, 0);

            System.out.println("#"+gc+" "+ANS);
        }

    }

    static void dfs(int dept, int min){
        if(dept >= 12){
            ANS = Math.min(min, ANS);
            return;
        }else{
            for (int i = 0; i <4 ; i++) {


                if(A[dept] > 0) {
                    if (i == 0 || i == 1) dfs(dept + 1, min + solve(dept, i));
                    else if (i == 2) dfs(dept + 3, min + solve(dept, i));
                    else if (i == 3) dfs(dept + 12, min + solve(dept, i));
                }else{
                    if(A[dept] == 0) dfs(dept+1, min);
                }
                //solve(dept, i)
            }


        }
    }

    static int solve(int dept, int num){
        int ans = 0;
        if(num == 0) {
            ans = (A[dept] * P[0]);
        }else if(num == 1){
            ans = P[1];
        }else if(num ==2){
            ans = P[2];
        }else if(num == 3){
            ans = P[3];
        }
        return ans;
    }

}
