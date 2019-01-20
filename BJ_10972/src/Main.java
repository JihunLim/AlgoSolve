import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] A, ANS;
    static boolean check = true;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N  =sc.nextInt();
        A = new int[N+1];
        ANS = new int[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }

        //int[] arr = new int[N+1];
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Queue<Integer> arr2 = new LinkedList<Integer>();
        dfs(1, arr);

        for(int t : ANS){
            if(t == 0) continue;
            //System.out.println(t+" ");
        }



    }

    static void dfs(int dept, ArrayList<Integer> arr){
        if(dept > N){
            for (int i = 1; i <= N ; i++) {
                System.out.print(arr.get(i)+" ");
                if(arr.get(i) != A[i]) {
                    check = false;
                }
            }
            System.out.println();
            return;
        }else{
            for (int i = 1; i <=N ; i++) {

                arr.add(dept, i);
                dfs(dept+1, arr);


            }
        }


    }
}
