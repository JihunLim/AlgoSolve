// 백준 9095 - 1,2,3 더하기
// https://www.acmicpc.net/problem/9095
import java.util.Scanner;

public class Main {
    static int T, ANS, N;
    static int[] A = {1,2,3};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while(T-- > 0){
            N = sc.nextInt();
            dfs(1, 0);
            System.out.println(ANS);
            ANS = 0;
        }


    }

    static void dfs(int dept, int sum){
        if(sum == N){
            ANS++;
            return;
        }else if(sum > N) {
            return;
        }else{
            for (int i = 0; i <3 ; i++) {

                dfs(dept+1, sum+A[i]);




            }
        }


    }
}
