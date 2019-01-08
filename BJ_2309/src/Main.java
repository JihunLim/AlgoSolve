//BJ_2309 일곱 난쟁이

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] A, ANS, ANS2;
    static int p=1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = new int[10];
        ANS = new int[8];
        ANS2 = new int[8];
        for (int i = 1; i <=9 ; i++) {
            A[i] = sc.nextInt();
        }

        solve(1, 0, 1);
        Arrays.sort(ANS2);


        for (int i = 1; i <= 7 ; i++) {
            System.out.println(ANS2[i]);
        }


    }

    static void solve(int num, int sum, int chk){
        if(chk > 7){
            if(sum == 100) {
                for (int i = 1; i <=7 ; i++) {
                    ANS2[i] = ANS[i];
                }

                return;
            }
            return;
        }else{
            for (int i = num; i <= 9 ; i++) {
                ANS[p] = A[i]; p++;
                solve(i+1, sum+A[i], chk+1);
                p--;
            }



        }

    }

}
