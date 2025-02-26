import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1,1,0,0};    // 상하좌우
    static final int[] dc = {0,0,-1,1};
    
    static int N, K, S, X, Y;
    static int[][] arr;
    static PriorityQueue<Pos> pq;

    static class Pos implements Comparable<Pos> {
        int row;
        int col;
        int number;

        public Pos(int row, int col, int number) {
            this.row = row;
            this.col = col;
            this.number = number;
        }

        @Override
        public int compareTo(Pos o) {
            return number - o.number;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.print(arr[X][Y]);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] > 0) {
                    pq.add(new Pos(i, j, arr[i][j]));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        Y = Integer.parseInt(st.nextToken()) - 1;
    }

    static void solve() {
        Queue<Pos> queue = new ArrayDeque<>();
        int time = 1;

        while(time <= S && arr[X][Y] == 0) {
            while(!pq.isEmpty()) {
                Pos cur = pq.poll();

                for(int d = 0; d < 4; d++) {
                    int nr = cur.row + dr[d];
                    int nc = cur.col + dc[d];

                    if(isInvalid(nr, nc)) {
                        continue;
                    }

                    arr[nr][nc] = cur.number;
                    queue.add(new Pos(nr, nc, cur.number));
                }
            }

            while(!queue.isEmpty()) {
                pq.add(queue.poll());
            }

            time++;
        }
    }

    static boolean isInvalid(int row, int col) {
        return row < 0 || row >= N || col < 0 || col >= N || arr[row][col] > 0;
    }
}
