import java.util.*;

public class Solution {
    static int T, N, ANS;
    static int[][] A;
    static boolean[][] visited;
    static ArrayList<P> Qp;
    static ArrayList<S> Qs;
    static int[] MM;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        while(T-- > 0){
            ANS = Integer.MAX_VALUE;
            Qp = new ArrayList<P>();
            Qs = new ArrayList<S>();
            N = sc.nextInt();
            A = new int[N+1][N+1];
            for (int i = 1; i <=N ; i++) {
                for (int j = 1; j <=N ; j++) {
                    A[i][j] = sc.nextInt();
                    if(A[i][j] == 1)
                        Qp.add(new P(i,j));
                    else if(A[i][j] > 1)
                        Qs.add(new S(i,j,A[i][j]));
                }
            }
            MM = new int[Qp.size()];

            dfs(0,0);



        }

    }

    static void solve(){
        //1. 사람큐를 정렬
        Collections.sort(Qp, new Comparator<P>(){
            @Override
            public int compare(P p1, P p2){
                if(p1.tt < p2.tt) return -1;
                else if(p1.tt > p2.tt) return 1;
                else return 0;
            }
        });

        //2.
        while(!Qp.isEmpty()){
            for(P tp : Qp) {
                if (tp.ls == 0) {
                    //첫번재 계단으로 이동하는 사람


                }
            }

        }

    }

    static void dfs(int dept, int min){
        if(dept >= Qp.size()){
            ANS = Math.min(ANS, min);
            solve();
            return;
        }else{
            for (int i = 0; i <Qs.size() ; i++) {
                MM[dept] = i;
                S s = Qs.get(i);
                P p = Qp.get(dept);
                int ans = Math.abs(p.r-s.r) + Math.abs(p.c-s.c); //이동시간
                p.tt = ans+1;
                p.ls = i; p.status = s.time;

//                if(!p.life) continue;
//                //계단위에 3명 이하인 경우 이동가능
//
//                p.r = s.r;  p.c = s.c; p.ls = s.time;
//                int ans = Math.abs(p.r-s.r) + Math.abs(p.c-s.c); //이동시간
//                p.tt = ans;
//                //계단을 내려갈 수 있는 경우 큐에서 제외
//
//                ans += s.time + 1;
//                p.esc();


                dfs(dept+1, min);



            }

        }

    }

    static class P{
        int r, c, ls, tt, status;
        boolean life = true;
        public P(int r, int c){
            this.r = r;
            this.c = c;
        }

        public void esc(){
            life = false;
        }
    }

    static class S{
        int r, c, time;
        Queue<P> que = new LinkedList<P>();
        public S(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }

        public void que_add(P p){
            if(que.isEmpty()) {
                que.add(p);
            }else{
                //시간 고려해서 삭제 및 추가
                for(P tp : que){
                    tp.ls = p.ls -

                }
            }
        }
    }


}
