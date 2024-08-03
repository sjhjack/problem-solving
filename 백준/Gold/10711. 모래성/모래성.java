import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] dr = {-1,-1,-1,0,0,1,1,1};   // 좌상,상,우상,좌,우,좌하,하,우하
    private static final int[] dc = {-1,0,1,-1,1,-1,0,1};

    private static int H, W;
    private static int ans;
    private static int[][] arr;
    private static Queue<Pos> queue = new ArrayDeque<>();

    private static class Pos {
        int row;
        int col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new int[H][W];

        for(int i = 0; i < H; i++) {
            char[] tmp = br.readLine().toCharArray();

            for(int j = 0; j < W; j++) {
                if(tmp[j] == '.') {
                    arr[i][j] = 0;
                    queue.add(new Pos(i, j));
                } else {
                    arr[i][j] = tmp[j] - '0';
                }
            }
        }
    }

    private static void solve() {
        while(!queue.isEmpty()) {
            if(crashWaves()) {
                ans++;
            }
        }

        System.out.print(ans);
    }

    private static boolean crashWaves() {
        boolean isCrashed = false;

        for(int i = queue.size(); i > 0; i--) {
            Pos cur = queue.poll();

            for(int d = 0; d < 8; d++) {
                int nr = cur.row + dr[d];
                int nc = cur.col + dc[d];

                if(nr < 0 || nr >= H || nc < 0 || nc >= W || arr[nr][nc] <= 0 || arr[nr][nc] == 9) {
                    continue;
                }

                if(--arr[nr][nc] == 0) {
                    queue.add(new Pos(nr, nc));
                    isCrashed = true;
                }
            }
        }

        return isCrashed;
    }
}
