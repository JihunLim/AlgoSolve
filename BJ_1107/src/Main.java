//https://www.acmicpc.net/problem/1107  - 리모컨

import java.util.Scanner;

public class Main {
    static int N, M, ANS = Integer.MAX_VALUE;
    static int[] btn;
    static boolean chk = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        btn = new int[M+1];
        for (int i = 1; i <=M ; i++) {
            btn[i] = sc.nextInt();
        }

        dfs(0, 100);
        System.out.println(ANS);


    }

    private static void dfs(int ans, int ch) {
        if(ch == N){
            ANS = Math.min(ans, ANS);
            chk = true;
            return;
        }else if(ch >= 500000){
            return;
        }else{
            //+버튼
            dfs(ans+1, ch+1);
            //-버튼
            if(!chk){
                dfs(ans+1, ch-1);
                for (int i = 0; i <= 500000; i++) {
                    //채널 누를수 있는지 검사
                    if(chkCH(i)){
                        //가능하면
                        dfs(ans+1, i);
                    }

                }

            }

        }

    }

    static boolean chkCH(int i){
        boolean res = true;
        String stmp = String.valueOf(i);
        //int[] tmp = stmp.
        for(int ti : btn){
            if(stmp.contains(String.valueOf(ti))){
                res = false;
                return res;
            }
        }
        return res;
    }


}
