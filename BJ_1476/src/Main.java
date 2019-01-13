import java.util.Scanner;

public class Main {
    static int[] A;
    static int ANS;
    static int E = 15, S = 28, M = 19;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = new int[4];
        for (int i = 1; i <=3 ; i++) {
            A[i] = sc.nextInt();
        }

        solve();
        System.out.println(ANS+1);
    }

    private static void solve() {
        int y=1, i=0;
        while(true){
            y = i*E + A[1] - 1;
            if(y%S == (A[2]-1)){
                if(y%M == (A[3]-1)){
                    ANS = y;
                    break;
                }
            }
            i++;


        }

    }


}
