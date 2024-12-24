import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {0,1,0,-1};   // 좌하우상
    static final int[] dc = {-1,0,1,0};

    // 1, 1, 7, 7, 2, 2, 10, 10, 5 %
    static final int[][] drn = {
        {-1,1,-1,1,-2,2,-1,1,0},
        {-1,-1,0,0,0,0,1,1,2},
        {-1,1,-1,1,-2,2,-1,1,0},
        {1,1,0,0,0,0,-1,-1,-2}
    };

    static final int[][] dcn = {
        {1,1,0,0,0,0,-1,-1,-2},
        {-1,1,-1,1,-2,2,-1,1,0},
        {-1,-1,0,0,0,0,1,1,2},
        {1,-1,1,-1,2,-2,1,-1,0}
    };

    static final int[] ratio = {1,1,7,7,2,2,10,10,5};
    
    static int N;
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        int row = N / 2;
        int col = N / 2 - 1;
        int dir = 0;
        int len = 1;
        int curLen = 0;
        int cnt = 2;
        int ans = 0;

        while(true) {
            curLen++;
            int sand = arr[row][col];
            int sumSpreadSand = 0;

            for(int d = 0; d < 9; d++) {
                int nr = row + drn[dir][d];
                int nc = col + dcn[dir][d];
                int spreadSand = (sand * ratio[d]) / 100;

                if(outOfRange(nr, nc)) {
                    ans += spreadSand;
                } else {
                    arr[nr][nc] += spreadSand;
                }

                sumSpreadSand += spreadSand;
            }

            int alphaRow = row + dr[dir];
            int alphaCol = col + dc[dir];
            int alpha = sand - sumSpreadSand;
            
            if(outOfRange(alphaRow, alphaCol)) {
                ans += alpha;
            } else {
                arr[alphaRow][alphaCol] += alpha;
            }

            if(row == 0 && col == 0) {
                break;
            }

            if(curLen == len) {
                cnt--;
                
                if(cnt == 0) {
                    cnt = 2;
                    len++;
                }
                
                curLen = 0;
                dir = (dir + 1) % 4;
            }
            
            row = row + dr[dir];
            col = col + dc[dir];
        }

        System.out.print(ans);
    }

    static boolean outOfRange(int row, int col) {
        return row < 0 || row >= N || col < 0 || col >= N;
    }
}
