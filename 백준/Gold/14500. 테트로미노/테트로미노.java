import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};
    
    static int N, M;
    static int[][] arr;
    static boolean[][] isVisited;
    static int ans;
    
    public static void main(String[] args) throws IOException {
        init();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                solve(i, j, 0, 0);
            }
        }
        
        System.out.print(ans);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        isVisited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve(int row, int col, int count, int sum) {
        sum += arr[row][col];
        count++;
        
        if(count == 4) {
            ans = Math.max(ans, sum);
            return;
        }
        
        isVisited[row][col] = true;
        
        if(count == 1) {
            if(row-1 >= 0 && col+1 < M && row+1 < N) {
                ans = Math.max(ans, sum + arr[row-1][col] + arr[row][col+1] + arr[row+1][col]);
            }
            if(col-1 >= 0 && col+1 < M && row+1 < N) {
                ans = Math.max(ans, sum + arr[row][col-1] + arr[row][col+1] + arr[row+1][col]);
            }
            if(row-1 >= 0 && col-1 >= 0 && row+1 < N) {
                ans = Math.max(ans, sum + arr[row-1][col] + arr[row][col-1] + arr[row+1][col]);
            }
            if(row-1 >= 0 && col-1 >= 0 && col+1 < M) {
                ans = Math.max(ans, sum + arr[row-1][col] + arr[row][col-1] + arr[row][col+1]);
            }
        }

        for(int d = 0; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M || isVisited[nr][nc]) {
                continue;
            }

            solve(nr, nc, count, sum);
        }

        isVisited[row][col] = false;
    }
}
