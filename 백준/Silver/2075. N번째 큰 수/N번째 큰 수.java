import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static int[][] arr;

    static class Pos implements Comparable<Pos> {
        int row;
        int col;
        int value;

        public Pos(int row, int col, int value){
            this.row = row;
            this.col = col;
            this.value = value;
        }

        @Override
        public int compareTo(Pos o){
            return o.value - value;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void solve() {
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        int cnt = 0;

        for(int i = 0; i < N; i++){
            pq.add(new Pos(N-1, i, arr[N-1][i]));
        }

        while(cnt++ < N - 1){
            Pos cur = pq.poll();
            
            if(cur.row - 1 >= 0){
                pq.add(new Pos(cur.row - 1, cur.col, arr[cur.row - 1][cur.col]));
            }
        }

        System.out.print(pq.poll().value);
    }
}
