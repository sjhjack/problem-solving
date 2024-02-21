import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] dr = {-1,1,0,0,0,0};     // 상하좌우앞뒤
    private static final int[] dc = {0,0,-1,1,0,0};
    private static final int[] dh = {0,0,0,0,1,-1};
    private static int N, M, H, blank;
    private static int[][][] arr;
    private static Queue<Pos> queue = new ArrayDeque<>();
    private static boolean[][][] isVisited;

    private static class Pos {
        int row;
        int col;
        int height;

        public Pos(int row, int col, int height){
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[N][M][H];
        isVisited = new boolean[N][M][H];

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++){
                    arr[j][k][i] = Integer.parseInt(st.nextToken());
                    if(arr[j][k][i] == 1){
                        queue.add(new Pos(j, k, i));
                        isVisited[j][k][i] = true;
                    } else if(arr[j][k][i] == -1){
                        blank++;
                    }
                }
            }
        }
    }

    private static void solve() {
        int count = queue.size();
        int maxCount = N * M * H - blank;
        int date = 0;

        while(!queue.isEmpty() && count != maxCount){
            date++;
            for(int i = queue.size(); i > 0; i--){
                Pos cur = queue.poll();

                for(int d = 0; d < 6; d++){
                    int nr = cur.row + dr[d];
                    int nc = cur.col + dc[d];
                    int nh = cur.height + dh[d];

                    if(nr<0 || nr>=N || nc<0 || nc>=M || nh<0 || nh>=H || isVisited[nr][nc][nh] || arr[nr][nc][nh]==-1){
                        continue;
                    }

                    isVisited[nr][nc][nh] = true;
                    queue.add(new Pos(nr, nc, nh));
                    count++;
                }
            }
        }

        if(count == maxCount) System.out.print(date);
        else System.out.print(-1);
    }
}
