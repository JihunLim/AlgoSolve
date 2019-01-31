import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Solution {
    static int T, N, K, ANS;
    static int[][] A;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while(T-- > 0) {
            int max = Integer.MIN_VALUE;
            Queue<Node> que = new LinkedList<Node>();
            N = sc.nextInt();
            K = sc.nextInt();
            A = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    A[i][j] = sc.nextInt();
                    max = Math.max(max, A[i][j]);
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(A[i][j] == max)
                        que.add(new Node(i,j,A[i][j]));
                }
            }

            for(Node node : que){
                dfs();
            }


            System.out.println(ANS);




        }
        
    }

    static void dfs(int dept, int max, Node node){

        ANS = Math.max(ANS, dept);

        for (int i = 0; i < 4; i++) {
            int nr =


        }


    }

    static class Node{
        int r,c,k;
        public Node(int r, int c, int k){
            this.r = r;
            this.c = c;
            this.k = k;
        }
    }
}
