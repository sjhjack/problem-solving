import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1,0,1,0};    // 북동남서
    static final int[] dc = {0,1,0,-1};

    static int N, M;
    static int[][] arr;
    static int row, col, dir;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        int ans = 0;

        while(true) {
            // 현재 칸 청소
            if(arr[row][col] == 0) {
                arr[row][col] = 2;
                ans++;
            }

            if(needClean()) {
                dir = (dir + 3) % 4;
                moveOneStep();
            } else {
                if(canMoveBackward()) {
                    row = row + dr[(dir + 2) % 4];
                    col = col + dc[(dir + 2) % 4];
                } else {
                    break;
                }
            }
        }

        System.out.print(ans);
    }

    // 주변 4칸 중 청소되지 않은 칸이 있는지 리턴
    static boolean needClean() {
        return (row - 1 >= 0 && arr[row - 1][col] == 0) ||
            (row + 1 < N && arr[row + 1][col] == 0) ||
            (col - 1 >= 0 && arr[row][col - 1] == 0) ||
            (col + 1 < M && arr[row][col + 1] == 0);
    }

    // 앞으로 한 칸 전진
    static void moveOneStep() {
        int nr = row + dr[dir];
        int nc = col + dc[dir];

        if(nr >= 0 && nr < N && nc >= 0 && nc < M && arr[nr][nc] == 0) {
            row = nr;
            col = nc;
        }
    }

    // 뒤로 한 칸 움직일 수 있는지 리턴
    static boolean canMoveBackward() {
        int nr = row + dr[(dir + 2) % 4];
        int nc = col + dc[(dir + 2) % 4];

        return nr >= 0 && nr < N && nc >= 0 && nc < M && arr[nr][nc] != 1;
    }
}
