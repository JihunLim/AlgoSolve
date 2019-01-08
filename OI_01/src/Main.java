import java.util.Scanner;

//01차시 과제 - 이분탐색 코딩하기
public class Main {
    static int N, ANS, K;
    static int[] A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        A = new int[N+1];
        for (int i = 1; i <=N ; i++) {
            A[i] = sc.nextInt();
        }
        discover(1, N);

        if(ANS != -1) System.out.println(ANS + "번 째, 값 : "+A[ANS]);
        else System.out.println(ANS);

    }

    static void discover(int s, int e){
        int m = (s+e)/2;
        if(s-e <= 0) {
            if (A[m] == K) {
                ANS = m;
                return;
            } else {
                if (A[m] < K) {
                    discover(m + 1, e);
                } else {
                    discover(s, m - 1);
                }
            }
        }else{
            ANS = -1;
        }
    }

}
