import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static int T, N, M, K, ANS;
    static int[][] A;
    static Queue<Node> que;
    static int[] dr = {0,-1, 1, 0, 0};
    static int[] dc = {0,0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        que = new LinkedList<Node>();
        T = sc.nextInt();
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        A = new int[N][N];
        for (int i = 0; i <K ; i++) {
            Node temp_node = new Node();
            temp_node.r = sc.nextInt();
            temp_node.c = sc.nextInt();
            temp_node.n = sc.nextInt();
            temp_node.w = sc.nextInt();
            que.add(temp_node);
        }

        dfs(0);

        System.out.println(ANS);
    }

    //깊이 : 격리시간
    static void dfs(int dept){
        if(dept >= M){
            //총 균의 수를 구하기
            int min = getTotalNum();
            ANS = Math.min(ANS, min);
            return;
        }else{
            int size = que.size();
            for (int i = 0; i <size ; i++) {
                Node node = que.poll();
                int nr = node.r + dr[node.w];
                int nc = node.c + dc[node.c];
                if(nr<=0 || nr>=N-1 || nc<=0 || nc>=N-1){ // 경계면인 경우
                    node.n /= 2;
                    if(node.n == 0) continue;
                    node.w = n_rotate(node.w);
                }
                A[node.r][node.c]--;
                A[nr][nc]++;
                que.add(node);
            }

            //맵 한곳에서 2개 이상의 군집이 있는 경우
            for (int i = 0; i <N ; i++) {
                for (int j = 0; j <N ; j++) {
                    if(A[i][j] >= 2){
                        size = que.size();
                        Node new_node = new Node(i,j,0,0);
                        int max_nw = Integer.MIN_VALUE;
                        for (int k = 0; k <size; k++) {
                            Node tn = que.poll();
                            if(tn.r == i && tn.c == j){
                                max_nw = Math.max(max_nw, tn.n);
                                new_node.n += tn.n;
                                if(max_nw == tn.n){ //자신이 최대 n값이면
                                    new_node.w = tn.w;
                                }
                            }
                        }
                        que.add(new_node);
                    }

                }
            }

        }

    }

    static int n_rotate(int n){
        // 1-> 2 / 2->1 / 3->4 / 4->3
        int ans=0;
        if(n==1) ans = 2;
        else if(n==2) ans = 1;
        else if(n==3) ans = 4;
        else if(n==4) ans = 3;

        return ans;
    }

    static int getTotalNum(){
        //군집 내 미생물 수 다 더해서 반환
        int ans=0;
        for(Node nd : que){
            ans += nd.n;
        }

        return ans;
    }


    static class Node{
        int r, c, n, w; //세로, 가로, 세균수, 방향
        public Node(){}
        public Node(int r, int c, int n, int w){
            this.r = r;
            this.c = c;
            this.n = n;
            this.w = w;
        }
    }

}
