import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Solution {
    static int T, N, K, ANS;
    static int[][] A;
    static boolean[][] V;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        int index = 1;
        while(T-- > 0) {
            int max = Integer.MIN_VALUE;
            Queue<Node> que = new LinkedList<Node>();
            N = sc.nextInt();
            K = sc.nextInt();
            A = new int[N + 1][N + 1];
            V = new boolean[N+1][N+1];
            ANS = 0;
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
                V[node.r][node.c] = true;
                dfs(1,0, node, true);
                V[node.r][node.c] = false;
            }


            System.out.println("#"+index++ + " " + ANS);



        }

    }

    static void dfs(int dept, int max, Node node, boolean check){

        ANS = Math.max(ANS, dept);

        for (int i = 0; i < 4; i++) {
            int nr = node.r + dr[i];
            int nc = node.c + dc[i];

            //밖으로 벗어나거나 / 이미 간 곳일 경우 패스
            if(nr<1||nr>N||nc<1||nc>N || V[nr][nc]) continue;

            //높이가 같거나 높아서 가지 못하는 경우 && 깍을 수 있을경우
            if(A[nr][nc] >= A[node.r][node.c]){
                if(check){
                    //k까지 하나씩 깍으면서 갈 수 있는지 확인
                    //갈 수 있으면 -> dfs(dept+1, max, new Node(nr, nc, A[nr][nc]), false);
                    int temp_k = A[nr][nc];
                    for (int j = 1; j <=K ; j++) {

                        if((A[nr][nc] - j) < A[node.r][node.c]){
                            A[nr][nc] -= j;
                            V[nr][nc] = true;
                            dfs(dept+1, max, new Node(nr, nc, A[nr][nc]), false);
                            A[nr][nc] = temp_k;
                            V[nr][nc] = false;
                            break;
                        }
                    }
                }


                continue;

            }

            //그냥 갈 수 있는 경우
            V[nr][nc] = true;
            dfs(dept+1, max, new Node(nr, nc, A[nr][nc]), check);
            V[nr][nc] = false;


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
