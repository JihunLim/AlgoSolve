//https://www.acmicpc.net/problem/1107  - 리모컨

import java.util.Scanner;

public class Main {
    static int N, M, ANS = Integer.MAX_VALUE;
    static int[] btn;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        btn = new int[M+1];
        for (int i = 1; i <=M ; i++) {
            btn[i] = sc.nextInt();
        }

        dfs(0, 5000);



    }

    private static void dfs(int ans, int ch) {
        if(ch == N){
            ANS = Math.min(ans, ANS);
        }else{
            //+버튼
            dfs(ans+1, ch+1);
            //-버튼
            dfs(ans+1, ch-1);




        }

    }


}
